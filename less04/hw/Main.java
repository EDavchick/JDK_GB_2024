package org.less04.hw;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeesList employeesList = new EmployeesList();
        employeesList.addEmployeeToList(new Employee(1, 10, "Ivan", "89651667584"));
        employeesList.addEmployeeToList(new Employee(2, 5, "Katya", "89021110077"));
        employeesList.addEmployeeToList(new Employee(3, 3, "Petya", "89761234567"));
        employeesList.addEmployeeToList(new Employee(4, 14, "Fedya", "89056172345"));
        employeesList.addEmployeeToList(new Employee(5, 5, "Ira", "89148761234"));
        employeesList.addEmployeeToList(new Employee(6, 9, "Ivan", "89555438192"));

//        employeesList.printAllEmployees();
        System.out.println("метод, который ищет сотрудника по стажу (может быть список):");
        employeesList.findEmployeeOnExperience(5);
        System.out.println();

        System.out.println("метод, который возвращает номер телефона сотрудника по имени (может быть список):");
        employeesList.returnPhoneNumberByName("Ivan");
        System.out.println();

        System.out.println("метод, который ищет сотрудника по табельному номеру:");
        employeesList.findEmployeeById(3);
        System.out.println();

        System.out.println("Добавить метод добавления нового сотрудника в справочник");
        employeesList.addNewEmployeeinList(new Employee(7, 6, "Lena", "89317236582"));
        System.out.println(employeesList);


    }
}
