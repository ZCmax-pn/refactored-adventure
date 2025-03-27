package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {

    @Test(groups = {"positive"})
    public void testConvertRublesToDollars() {
        // ARRANGE
        double actualDollars;
        final double DELTA = 0.0001;
        final double RUBLES = 1000.0;
        final double EXPECTED_DOLLARS = 11.0; // Ожидаемый результат с учетом комиссии 1% и курса 90

        // ACT
        actualDollars = Main.convertRublesToDollars(RUBLES);

        // ASSERT
        Assert.assertEquals(actualDollars, EXPECTED_DOLLARS, DELTA);
    }

    @Test(groups = {"positive"})
    public void testCalculateResultantForceX() {
        // ARRANGE
        double actualResultantForceX;
        final double DELTA = 0.0001;
        final double FORCE_X1 = 10.0;
        final double FORCE_X2 = -5.0;
        final double FORCE_X3 = 2.0;
        final double EXPECTED_RESULT_FORCES_X = 7.0;

        // ACT
        actualResultantForceX = Main.calculateResultantForceX(FORCE_X1, FORCE_X2, FORCE_X3);

        // ASSERT
        Assert.assertEquals(actualResultantForceX, EXPECTED_RESULT_FORCES_X, DELTA);
    }

    @Test(groups = {"negative"})
    public void testCalculateResultantForceY() {
        // ARRANGE
        double actualResultantForceY;
        final double DELTA = 0.0001;
        final double FORCE_Y1 = 5.0;
        final double FORCE_Y2 = 3.0;
        final double FORCE_Y3 = -8.0;
        final double EXPECTED_RESULT_FORCES_Y = 0.0;

        // ACT
        actualResultantForceY = Main.calculateResultantForceY(FORCE_Y1, FORCE_Y2, FORCE_Y3);

        // ASSERT
        Assert.assertEquals(actualResultantForceY, EXPECTED_RESULT_FORCES_Y, DELTA);
    }

    @Test(groups = {"positive"})
    public void testCalculateInradius() {
        // ARRANGE
        double actualInradius;
        final double DELTA = 0.0001;
        final double x1 = 0.0, y1 = 0.0;
        final double x2 = 3.0, y2 = 0.0;
        final double x3 = 0.0, y3 = 4.0;
        final double EXPECTED_IN_RADIUS = 1.0;  // Для треугольника 3-4-5 радиус вписанной окружности равен 1.

        // ACT
        actualInradius = Main.calculateInradius(x1, y1, x2, y2, x3, y3);

        // ASSERT
        Assert.assertEquals(actualInradius, EXPECTED_IN_RADIUS, DELTA);
    }

    @Test(groups = {"negative"})
    public void testCalculateHypotenuseHeight() {
        // ARRANGE
        double actualHeight;
        final double DELTA = 0.0001;
        final double a = 3.0;
        final double b = 4.0;
        final double EXPECTED_HEIGHT = 2.4; // Для треугольника 3-4-5 высота, опущенная на гипотенузу, равна 2.4

        // ACT
        actualHeight = Main.calculateHypotenuseHeight(a, b);

        // ASSERT
        Assert.assertEquals(actualHeight, EXPECTED_HEIGHT, DELTA);
    }

    @Test(groups = {"positive"})
    public void testCalculateFunctionValue() {
        // ARRANGE
        double actualFx;
        final double DELTA = 0.0001;
        final double x = 2.0;
        final double expectedFx = Math.pow(Math.tan(x), 3) * Math.abs(Math.log1p(Math.pow(x, 3)));

        // ACT
        actualFx = Main.calculateFunctionValue(x);

        // ASSERT
        Assert.assertEquals(actualFx, expectedFx, DELTA);
    }
}