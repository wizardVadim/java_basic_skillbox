import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription
{
    @EmbeddedId
    private Key id;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }


    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
