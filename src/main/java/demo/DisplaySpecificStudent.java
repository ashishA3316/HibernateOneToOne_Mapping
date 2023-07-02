package demo;

import domain.student;
import domain.studentDetails;
import domain.studentDocument;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class DisplaySpecificStudent {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg= new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(student.class);
        cfg=cfg.addAnnotatedClass(studentDetails.class);
        cfg=cfg.addAnnotatedClass(studentDocument.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Query q = ses.createQuery("select s.studentName, sd.stream, sdc.panNo from student s inner join studentDetails sd on s.details=sd.detailsID inner join studentDocument sdc on s.document=sdc.documentID");
        List data = q.list();
        Iterator itr = data.iterator();
        while(itr.hasNext())
        {
            Object [] arr = (Object[]) itr.next();
            System.out.println("NAME"+"\t"+"STREAM"+"\t"+"PAN NO");
            System.out.println(arr[0]+"\t"+arr[1]+"\t"+arr[2]);
        }
    }
}
