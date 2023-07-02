package domain;

import javax.persistence.*;

@Entity
@Table(name="student_doc")
public class studentDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private int documentID;
    @Column(name = "pan_no")
    private String panNo;
    @Column(name = "passport_no")
    private String passportNo;

    public int getDocumentID() {
        return documentID;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
}
