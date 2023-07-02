package demo;

import domain.student;
import domain.studentDetails;
import domain.studentDocument;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteStudent {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg= new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(student.class);
        cfg=cfg.addAnnotatedClass(studentDetails.class);
        cfg=cfg.addAnnotatedClass(studentDocument.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID");
        int ID = sc.nextInt();

        student s = ses.get(student.class, ID);
        if (s!=null)
        {
            tx= ses.beginTransaction();
            ses.delete(s);
            tx.commit();
            System.out.println("Student Deleted Successfully");
        }
        else
        {
            System.out.println("INVALID ID");
        }
    }
}
