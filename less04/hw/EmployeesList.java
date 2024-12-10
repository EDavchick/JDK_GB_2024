package org.less04.hw;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Создать справочник сотрудников
Необходимо:
-- Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников
-- Добавить метод, который ищет сотрудника по стажу (может быть список)
-- Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
-- Добавить метод, который ищет сотрудника по табельному номеру
-- Добавить метод добавления нового сотрудника в справочник
 */
public class EmployeesList {
    List<Employee> employeeList = new ArrayList<>();

    public void addEmployeeToList(Employee employee){
        employeeList.add(employee);
    }
    void printAllEmployees(){
        System.out.println(Stream.of(employeeList).collect(Collectors.toList()));
    }

    // Добавить метод, который ищет сотрудника по стажу (может быть список)
    public void findEmployeeOnExperience(int ex){
        employeeList.stream().filter(x -> x.getExperience() == ex).forEach(System.out::print);
    }

    // Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
    public void returnPhoneNumberByName(String name) {
        employeeList.stream().filter(x -> x.getName().equals(name)).
                forEach(x -> System.out.println(STR."Employee with name \{x.getName()} and id#\{x.getId()} has a phone number \{x.getPhoneNumber()}"));
    }

    // Добавить метод, который ищет сотрудника по табельному номеру
    public void findEmployeeById(int id){
        employeeList.stream().filter(x -> x.getId() == id).forEach(System.out::print);
    }

    // Добавить метод добавления нового сотрудника в справочник
    public List<Employee> addNewEmployeeinList(Employee em){
        List<Employee> newListEm = new ArrayList<>();
                newListEm = employeeList.stream().
                map(x-> new Employee(em.getId(), em.getExperience(), em.getName(), em.getPhoneNumber())).
                collect(Collectors.toList());

        return newListEm;
    }

    @Override
    public String toString() {
        return "EmployeesList{" +
                "employeeList=" + employeeList +
                '}';
    }
}
