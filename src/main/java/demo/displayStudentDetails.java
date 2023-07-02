package demo;

import domain.student;
import domain.studentDetails;
import domain.studentDocument;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class displayStudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER STUDENT ID");
        int id = sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session  ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(student.class);
        cfg=cfg.addAnnotatedClass(studentDetails.class);
        cfg=cfg.addAnnotatedClass(studentDocument.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        student s1 = ses.get(student.class, id);
        System.out.println("NAME "+s1.getStudentName());
        System.out.println("CONTACT "+s1.getStudentContact());
        studentDetails details = s1.getDetails();
        System.out.println("ADDRESS "+details.getAddress());
        System.out.println("STREAM "+details.getStream());
        System.out.println("MARKS "+details.getPercentage());
        studentDocument doc = s1.getDocument();
        System.out.println("PAN NO "+doc.getPanNo());
        System.out.println("PASSPORT NO "+doc.getPassportNo());
    }
}
