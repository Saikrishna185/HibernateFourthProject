package org.sk.mavenProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Enter your id: ");
        int id = sc.nextInt();
        Student getStudent = session.get(Student.class, id);
        if (getStudent != null) {
            System.out.println("Enter your name: ");
            String name = sc.next();
            getStudent.setName(name);
            System.out.println("Enter your Email: ");
            String email = sc.next();
            getStudent.setEmail(email);
            // session.persist(getStudent);
            session.merge(getStudent);
            System.out.println("Student updated: " + getStudent);
        }
        else  {
            System.out.println("Student not found");
        }
        transaction.commit();
        session.close();
        factory.close();
    }
}