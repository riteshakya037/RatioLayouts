package com.ritesh.ratiolayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.GridLayout;

import com.ritesh.ratiolayout.base.RatioBase;
import com.ritesh.ratiolayout.models.enums.FixedAttribute;


/**
 * Class that represents a GridLayout with fixed ratio values
 * <br><b>Extends</b> GridLayout
 * <br><b>Implements</b> RatioBase
 * @author Ritesh Shakya
 */

public class RatioGridLayout extends GridLayout implements RatioBase {
    /**
     * Float with the vertical (height) ratio value
     */
    private float verticalRatio = 1;
    /**
     * Float with the horizontal (width) ratio value
     */
    private float horizontalRatio = 1;
    /**
     * FixedAttribute with the corresponding enum value for this class (Width)
     */
    private FixedAttribute fixedAttribute = FixedAttribute.WIDTH;

    /**
     * Default constructor for RatioGridLayout
     * @param context of the GridLayout being extended
     */
    public RatioGridLayout(Context context) {
        super(context);
    }
    /**
     * Builds a new RatioGridLayout instance with the context and attributes for the GridLayout
     * @param context Context of the GridLayout being extended
     * @param attrs AttributeSet of the GridLayout being extended
     */
    public RatioGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }
    /**
     * Builds a new RatioGridLayout instance with the context and attributes for the GridLayout
     * @param context Context of the GridLayout being extended
     * @param attrs AttributeSet of the GridLayout being extended
     * @param defStyleAttr Integer with the defined attribute style of the GridLayout being extended
     */
    public RatioGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }
    /**
     * Initializes AttributeSet
     * @param attrs AttributeSet extended from GridLayout
     */
    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(
                attrs,
                R.styleable.RatioRelativeLayout);
        fixedAttribute = FixedAttribute.fromId(typedArray.getInt(R.styleable.RatioRelativeLayout_fixed_attribute, 0));
        horizontalRatio = typedArray.getFloat(R.styleable.RatioRelativeLayout_horizontal_ratio, 1);
        verticalRatio = typedArray.getFloat(R.styleable.RatioRelativeLayout_vertical_ratio, 1);
        typedArray.recycle();
    }
    /**
     * Overrides onMeasure method implemented from View
     * @param widthMeasureSpec Integer with a certain width
     * @param heightMeasureSpec Integer with a certain height
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int originalWidth = MeasureSpec.getSize(widthMeasureSpec);
        int originalHeight = MeasureSpec.getSize(heightMeasureSpec);
        if (fixedAttribute == FixedAttribute.WIDTH) {
            int calculatedHeight = (int) (originalWidth * (verticalRatio / horizontalRatio));
            super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(calculatedHeight, MeasureSpec.EXACTLY));
        } else {
            int calculatedWidth = (int) (originalHeight * (horizontalRatio / verticalRatio));
            super.onMeasure(MeasureSpec.makeMeasureSpec(calculatedWidth, MeasureSpec.EXACTLY), heightMeasureSpec);
        }
    }
    /**
     * Overrides setRatio method implemented from RatioBase
     * @param horizontalRatio float with horizontal ratio
     * @param verticalRatio float with vertical ratio
     */
    @Override
    public void setRatio(float horizontalRatio, float verticalRatio) {
        this.setRatio(fixedAttribute, horizontalRatio, verticalRatio);
    }

    /**
     * Overrides setRatio method implemented from RatioBase with a certain fixed attribute and width & height values
     * @param fixedAttribute FixedAttribute with a certain fixed attribute
     * @param horizontalRatio float with horizontal ratio
     * @param verticalRatio float with vertical ratio
     */
    @Override
    public void setRatio(FixedAttribute fixedAttribute, float horizontalRatio, float verticalRatio) {
        this.fixedAttribute = fixedAttribute;
        this.horizontalRatio = horizontalRatio;
        this.verticalRatio = verticalRatio;
        this.invalidate();
        this.requestLayout();
    }

    /**
     * Overrides getHorizontalRatio method from RatioBase
     * @return float with the current horizontal ratio being used
     */
    @Override
    public float getHorizontalRatio() {
        return horizontalRatio;
    }
    /**
     * Overrides getVerticalRatio method from RatioBase
     * @return float with the current vertical ratio being used
     */
    @Override
    public float getVerticalRatio() {
        return verticalRatio;
    }
    /**
     * Overrides getFixedAttribute method from RatioBase
     * @return FixedAttribute with the current fixed attribute being used
     */
    @Override
    public FixedAttribute getFixedAttribute() {
        return fixedAttribute;
    }
}
