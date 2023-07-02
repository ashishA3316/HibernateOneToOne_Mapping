package demo;

import domain.student;
import domain.studentDetails;
import domain.studentDocument;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp2 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(student.class);
        cfg=cfg.addAnnotatedClass(studentDetails.class);
        cfg=cfg.addAnnotatedClass(studentDocument.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        student s1 =new student();

        s1.setStudentName("SANKET");
        s1.setStudentContact(12345);

        studentDetails d1 = new studentDetails();
        d1.setAddress("MUMBAI");
        d1.setStream("MECH");
        d1.setPercentage(74.87);
        s1.setDetails(d1);

        studentDocument d2 = new studentDocument();
        d2.setPanNo("FVDER4000N");
        d2.setPassportNo("PRNF323499990");
        s1.setDocument(d2);
        tx= ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("STUDENT DETAILS INSERTED");
    }
}
