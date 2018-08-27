package io;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {



        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.save(new Employee("Bhf",26,37000,"Спец1"));
//
//        employees.add(new Employee("Мария",15,33000,"Художник"));
//        employees.add(new Employee("Антон",14,33000,"Юрист"));
//        employees.add(new Employee("Кирилл1",26,37000,"Специалист1"));
//
//        try (
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
//                objectOutputStream.writeObject(employees);
//            } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }

        ArrayList<Employee> newEmployees= null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employee.dat"))){
            newEmployees = (ArrayList<Employee>)objectInputStream.readObject();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        for(Object o: newEmployees){
            System.out.println(o);
        }

    }
}
