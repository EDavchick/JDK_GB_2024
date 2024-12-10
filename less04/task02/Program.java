package org.less04.task02;

import java.util.*;

/* Задание 2
В рамках выполнения задачи необходимо:
● Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
● Получите уникальный список Set на основании List
● Определите наименьший элемент (алфавитный порядок)
● Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
● Удалите все элементы содержащие букву ‘A’
 */
public class Program {
    // Получите уникальный список Set на основании List
    public static Set<String> getSetToList(List<String> list){
        return new HashSet<>(list);
    }

    // Определите наименьший элемент (алфавитный порядок)
    public static String minLengthName(Set<String> names){
        return  names.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    // Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
    public static List<String> minAndMaxLengthNames(Set<String> names){
        List<String> resultNames = new ArrayList<>();
        resultNames.add(names.stream().min(Comparator.comparing(String::length)).orElse(null));
        resultNames.add(names.stream().max(Comparator.comparing(String::length)).orElse(null));
        return resultNames;
//        resultNames.add(names.stream().min((el1, el2) -> el1.length() - el2.length()).orElse(null));
//        resultNames.add(names.stream().min(Comparator.comparingInt(String::length)).orElse(null));

    }

    // Удалите все элементы содержащие букву ‘A’
    public static void removeNamesByChar(Set<String> names, char symbol){
//        names.removeIf(name -> name.toLowerCase().contains(symbol.toLowerCase()));
        names.removeIf(name -> name.toLowerCase().contains(String.valueOf(symbol).toLowerCase()));
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                Arrays.asList("Галина", "Василий", "Алексей", "Галина", "Ян", "Анна", "Алексей", "Светлана"));
        Set<String> setNames = getSetToList(names);
        System.out.println(setNames);

        System.out.println("Min alphabet name is: " + minLengthName(setNames));

        List<String> minAndMaxNames = minAndMaxLengthNames(setNames);
        System.out.printf("Min length name is %s, max length name is %s\n",
                minAndMaxNames.get(0), minAndMaxNames.get(1));

        removeNamesByChar(setNames, 'А');
        System.out.println("Set after delete char 'A': " + setNames);
    }
}
