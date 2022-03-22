package MainAssignment;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.UUID;

public class EmployeeService  {
    HashSet<Employee> empset=new HashSet<>();
    Employee emp1=new Employee("101","Shubham",22,"HashedIn","SDET",5000,"Bangalore",1234567899);

    Scanner sc=new Scanner(System.in);
    boolean found=false;

     String id;
     String name;
     int age;
     String CompanyName;
     String designation;
     double salary;
     String address;
     int phone;

     public EmployeeService(){
         empset.add(emp1);
     }
     //view all
    public void viewAllEmployee(){
         for(Employee emp:empset){
             System.out.println(emp);
         }

    }
    //view on the based of ID

    public void viewEmployee(){
        System.out.println("enter id");
        id=sc.next();
        for(Employee emp:empset){
            if(emp.getId()==id){
                System.out.println(emp);
                found=true;
            }
        }
        if(found==false){
            System.out.println("No such Employee with this ID");
        }

    }
    //update
    //user-id cant be updated
    public void updateEmployee() throws Exception {
        System.out.println("Enter the name");
        name=sc.next();
        System.out.println("Enter the Designation");
        designation= sc.next();
        boolean found=false;
        for(Employee emp:empset){
            if(emp.getName().equals(name) && emp.getDesignation().equals(designation)){
                System.out.println("Enter name");
                name=sc.next();


//                System.out.println("Enter age");
//                age=sc.nextInt();
//                Validate.validateAge(age);
//                System.out.println("Enter Company");
//                CompanyName=sc.next();
//                System.out.println("Enter designation");
//                designation=sc.next();
//                System.out.println("Enter salary");
//                salary=sc.nextDouble();
//                Validate.validateSalary(salary);
//                System.out.println("enter address");
//                address=sc.nextLine();
//                System.out.println("Enter phone No");
//                phone=sc.nextInt();
//                Validate.validatePhone(phone);
//
//                emp.setName(name);
//                emp.setAge(age);
//                emp.setCompanyName(CompanyName);
//                emp.setDesignation(designation);
//                emp.setSalary(salary);
//                emp.setAddress(address);
//                emp.setPhone(phone);

                System.out.println("New updated details are");
                System.out.println(emp);
                found=true;

            }
        }
        if(found==false){
            System.out.println("Employee not found");

        }else{
            System.out.println("Details updated");
        }

    }
    //adding data to text file
    public void addData() throws Exception{
         File f=null;
         FileInputStream fis=null;
         ObjectInputStream ois=null;
         FileOutputStream fos=null;
         ObjectOutputStream oos=null;

         try{
             f= new File("C:/Users/shubhamkumar32/IdeaProjects/Oops_Assignment/src/MainAssignment/UserData.txt");
             if(f.exists()){
                 System.out.println("entered here");
//                 fis= new FileInputStream(f);
//                 fos = new FileOutputStream(f);
//                 //ois=new ObjectInputStream(fis);
//                 oos=new ObjectOutputStream(fos);
//                 //empset=(HashSet<Employee>)ois.readObject();
//                 oos.writeObject(empset);
//                 fos.close();
//                 oos.close();
                 FileWriter writer = new FileWriter(f);
                 for(Employee emp:empset)
                 {
                     writer.write(emp.toString());
                 }
                 writer.flush();
                 writer.close();
//
             }

         }catch(Exception e){
             e.printStackTrace();
         }
    }
    //delete
    public void deleteEmployee(){
        System.out.println("Enter id");
        id=sc.next();
        boolean found=false;

        Employee empdel=null;

        for(Employee emp:empset){
            if(emp.getId()==id){
                empdel=emp;
                found=true;
            }
        }
        if(found==false){
            System.out.println("Employee not found");
        }else{
            empset.remove(empdel);
            System.out.println("Employee deeted");
        }
    }
    //add employee
    public void addEmp() throws Exception{
        //System.out.println("Enter id");
        id=UUID.randomUUID().toString();
        System.out.println("Enter name");
        name=sc.next();
        System.out.println("Enter age");
        age=sc.nextInt();
        Validate.validateAge(age);
        System.out.println("Enter company");
        CompanyName=sc.next();
        System.out.println("Enter designation");
        designation=sc.next();
        System.out.println("ENter salary");
        salary=sc.nextDouble();
        Validate.validateSalary(salary);
        System.out.println("ENter address");
        address=sc.next();
        System.out.println("ENter phone");
        phone=sc.nextInt();
        Validate.validatePhone(phone);

        Employee emp=new Employee(id,name,age,CompanyName,designation,salary,address,phone);
        empset.add(emp);
        System.out.println("Newly added employee details are");

        //

    }
}
