package io.auxo.roundrect;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RoundRectRelativeLayout extends RelativeLayout {

    private RoundRectShapeHelper mRoundRectShapeHelper;

    public RoundRectRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundRectRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRectRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRoundRectShapeHelper = new RoundRectShapeHelper(context, attrs, defStyleAttr, 0, mAttrsDelegate);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mRoundRectShapeHelper.applyBackgroundDrawable(this);
    }

    private RoundRectAttrsDelegate mAttrsDelegate = new RoundRectAttrsDelegate() {
        @Override
        public int[] getName() {
            return R.styleable.RoundRectRelativeLayout;
        }

        @Override
        public int getBackgroundColor() {
            return R.styleable.RoundRectRelativeLayout_backgroundColor;
        }

        @Override
        public int getBorderWidth() {
            return R.styleable.RoundRectRelativeLayout_borderWidth;
        }

        @Override
        public int getBorderColor() {
            return R.styleable.RoundRectRelativeLayout_borderColor;
        }

        @Override
        public int getBorderPadding() {
            return R.styleable.RoundRectRelativeLayout_borderPadding;
        }

        @Override
        public int getBorderPaddingLeft() {
            return R.styleable.RoundRectRelativeLayout_borderPaddingLeft;
        }

        @Override
        public int getBorderPaddingTop() {
            return R.styleable.RoundRectRelativeLayout_borderPaddingTop;
        }

        @Override
        public int getBorderPaddingRight() {
            return R.styleable.RoundRectRelativeLayout_borderPaddingRight;
        }

        @Override
        public int getBorderPaddingBottom() {
            return R.styleable.RoundRectRelativeLayout_borderPaddingBottom;
        }

        @Override
        public int getRadius() {
            return R.styleable.RoundRectRelativeLayout_cornerRadius;
        }

        @Override
        public int getTopLeftRadius() {
            return R.styleable.RoundRectRelativeLayout_topLeftRadius;
        }

        @Override
        public int getTopRightRadius() {
            return R.styleable.RoundRectRelativeLayout_topRightRadius;
        }

        @Override
        public int getBottomRightRadius() {
            return R.styleable.RoundRectRelativeLayout_bottomRightRadius;
        }

        @Override
        public int getBottomLeftRadius() {
            return R.styleable.RoundRectRelativeLayout_bottomLeftRadius;
        }

        @Override
        public int getInnerTopLeftRadius() {
            return R.styleable.RoundRectRelativeLayout_innerTopLeftRadius;
        }

        @Override
        public int getOuterTopLeftRadius() {
            return R.styleable.RoundRectRelativeLayout_outerTopLeftRadius;
        }

        @Override
        public int getInnerTopRightRadius() {
            return R.styleable.RoundRectRelativeLayout_innerTopRightRadius;
        }

        @Override
        public int getOuterTopRightRadius() {
            return R.styleable.RoundRectRelativeLayout_outerTopRightRadius;
        }

        @Override
        public int getInnerBottomRightRadius() {
            return R.styleable.RoundRectRelativeLayout_innerBottomRightRadius;
        }

        @Override
        public int getOuterBottomRightRadius() {
            return R.styleable.RoundRectRelativeLayout_outerBottomRightRadius;
        }

        @Override
        public int getInnerBottomLeftRadius() {
            return R.styleable.RoundRectRelativeLayout_innerBottomLeftRadius;
        }

        @Override
        public int getOuterBottomLeftRadius() {
            return R.styleable.RoundRectRelativeLayout_outerBottomLeftRadius;
        }
    };
}
