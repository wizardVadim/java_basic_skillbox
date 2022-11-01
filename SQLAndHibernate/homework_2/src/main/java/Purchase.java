import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class Purchase
{

    @EmbeddedId
    private PurchaseKey key;

    public PurchaseKey getKey() {
        return key;
    }

    public void setKey(PurchaseKey key) {
        this.key = key;
    }

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}