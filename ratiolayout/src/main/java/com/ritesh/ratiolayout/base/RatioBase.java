package com.ritesh.ratiolayout.base;

import com.ritesh.ratiolayout.models.enums.FixedAttribute;

/**
 * @author Ritesh Shakya
 */

@SuppressWarnings("unused")
public interface RatioBase {
    void setRatio(float horizontalRatio, float verticalRatio);

    void setRatio(FixedAttribute fixedAttribute, float horizontalRatio, float verticalRatio);

    float getHorizontalRatio();

    float getVerticalRatio();

    FixedAttribute getFixedAttribute();
}
