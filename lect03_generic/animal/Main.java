package org.lect03_generic.animal;

import static org.lect03_generic.animal.TBox.printInfo;

public class Main {
    public static void main(String[] args) {
        TBox<Cat> catTBox = TBox.emptyBox();
        catTBox.setValue(new Cat("Lucy"));
        printInfo(catTBox);

        TBox<Dog> dogTBox = TBox.emptyBox();
        dogTBox.setValue(new Dog("Mike"));
        printInfo(dogTBox);

        //  класс Cat является подклассом класса Animal, и расширяет его.
        // Наследование в параметрах типа через подстановочный символ
        Cat cat1 = new Cat("Murzik");
        Animal animal = cat1;
        TBox<? extends Cat> catInBox = new TBox<>();
        TBox<? extends Animal> animalInBox = catInBox;
    }
}
