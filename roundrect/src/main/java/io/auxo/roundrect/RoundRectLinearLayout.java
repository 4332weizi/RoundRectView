package io.auxo.roundrect;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class RoundRectLinearLayout extends LinearLayout {

    private RoundRectShapeHelper mRoundRectShapeHelper;

    public RoundRectLinearLayout(Context context) {
        this(context, null);
    }

    public RoundRectLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRectLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRoundRectShapeHelper = new RoundRectShapeHelper(context, attrs, defStyleAttr, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setBackgroundDrawable(mRoundRectShapeHelper.getDrawableWithHeight(getMeasuredHeight()));
    }
}
