package domain;

import javax.persistence.*;

@Entity
@Table(name="student_master")
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentID;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_contact")
    private int studentContact;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_ref")
    private studentDetails details;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_ref")
    private studentDocument document;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(int studentContact) {
        this.studentContact = studentContact;
    }

    public studentDetails getDetails() {
        return details;
    }

    public void setDetails(studentDetails details) {
        this.details = details;
    }

    public studentDocument getDocument() {
        return document;
    }

    public void setDocument(studentDocument document) {
        this.document = document;
    }
}
