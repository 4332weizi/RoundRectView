package io.auxo.roundrect;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class RoundRectButton extends AppCompatButton {

    private RoundRectShapeHelper mRoundRectShapeHelper;

    public RoundRectButton(Context context) {
        this(context, null);
    }

    public RoundRectButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRectButton(Context context, AttributeSet attrs, int defStyleAttr) {
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
            return R.styleable.RoundRectButton;
        }

        @Override
        public int getBackgroundColor() {
            return R.styleable.RoundRectButton_backgroundColor;
        }

        @Override
        public int getBorderWidth() {
            return R.styleable.RoundRectButton_borderWidth;
        }

        @Override
        public int getBorderColor() {
            return R.styleable.RoundRectButton_borderColor;
        }

        @Override
        public int getBorderPadding() {
            return R.styleable.RoundRectButton_borderPadding;
        }

        @Override
        public int getBorderPaddingLeft() {
            return R.styleable.RoundRectButton_borderPaddingLeft;
        }

        @Override
        public int getBorderPaddingTop() {
            return R.styleable.RoundRectButton_borderPaddingTop;
        }

        @Override
        public int getBorderPaddingRight() {
            return R.styleable.RoundRectButton_borderPaddingRight;
        }

        @Override
        public int getBorderPaddingBottom() {
            return R.styleable.RoundRectButton_borderPaddingBottom;
        }

        @Override
        public int getRadius() {
            return R.styleable.RoundRectButton_cornerRadius;
        }

        @Override
        public int getTopLeftRadius() {
            return R.styleable.RoundRectButton_topLeftRadius;
        }

        @Override
        public int getTopRightRadius() {
            return R.styleable.RoundRectButton_topRightRadius;
        }

        @Override
        public int getBottomRightRadius() {
            return R.styleable.RoundRectButton_bottomRightRadius;
        }

        @Override
        public int getBottomLeftRadius() {
            return R.styleable.RoundRectButton_bottomLeftRadius;
        }

        @Override
        public int getInnerTopLeftRadius() {
            return R.styleable.RoundRectButton_innerTopLeftRadius;
        }

        @Override
        public int getOuterTopLeftRadius() {
            return R.styleable.RoundRectButton_outerTopLeftRadius;
        }

        @Override
        public int getInnerTopRightRadius() {
            return R.styleable.RoundRectButton_innerTopRightRadius;
        }

        @Override
        public int getOuterTopRightRadius() {
            return R.styleable.RoundRectButton_outerTopRightRadius;
        }

        @Override
        public int getInnerBottomRightRadius() {
            return R.styleable.RoundRectButton_innerBottomRightRadius;
        }

        @Override
        public int getOuterBottomRightRadius() {
            return R.styleable.RoundRectButton_outerBottomRightRadius;
        }

        @Override
        public int getInnerBottomLeftRadius() {
            return R.styleable.RoundRectButton_innerBottomLeftRadius;
        }

        @Override
        public int getOuterBottomLeftRadius() {
            return R.styleable.RoundRectButton_outerBottomLeftRadius;
        }
    };
}
