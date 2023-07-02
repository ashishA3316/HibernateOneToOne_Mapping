package domain;

import javax.persistence.*;

@Entity
@Table(name="student_details")
public class studentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "details_id")
    private int detailsID;
    @Column(name = "address")
    private String address;
    @Column(name = "stream")
    private String stream;
    @Column(name = "percentage")
    private double percentage;

    public int getDetailsID() {
        return detailsID;
    }

    public void setDetailsID(int detailsID) {
        this.detailsID = detailsID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
