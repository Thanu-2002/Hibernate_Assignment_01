package org.example;


import org.example.config.FactoryConfiguration;
import org.example.embed.FullName;
import org.example.entity.Customer;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session= FactoryConfiguration.getInstance().getSession();

        FullName fullName=new FullName("thanura","vipulanga");
        Student student= new Student(03,fullName,"Colombo");
        Customer customer = new Customer(01,"kalum","Galle");

        //open Transection
        Transaction transaction=session.beginTransaction();


       session.save(student);          //Done
        session.delete(student);      //Done
        session.update(student);     //Done

        //session.save(customer);    //Done save
        //session.delete(cutomer);      //Done
        //session.update(customer);    //Done update
       Customer customer1 = session.get(Customer.class,01);  //Done get

        transaction.commit();
       System.out.println(customer1);

        session.close();

    }
}