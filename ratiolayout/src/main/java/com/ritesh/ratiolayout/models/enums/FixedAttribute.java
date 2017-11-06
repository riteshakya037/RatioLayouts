package com.ritesh.ratiolayout.models.enums;

/**
 * Enum class for fixed attributes
 * @author Ritesh Shakya
 */

public enum FixedAttribute {
    /**
     * Has two integer enums
     * <br>One for the ratio height
     * <br>One for the ratio width
     */
    HEIGHT(0), WIDTH(1);
    /**
     * Represents the enum type
     */
    final int id;

    /**
     * Default constructor for FixedAttribute
     * @param id Integer with the enum value
     */
    FixedAttribute(int id) {
        this.id = id;
    }

    /**
     * Returns a FixedAttribute that corresponds to a certain enum value
     * <br>Throws <i>IllegalArgumentException</i> if Integer is higher than the current enum values
     * (In this case Integer must be lower than 2)
     * @param id Integer with the enum value
     * @return FixedAttribute that corresponds to a following enum value
     */
    public static FixedAttribute fromId(int id) {
        for (FixedAttribute f : values()) {
            if (f.id == id) return f;
        }
        throw new IllegalArgumentException();
    }
}
