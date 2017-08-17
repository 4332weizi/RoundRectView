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
        this(context, attrs, 0);
    }

    public RoundRectTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
            return R.styleable.RoundRectTextView;
        }

        @Override
        public int getBackgroundColor() {
            return R.styleable.RoundRectTextView_backgroundColor;
        }

        @Override
        public int getBorderWidth() {
            return R.styleable.RoundRectTextView_borderWidth;
        }

        @Override
        public int getBorderColor() {
            return R.styleable.RoundRectTextView_borderColor;
        }

        @Override
        public int getBorderPadding() {
            return R.styleable.RoundRectTextView_borderPadding;
        }

        @Override
        public int getBorderPaddingLeft() {
            return R.styleable.RoundRectTextView_borderPaddingLeft;
        }

        @Override
        public int getBorderPaddingTop() {
            return R.styleable.RoundRectTextView_borderPaddingTop;
        }

        @Override
        public int getBorderPaddingRight() {
            return R.styleable.RoundRectTextView_borderPaddingRight;
        }

        @Override
        public int getBorderPaddingBottom() {
            return R.styleable.RoundRectTextView_borderPaddingBottom;
        }

        @Override
        public int getRadius() {
            return R.styleable.RoundRectTextView_cornerRadius;
        }

        @Override
        public int getTopLeftRadius() {
            return R.styleable.RoundRectTextView_topLeftRadius;
        }

        @Override
        public int getTopRightRadius() {
            return R.styleable.RoundRectTextView_topRightRadius;
        }

        @Override
        public int getBottomRightRadius() {
            return R.styleable.RoundRectTextView_bottomRightRadius;
        }

        @Override
        public int getBottomLeftRadius() {
            return R.styleable.RoundRectTextView_bottomLeftRadius;
        }

        @Override
        public int getInnerTopLeftRadius() {
            return R.styleable.RoundRectTextView_innerTopLeftRadius;
        }

        @Override
        public int getOuterTopLeftRadius() {
            return R.styleable.RoundRectTextView_outerTopLeftRadius;
        }

        @Override
        public int getInnerTopRightRadius() {
            return R.styleable.RoundRectTextView_innerTopRightRadius;
        }

        @Override
        public int getOuterTopRightRadius() {
            return R.styleable.RoundRectTextView_outerTopRightRadius;
        }

        @Override
        public int getInnerBottomRightRadius() {
            return R.styleable.RoundRectTextView_innerBottomRightRadius;
        }

        @Override
        public int getOuterBottomRightRadius() {
            return R.styleable.RoundRectTextView_outerBottomRightRadius;
        }

        @Override
        public int getInnerBottomLeftRadius() {
            return R.styleable.RoundRectTextView_innerBottomLeftRadius;
        }

        @Override
        public int getOuterBottomLeftRadius() {
            return R.styleable.RoundRectTextView_outerBottomLeftRadius;
        }
    };
}
