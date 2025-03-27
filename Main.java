// Задание 1 (Из файла задание 44, 48, 52, 54, 59)
package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    private static final double COMMISSION_RATE = 0.01; // 1% комиссия
    private static final double EXCHANGE_RATE = 90.0; // Пример: 90 рублей за доллар
//48
    public static void main(String[] args) {
        // Пример использования конвертации валюты
        double rubles = 1000.0;
        double dollars = convertRublesToDollars(rubles);
        System.out.println(rubles + " рублей = " + dollars + " долларов");
//44
        // Пример использования расчета равнодействующей силы
        double force1X = 10.0;
        double force1Y = 5.0;
        double force2X = -5.0;
        double force2Y = 3.0;
        double force3X = 2.0;
        double force3Y = -8.0;

        double resultantForceX = calculateResultantForceX(force1X, force2X, force3X);
        double resultantForceY = calculateResultantForceY(force1Y, force2Y, force3Y);

        System.out.println("Результат по оси X: " + resultantForceX);
        System.out.println("Результат по оси Y: " + resultantForceY);
//52
        // Пример использования расчета радиуса вписанной окружности
        double x1 = 0.0, y1 = 0.0;
        double x2 = 3.0, y2 = 0.0;
        double x3 = 0.0, y3 = 4.0;

        double inradius = calculateInradius(x1, y1, x2, y2, x3, y3);
        System.out.println("Радиус вписанной окружности: " + inradius);
//54
        // Пример использования расчета высоты, опущенной на гипотенузу
        double a = 3.0;  // Катет a
        double b = 4.0;  // Катет b
        double height = calculateHypotenuseHeight(a, b);
        System.out.println("Высота, опущенная на гипотенузу: " + height);
//59
        // Пример использования расчета значения функции f(x)
        double x = 2.0;
        double fx = calculateFunctionValue(x);
        System.out.println("Значение функции f(x) при x = " + x + ": " + fx);
    }

    // Метод для конвертации рублей в доллары с учетом комиссии и округлением
    public static double convertRublesToDollars(double rubles) {
        // Рассчитываем комиссию
        double commission = rubles * COMMISSION_RATE;

        // Вычитаем комиссию из суммы в рублях
        double rublesAfterCommission = rubles - commission;

        // Конвертируем рубли в доллары
        double dollars = rublesAfterCommission / EXCHANGE_RATE;

        // Округляем результат до 4 знаков после запятой
        BigDecimal bd = new BigDecimal(dollars);
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // Метод для вычисления равнодействующей силы по оси X
    public static double calculateResultantForceX(double force1X, double force2X, double force3X) {
        return force1X + force2X + force3X;
    }

    // метод для вычисления равнодействующей силы по оси Y
    public static double calculateResultantForceY(double force1Y, double force2Y, double force3Y) {
        return force1Y + force2Y + force3Y;
    }

    // метод для вычисления радиуса вписанной окружности
    public static double calculateInradius(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Вычисляем длины сторон треугольника
        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double c = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

        // Вычисляем полупериметр
        double s = (a + b + c) / 2.0;

        // Вычисляем площадь треугольника по формуле Герона
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        return area / s;
    }

    // метод для вычисления высоты, опущенной на гипотенузу
    public static double calculateHypotenuseHeight(double a, double b) {
        // Вычисляем площадь треугольника как половину произведения катетов
        double area = 0.5 * a * b;

        // Вычисляем длину гипотенузы
        double hypotenuse = Math.sqrt(a * a + b * b);

        // Вычисляем высоту
        double height = (2 * area) / hypotenuse;

        return height;
    }

    // Метод для вычисления значения функции f(x) = (tan(x))^3 * abs(log1p(x^3))
    public static double calculateFunctionValue(double x) {
        double tanX = Math.tan(x);
        double xCubed = Math.pow(x, 3);
        double log1pXCubed = Math.log1p(xCubed);
        double absLog1pXCubed = Math.abs(log1pXCubed);

        return Math.pow(tanX, 3) * absLog1pXCubed;
    }
}