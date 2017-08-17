package io.auxo.roundrect;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class RoundRectShapeHelper {

    protected DisplayMetrics mMetrics;
    protected RoundRectAttrsDelegate mAttrsDelegate;

    private TypedValue innerTopLeftRadius = new TypedValue();
    private TypedValue innerTopRightRadius = new TypedValue();
    private TypedValue innerBottomLeftRadius = new TypedValue();
    private TypedValue innerBottomRightRadius = new TypedValue();
    private TypedValue outerTopLeftRadius = new TypedValue();
    private TypedValue outerTopRightRadius = new TypedValue();
    private TypedValue outerBottomLeftRadius = new TypedValue();
    private TypedValue outerBottomRightRadius = new TypedValue();
    private float borderPaddingLeft = 0;
    private float borderPaddingTop = 0;
    private float borderPaddingRight = 0;
    private float borderPaddingBottom = 0;
    private float borderWidth = 0;
    private int borderColor = Color.TRANSPARENT;
    private int background = Color.TRANSPARENT;

    public RoundRectShapeHelper(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, RoundRectAttrsDelegate delegate) {

        mAttrsDelegate = delegate;

        final Resources.Theme theme = context.getTheme();

        mMetrics = context.getResources().getDisplayMetrics();

        TypedArray a = theme.obtainStyledAttributes(attrs, mAttrsDelegate.getName(), defStyleAttr, defStyleRes);

        background = a.getColor(mAttrsDelegate.getBackgroundColor(), background);

        borderWidth = a.getDimension(mAttrsDelegate.getBorderWidth(), borderWidth);
        borderColor = a.getColor(mAttrsDelegate.getBorderColor(), borderColor);

        float borderPadding = -1;

        borderPadding = a.getDimension(mAttrsDelegate.getBorderPadding(), borderPadding);

        if (borderPadding >= 0) {
            borderPaddingLeft = borderPadding;
            borderPaddingTop = borderPadding;
            borderPaddingRight = borderPadding;
            borderPaddingBottom = borderPadding;
        } else {
            borderPaddingLeft = a.getDimension(mAttrsDelegate.getBorderPaddingLeft(), borderPaddingLeft);
            borderPaddingTop = a.getDimension(mAttrsDelegate.getBorderPaddingTop(), borderPaddingTop);
            borderPaddingRight = a.getDimension(mAttrsDelegate.getBorderPaddingRight(), borderPaddingRight);
            borderPaddingBottom = a.getDimension(mAttrsDelegate.getBorderPaddingBottom(), borderPaddingBottom);
        }

        TypedValue radius = new TypedValue();
        TypedValue bottomLeftRadius = new TypedValue();
        TypedValue bottomRightRadius = new TypedValue();
        TypedValue topLeftRadius = new TypedValue();
        TypedValue topRightRadius = new TypedValue();

        radius.setTo(peekValue(a, mAttrsDelegate.getRadius()));

        if (radius.type != TypedValue.TYPE_NULL) {
            topLeftRadius.setTo(radius);
            topRightRadius.setTo(radius);
            bottomRightRadius.setTo(radius);
            bottomLeftRadius.setTo(radius);
        } else {
            topLeftRadius.setTo(peekValue(a, mAttrsDelegate.getTopLeftRadius()));
            topRightRadius.setTo(peekValue(a, mAttrsDelegate.getTopRightRadius()));
            bottomRightRadius.setTo(peekValue(a, mAttrsDelegate.getBottomRightRadius()));
            bottomLeftRadius.setTo(peekValue(a, mAttrsDelegate.getBottomLeftRadius()));
        }

        if (topLeftRadius.type != TypedValue.TYPE_NULL) {
            innerTopLeftRadius.setTo(topLeftRadius);
            outerTopLeftRadius.setTo(topLeftRadius);
        } else {
            innerTopLeftRadius.setTo(peekValue(a, mAttrsDelegate.getInnerTopLeftRadius()));
            outerTopLeftRadius.setTo(peekValue(a, mAttrsDelegate.getOuterTopLeftRadius()));
        }

        if (topRightRadius.type != TypedValue.TYPE_NULL) {
            innerTopRightRadius.setTo(topRightRadius);
            outerTopRightRadius.setTo(topRightRadius);
        } else {
            innerTopRightRadius.setTo(peekValue(a, mAttrsDelegate.getInnerTopRightRadius()));
            outerTopRightRadius.setTo(peekValue(a, mAttrsDelegate.getOuterTopRightRadius()));
        }

        if (bottomRightRadius.type != TypedValue.TYPE_NULL) {
            innerBottomRightRadius.setTo(bottomRightRadius);
            outerBottomRightRadius.setTo(bottomRightRadius);
        } else {
            innerBottomRightRadius.setTo(peekValue(a, mAttrsDelegate.getInnerBottomRightRadius()));
            outerBottomRightRadius.setTo(peekValue(a, mAttrsDelegate.getOuterBottomRightRadius()));
        }

        if (bottomLeftRadius.type != TypedValue.TYPE_NULL) {
            innerBottomLeftRadius.setTo(bottomLeftRadius);
            outerBottomLeftRadius.setTo(bottomLeftRadius);
        } else {
            innerBottomLeftRadius.setTo(peekValue(a, mAttrsDelegate.getInnerBottomLeftRadius()));
            outerBottomLeftRadius.setTo(peekValue(a, mAttrsDelegate.getOuterBottomLeftRadius()));
        }
        a.recycle();
    }

    private boolean radiusPrepared = false;
    private float mRectHeight = 0;
    private float[] outerRadii = new float[8];
    private float[] innerRadii = new float[8];

    protected boolean prepareRadius(float height) {

        if (radiusPrepared && mRectHeight == height) {
            return false;
        }

        mRectHeight = height;

        // 外部矩形弧度
        outerRadii = new float[]{getRadiusValue(outerTopLeftRadius, height),
                getRadiusValue(outerTopLeftRadius, height),
                getRadiusValue(outerTopRightRadius, height),
                getRadiusValue(outerTopRightRadius, height),
                getRadiusValue(outerBottomRightRadius, height),
                getRadiusValue(outerBottomRightRadius, height),
                getRadiusValue(outerBottomLeftRadius, height),
                getRadiusValue(outerBottomLeftRadius, height)};
        // 内部矩形弧度
        innerRadii = new float[]{getRadiusValue(innerTopLeftRadius, height),
                getRadiusValue(innerTopLeftRadius, height),
                getRadiusValue(innerTopRightRadius, height),
                getRadiusValue(innerTopRightRadius, height),
                getRadiusValue(innerBottomRightRadius, height),
                getRadiusValue(innerBottomRightRadius, height),
                getRadiusValue(innerBottomLeftRadius, height),
                getRadiusValue(innerBottomLeftRadius, height)};

        radiusPrepared = true;

        return true;
    }

    private TypedValue peekValue(TypedArray a, int index, TypedValue defaultValue) {
        TypedValue value = a.peekValue(index);
        return value == null ? defaultValue : value;
    }

    private TypedValue peekValue(TypedArray a, int index) {
        return peekValue(a, index, new TypedValue());
    }

    private Drawable mDrawableCache;

    public Drawable getDrawableWithHeight(float height) {

        if (!prepareRadius(height) && mDrawableCache != null) {
            return mDrawableCache;
        }

        // 内部矩形与外部矩形的距离
        RectF borderInset = new RectF(borderWidth, borderWidth, borderWidth, borderWidth);

        RoundRectShape borderRoundRectShape = new RoundRectShape(outerRadii, borderInset, innerRadii);

        ShapeDrawable borderShapeDrawable = new ShapeDrawable(borderRoundRectShape);

        Paint borderPaint = borderShapeDrawable.getPaint();
        borderPaint.setAntiAlias(true);
        borderPaint.setColor(borderColor);
        borderPaint.setStyle(Paint.Style.FILL);

        RectF innerInset = new RectF(height / 2 - borderWidth - borderPaddingLeft,
                height / 2 - borderWidth - borderPaddingTop,
                height / 2 - borderWidth - borderPaddingRight,
                height / 2 - borderWidth - borderPaddingBottom);
        RoundRectShape innerRoundRectShape = new RoundRectShape(innerRadii, innerInset, innerRadii);

        ShapeDrawable innerShapeDrawable = new ShapeDrawable(innerRoundRectShape);

        Paint innerPaint = innerShapeDrawable.getPaint();
        innerPaint.setAntiAlias(true);
        innerPaint.setColor(background);
        innerPaint.setStyle(Paint.Style.FILL);

        LayerDrawable drawable = new LayerDrawable(new Drawable[]{innerShapeDrawable, borderShapeDrawable});

        drawable.setLayerInset(0,
                (int) (borderWidth + borderPaddingLeft),
                (int) (borderWidth + borderPaddingTop),
                (int) (borderWidth + borderPaddingRight),
                (int) (borderWidth + borderPaddingBottom));

        mDrawableCache = drawable;

        return drawable;
    }

    public void applyBackgroundDrawable(View view) {
        Drawable drawable = getDrawableWithHeight(view.getMeasuredHeight());
        int left = view.getPaddingLeft();
        int top = view.getPaddingTop();
        int right = view.getPaddingRight();
        int bottom = view.getPaddingBottom();
        view.setBackgroundDrawable(drawable);
        view.setPadding(left, top, right, bottom);
    }

    protected float getRadiusValue(TypedValue value, float height) {
        if (value == null) {
            return 0;
        }
        if (value.type == TypedValue.TYPE_FRACTION) {
            return value.getFraction(1, 1) * height;
        } else if (value.type == TypedValue.TYPE_DIMENSION) {
            return value.getDimension(mMetrics);
        }
        return 0;
    }
}
