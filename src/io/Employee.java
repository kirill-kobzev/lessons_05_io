package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee implements Serializable {

    private String name;
    private int age;
    private int salary;
    private String job;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getJob() {
        return job;
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

    public boolean save (Employee employee) {

        List<Employee> newEmployees = read();

        newEmployees.add(employee);
        write(newEmployees);

        return true;
    }

    public boolean delete (Employee employee){

        List<Employee> newEmployees = read();

        for(int i = 0; i<newEmployees.size(); i++){
            if(employee.equals(newEmployees.get(i)) == true){
                newEmployees.remove(i);
            }
        }

        write(newEmployees);

        return true;

    }

    public Employee getByName(String name){

        int index = -1;

        List<Employee> newEmployees = read();

        for(int i = 0; i < newEmployees.size(); i++){
            if(name.equals(newEmployees.get(i).getName())){
                index = i;
            }
        }

        if(index != -1) {
            return newEmployees.get(index);
        }else{
            return null;
        }
    }

    List<Employee> getByJob(String job){

        List<Employee> employeesJobs = new ArrayList<>();

        List<Employee> newEmployees = read();

        for(int i = 0; i < newEmployees.size(); i++){
            if(job.equals(newEmployees.get(i).getJob())){
               employeesJobs.add(newEmployees.get(i));
            }
        }

        return employeesJobs;
    }

    boolean saveOrUpdate (Employee employee){

        Employee newEmployee = getByName(employee.getName());
        if(newEmployee != null){
            int index = -1;

            List<Employee> newEmployees = read();

            for(int i = 0; i < newEmployees.size(); i++){
                if(employee.getName().equals(newEmployees.get(i).getName())){
                    newEmployees.get(i).setAge(employee.getAge()) ;
                    newEmployees.get(i).setJob(employee.getJob());
                    newEmployees.get(i).setSalary(employee.getSalary());
                }
            }
            write(newEmployees);

        }else{
            save(employee);
        }

        return true;
    }

    boolean changeAllWork (String searchJob, String replaceJob){

        List<Employee> newEmployees = read();

        for(int i = 0; i < newEmployees.size(); i++){
            if(searchJob.equals(newEmployees.get(i).getJob())){
                newEmployees.get(i).setJob(replaceJob);
            }
        }

        write(newEmployees);


        return true;
    }

    static void write(List employees){

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            objectOutputStream.writeObject(employees);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    static List read(){

        List<Employee> newEmployees= null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employee.dat"))){
            newEmployees = (ArrayList<Employee>)objectInputStream.readObject();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return newEmployees;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                salary == employee.salary &&
                Objects.equals(name, employee.name) &&
                Objects.equals(job, employee.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, job);
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
