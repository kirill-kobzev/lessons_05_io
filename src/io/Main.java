package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();

//        Задание a
//        employee.save(new Employee("Стаст",26,87000,"Java Developer"));

//        Задание b
//        employee.delete(new Employee("Стаст",26,87000,"Java Developer"));

//        Задание c
//        System.out.println(employee.getByName("Кирилл1"));

//        Задание d
//        List listEmployees = employee.getByJob("Художник");
//        for(Object o: listEmployees){
//            System.out.println(o);
//        }

//        Задание f
//          employee.saveOrUpdate(new Employee("Мария1",18,18000,"Художник"));

//        Задание e
//            employee.changeAllWork("Художник", "Программист");


//         Здесь можно указать своих сотрудников
//        employees.add(new Employee("Мария",25,33000,"Художник"));
//        employees.add(new Employee("Антон",24,33000,"Юрист"));
//        employees.add(new Employee("Кирилл",26,37000,"Специалист"));
//        employees.add(new Employee("Артём",25,33000,"Художник"));
//
//        employee.write(employees);

        List newEmployees = employee.read();

        for(Object o: newEmployees){
            System.out.println(o);
        }

    }
}
