# main.py
import math
COMMISSION_RATE = 0.01  # 1% комиссия
EXCHANGE_RATE = 90.0  # Пример: 90 рублей за доллар


# Задание 48
def convert_rubles_to_dollars(rubles):
    """Конвертирует рубли в доллары с учетом комиссии и округлением."""
    commission = rubles * COMMISSION_RATE
    rubles_after_commission = rubles - commission
    dollars = rubles_after_commission / EXCHANGE_RATE
    return round(dollars, 4)


# Задание 44
def calculate_resultant_force_x(force1_x, force2_x, force3_x):
    """Вычисляет равнодействующую силу по оси X."""
    return force1_x + force2_x + force3_x


def calculate_resultant_force_y(force1_y, force2_y, force3_y):
    """Вычисляет равнодействующую силу по оси Y."""
    return force1_y + force2_y + force3_y


# Задание 52
def calculate_inradius(x1, y1, x2, y2, x3, y3):
    """Вычисляет радиус вписанной окружности."""
    a = math.sqrt((x2 - x1)**2 + (y2 - y1)**2)
    b = math.sqrt((x3 - x2)**2 + (y3 - y2)**2)
    c = math.sqrt((x1 - x3)**2 + (y1 - y3)**2)

    s = (a + b + c) / 2.0
    area = math.sqrt(s * (s - a) * (s - b) * (s - c))
    return area / s


# Задание 54
def calculate_hypotenuse_height(a, b):
    """Вычисляет высоту, опущенную на гипотенузу."""
    area = 0.5 * a * b
    hypotenuse = math.sqrt(a**2 + b**2)
    height = (2 * area) / hypotenuse
    return height


# Задание 59
def calculate_function_value(x):
    """Вычисляет значение функции f(x) = (tan(x))^3 * abs(log1p(x^3))."""
    tan_x = math.tan(x)
    x_cubed = x**3
    log1p_x_cubed = math.log1p(x_cubed)
    abs_log1p_x_cubed = abs(log1p_x_cubed)
    return tan_x**3 * abs_log1p_x_cubed


if __name__ == '__main__':
    # Примеры использования
    rubles = 1000.0
    dollars = convert_rubles_to_dollars(rubles)
    print(f"{rubles} рублей = {dollars} долларов")

    force1_x = 10.0
    force1_y = 5.0
    force2_x = -5.0
    force2_y = 3.0
    force3_x = 2.0
    force3_y = -8.0

    resultant_force_x = calculate_resultant_force_x(force1_x, force2_x, force3_x)
    resultant_force_y = calculate_resultant_force_y(force1_y, force2_y, force3_y)

    print("Результат по оси X:", resultant_force_x)
    print("Результат по оси Y:", resultant_force_y)

    x1, y1 = 0.0, 0.0
    x2, y2 = 3.0, 0.0
    x3, y3 = 0.0, 4.0

    inradius = calculate_inradius(x1, y1, x2, y2, x3, y3)
    print("Радиус вписанной окружности:", inradius)

    a = 3.0
    b = 4.0
    height = calculate_hypotenuse_height(a, b)
    print("Высота, опущенная на гипотенузу:", height)

    x = 2.0
    fx = calculate_function_value(x)
    print(f"Значение функции f(x) при x = {x}: {fx}")