package org.less04.hw;
/* каждый сотрудник должен иметь следующие атрибуты:
    1.Табельный номер
    2.Номер телефона
    3.Имя
    4.Стаж
 */
public class Employee {
    private int id;
    private int experience;
    private String name;
    private String phoneNumber;

    public Employee(int id, int experience, String name, String phoneNumber) {
        this.id = id;
        this.experience = experience;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return STR."Employee with id#\{id}: experience \{experience} years, name \{name}, phoneNumber \{phoneNumber}\{'\n'}";
    }
}
