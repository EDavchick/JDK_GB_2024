package org.less04.task03;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* Задание 3
В рамках выполнения задачи необходимо:
● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
● Найдите человека с самым маленьким номером телефона
● Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */
public class Program {
    // Найдите человека с самым маленьким номером телефона
        public static String findByMinNumberPhone(Map<String, String> phonebook){
            Set<Long> numbers = phonebook.keySet().stream().map(el ->
                    Long.valueOf(el)).collect(Collectors.toSet());
            long number = numbers.stream().min(Comparator.naturalOrder()).get();
            return String.format("Max number: %s, owner: %s",
                    number,  phonebook.get(String.valueOf(number)));
        }

        // Найдите номер телефона человека чье имя самое большое в алфавитном порядке
    public static String findByMaxAlphabetName(Map<String, String> phonebook){
        Set<Map.Entry<String, String>> elements = phonebook.entrySet();
        Map.Entry<String, String> name =  elements.stream().max(Map.Entry.comparingByValue()).get();
//        Map.Entry<String, String> name =  elements.stream().max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())).get();
        return String.format("Max name in alphabet order: %s, phone number %s", name.getValue(), name.getKey());
    }

    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("89052349575", "Ivan");
        phoneBook.put("89759871223", "Sergey");
        phoneBook.put("89652879575", "Anna");
        phoneBook.put("89060329575", "Katya");
        phoneBook.put("89128729575", "Vasya");

        System.out.println(findByMinNumberPhone(phoneBook));
        System.out.println(findByMaxAlphabetName(phoneBook));
    }
}
