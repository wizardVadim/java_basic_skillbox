import javax.persistence.*;

@Table(name = "linkedpurchaselist")
@Entity
public class LinkedPurchase {

    @EmbeddedId
    private LinkedPurchaseKey key;

    @Column(insertable = false, updatable = false)
    private int studentId;

    @Column(insertable = false, updatable = false)
    private int courseId;

    public LinkedPurchaseKey getKey() {
        return key;
    }

    public void setKey(LinkedPurchaseKey key) {
        this.key = key;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
