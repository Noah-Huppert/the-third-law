package com.noahhuppert.thethirdlaw.helpers;

import com.badlogic.gdx.math.MathUtils;

public class Math {
    /**
     * Returns the result of n*PI / d
     * Usefull for getting common angles in radians
     * @param n Numerator of fraction
     * @param d Denominator of fraction
     * @return Common angle in radians
     */
    public static float common(float n, float d) {
        if(d == 0) {
            throw new RuntimeException("Denominator can not be 0");
        }

        return (n * MathUtils.PI) / d;
    }
}
