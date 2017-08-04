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
        this(context, attrs ,0);
    }

    public RoundRectRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRoundRectShapeHelper = new RoundRectShapeHelper(context, attrs, defStyleAttr, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setBackgroundDrawable(mRoundRectShapeHelper.getDrawableWithHeight(getMeasuredHeight()));
    }
}
