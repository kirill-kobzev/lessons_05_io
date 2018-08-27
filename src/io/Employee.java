package io;

import java.io.*;
import java.util.ArrayList;

public class Employee implements Serializable {

    private String name;
    private int age;
    private int salary;
    private String job;
    private Object Employee;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Employee(String name, int age, int salary, String job) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.job = job;
    }

    public Employee() {
    }

    public void save (Object Employee) {

        ArrayList<Employee> newEmployees= null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employee.dat"))){
            newEmployees = (ArrayList<Employee>)objectInputStream.readObject();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        newEmployees.add((io.Employee) this.Employee);

        try (
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
                objectOutputStream.writeObject(newEmployees);
            } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                '}';
    }


}
