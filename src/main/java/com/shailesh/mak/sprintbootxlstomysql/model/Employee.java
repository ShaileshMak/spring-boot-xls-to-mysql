package com.shailesh.mak.sprintbootxlstomysql.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    Integer age;
    String city;
    String state;
    String country;
    String dept;

    public Employee() {
    }

    public Employee(List<String> dataList) {
        this.firstName = dataList.get(0);
        this.lastName = dataList.get(1);
        this.age = (int)Double.parseDouble(dataList.get(2));
        this.city = dataList.get(3);
        this.state = dataList.get(4);
        this.country = dataList.get(5);
        this.dept = dataList.get(6);
    }

    public Employee(String firstName, String lastName, Integer age, String city, String state, String country, String dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.state = state;
        this.country = country;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age + ", city='" + city + '\'' + ", state='" + state + '\'' + ", country='" + country + '\'' + ", dept='" + dept + '\'' + '}';
    }
}
