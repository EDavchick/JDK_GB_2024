package org.lect03_generic;

import static org.lect03_generic.BBox.*;
import static org.lect03_generic.GBox.*;

public class Main {
    public static void main(String[] args) {
        /* Обычный класс */
        Box b1 = new Box(20);
        Box b2 = new Box(30);
//        System.out.println(b1.getObject() + b2.getObject()); // Operator '+' cannot be applied to 'java.lang.Object', 'java.lang.Object'
        System.out.println((Integer) b1.getObject() + (Integer) b2.getObject());

        Box b3 = new Box("Hello, ");
        Box b4 = new Box("new world!");
//        System.out.println(b3.getObject() + b4.getObject()); // Operator '+' cannot be applied to 'java.lang.Object', 'java.lang.Object
        System.out.println((String) b3.getObject() + (String) b4.getObject());

        if (b1.getObject() instanceof Integer && b2.getObject() instanceof Integer) {
            int sum = (Integer) b1.getObject() + (Integer) b2.getObject();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("The contents of the boxes deffer by type");
        }

        b1.setObject("1234rfgh");

        /* Обобщенный класс - GENERIC */
        GBox<String> stringGBox = new GBox<>("Hello");
        stringGBox.showType();
        GBox<Integer> integerGBox = new GBox<>(12);
        integerGBox.showType();

        /* создание объекта */
        GBox<Integer> integerGBox1;
        GBox<Integer> integerGBox2 = new GBox<>(1);
//        GBox<Integer> integerGBox3 = new GBox<>(); // Expected 1 arguments but found 0

        // Множество параметризированных типов
        KVBox<Integer, String> kvb0 = new KVBox<>(1, "Hello");
        KVBox<String, GBox<String>> kvb1 = new KVBox<>("World", new GBox<>("String Java"));
        kvb1.showType();

        /* Raw Types или сырые типы */
        GBox box0 = new GBox<>(3);
        box0.getValue();  // возвращает тип Object
        // а так уже будет явный тип
        GBox<Integer> box1 = new GBox<>(3);
        box1.getValue(); // возвращает тип Integer
        GBox<Integer> intBox2 = new GBox<>(1);
        GBox box = intBox2;

        GBox<Integer> value0 = new GBox<>(null);
        setIfNull(value0, 13);
        System.out.println(value0.getValue()); // 13
        GBox<Integer> value1 = new GBox<>(1);
        setIfNull(value1, 13);
        System.out.println(value1.getValue()); // 1

        /* Bounded type parameters позволяют ограничить типы данных,
        которые могут быть использованы в качестве параметров*/
        // Ограничение «сверху»
        BBox<Integer> integerBBox = new BBox<>();
//        BBox<String> stringBBox = new BBox<String>(); // Type parameter 'java.lang.String' is not within its bound; should extend 'java.lang.Number'
        setIfNullBbox(integerBBox, 22);
        System.out.println(integerBBox.getValue());

        // Ограничение «снизу»
        /* Если подать на вход обобщённого метода два типа –
        Integer и Float в итоге для работы будет выбран
        ближайший старший для них обоих – Number.*/

        System.out.println(compare(1, 1.0f)); // false
        System.out.println(compare(1.0f, 1.0f)); // true
        System.out.println(compare(1, 1)); // true

        TBox<String> tBox = TBox.emptyBox();
    }


}
