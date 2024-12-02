package org.less03.hw;

/* task01
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа,
над которыми должна быть произведена операция.
 */
public class Calculator {
    public static <T extends Number> double sum(T n1, T n2){
        return n1.doubleValue() + n2.doubleValue();
    }
    public static <T extends Number> double multiply(T n1, T n2){
        return n1.doubleValue() * n2.doubleValue();
    }

    public static <T extends Number> double divide(T n1, T n2){
        if (n2.doubleValue() == 0) throw new ArithmeticException("На ноль делить нельзя");
        return n1.doubleValue() / n2.doubleValue();
    }
    public static <T extends Number> double subtract(T n1, T n2){
        return n1.doubleValue() - n2.doubleValue();
    }

}
