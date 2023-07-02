package demo;

import domain.student;
import domain.studentDetails;
import domain.studentDocument;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DispAllStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER STUDENT STREAM");
        String stream =sc.next();
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(student.class);
        cfg=cfg.addAnnotatedClass(studentDetails.class);
        cfg=cfg.addAnnotatedClass(studentDocument.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

//        Criteria crt = ses.createCriteria(student.class);
//        List<student> studentList = crt.list();
//        for(student s : studentList)
//        {
//            System.out.println("=========================================");
//            System.out.println("NAME "+s.getStudentName());
//            System.out.println("CONTACT "+s.getStudentContact());
//            studentDetails details = s.getDetails();
//            System.out.println("ADDRESS "+details.getAddress());
//            System.out.println("STREAM "+details.getStream());
//            System.out.println("MARKS "+details.getPercentage());
//            studentDocument doc = s.getDocument();
//            System.out.println("PAN NO "+doc.getPanNo());
//            System.out.println("PASSPORT NO "+doc.getPassportNo());
//            System.out.println("=========================================");
//        }


//        Query q1 = ses.createQuery("select s.studentName, sd.stream from student s inner join studentDetails sd on s.details=sd.detailsID");
//        List data = q1.list();
//        Iterator itr = data.iterator();
//        while(itr.hasNext())
//        {
//            Object [] arr = (Object[]) itr.next();
//            System.out.println(arr[0]+"\t"+arr[1]);
//        }

        Query q2 = ses.createQuery("select s.studentName, sd.stream, sd.address, sd.percentage from student s inner join studentDetails sd on s.details=sd.detailsID where sd.stream='"+stream+"' ");
        List data1 = q2.list();
        Iterator itr1 = data1.iterator();
        while(itr1.hasNext())
        {
            Object [] arr = (Object[]) itr1.next();
            System.out.println(arr[0]+"\t"+arr[1]+"\t"+arr[2]+"\t"+arr[3]);
        }
    }
}
