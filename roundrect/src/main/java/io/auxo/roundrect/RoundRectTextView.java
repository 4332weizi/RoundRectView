package io.auxo.roundrect;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class RoundRectTextView extends AppCompatTextView {

    private RoundRectShapeHelper mRoundRectShapeHelper;

    public RoundRectTextView(Context context) {
        this(context, null);
    }

    public RoundRectTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public RoundRectTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRoundRectShapeHelper = new RoundRectShapeHelper(context, attrs, defStyleAttr, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setBackgroundDrawable(mRoundRectShapeHelper.getDrawableWithHeight(getMeasuredHeight()));
    }
}
