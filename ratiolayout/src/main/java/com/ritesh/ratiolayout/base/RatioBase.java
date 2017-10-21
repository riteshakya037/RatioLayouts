package com.ritesh.ratiolayout.base;

import com.ritesh.ratiolayout.models.enums.FixedAttribute;

/**
 * Interface for Ratio bases
 * <br>Currently not being used
 * @author Ritesh Shakya
 */


@SuppressWarnings("unused")
public interface RatioBase {
    /**
     * Sets a new Ratio with certain horizontal and vertical ratio values
     * @param horizontalRatio float with horizontal ratio
     * @param verticalRatio float with vertical ratio
     */
    void setRatio(float horizontalRatio, float verticalRatio);

    /**
     * Sets a new ratio with a certain FixedAttribute and certain horizontal and vertical ratio
     * values
     * @param fixedAttribute FixedAttribute with a certain fixed attribute
     * @param horizontalRatio float with horizontal ratio
     * @param verticalRatio float with vertical ratio
     */
    void setRatio(FixedAttribute fixedAttribute, float horizontalRatio, float verticalRatio);

    /**
     * Returns current horizontal ratio
     * @return float with the current horizontal ratio
     */
    float getHorizontalRatio();

    /**
     * Returns current vertical ratio
     * @return float with the current vertical ratio
     */
    float getVerticalRatio();

    /**
     * Returns current fixed attribute
     * @return FixedAttribute with the current fixed attribute
     */
    FixedAttribute getFixedAttribute();
}
