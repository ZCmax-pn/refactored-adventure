import pytest
import math
from lr4 import (
    convert_rubles_to_dollars,
    calculate_resultant_force_x,
    calculate_resultant_force_y,
    calculate_inradius,
    calculate_hypotenuse_height,
    calculate_function_value
)
# Исключения
def force_zerodivision_inradius():
    "Если все три точки совпадают (образуют вырожденный треугольник), то площадь будет 0, полупериметр будет 0"
    calculate_inradius(0, 0, 0, 0, 0, 0)

def force_domain_error_function_value():
   "Функция math.log1p(x) вызывает ValueError при x < -1"
   calculate_function_value(-1)

@pytest.mark.positive
@pytest.mark.parametrize(
    "RUBLES, EXPECTED_DOLLARS",
    [
        (1000.0, 1.100e+01),
        (500.0, 5.500e+00),
        (250.0, 2.750e+00),
        (0.0, 0.0),
    ],
)
def test_convert_rubles_to_dollars(RUBLES, EXPECTED_DOLLARS):
    DELTA = 1.0e-04
    assert abs(convert_rubles_to_dollars(RUBLES) - EXPECTED_DOLLARS) < DELTA


@pytest.mark.positive
def test_calculate_resultant_force_x():
    FORCE_X1 = 10.0
    FORCE_X2 = -5.0
    FORCE_X3 = 2.0
    EXPECTED_RESULT_FORCE_X = 7.0
    assert abs(calculate_resultant_force_x(FORCE_X1, FORCE_X2, FORCE_X3) - EXPECTED_RESULT_FORCE_X) < 0.0001


@pytest.mark.positive
def test_calculate_resultant_force_y():
    FORCE_Y1 = 5.0
    FORCE_Y2 = 3.0
    FORCE_Y3 = -8.0
    EXPECTED_RESULT_FORCE_Y = 0.0
    assert abs(calculate_resultant_force_y(FORCE_Y1, FORCE_Y2, FORCE_Y3) - EXPECTED_RESULT_FORCE_Y) < 0.0001


@pytest.mark.positive
def test_calculate_inradius():
    x1, y1 = 0.0, 0.0
    x2, y2 = 3.0, 0.0
    x3, y3 = 0.0, 4.0
    EXPECTED_IN_RADIUS = 1.0
    assert abs(calculate_inradius(x1, y1, x2, y2, x3, y3) - EXPECTED_IN_RADIUS) < 0.0001


@pytest.mark.positive
def test_calculate_hypotenuse_height():
    a = 3.0
    b = 4.0
    EXPECTED_HEIGHT = 2.4
    assert abs(calculate_hypotenuse_height(a, b) - EXPECTED_HEIGHT) < 0.0001


@pytest.mark.positive
def test_calculate_function_value():
    x = 2.0
    EXPECTED_FX = math.tan(x)**3 * abs(math.log1p(x**3))
    assert abs(calculate_function_value(x) - EXPECTED_FX) < 0.0001


@pytest.mark.negative
def test_calculate_function_value_zero():
    x = 0.0
    assert abs(calculate_function_value(x)) < 0.0001


@pytest.mark.negative
def test_convert_rubles_to_dollars_negative_rubles():
    RUBLES = -100
    DOLLARS = convert_rubles_to_dollars(RUBLES)
    assert DOLLARS < 0

@pytest.mark.xfail(raises=ZeroDivisionError)
def test_calculate_inradius_zero_division():
    force_zerodivision_inradius()


@pytest.mark.xfail(raises=ValueError)
def test_calculate_function_value_domain_error():
    force_domain_error_function_value()