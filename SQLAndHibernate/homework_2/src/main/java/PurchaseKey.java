import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseKey implements Serializable {

    public PurchaseKey() {}

    public PurchaseKey(String courseName, String studentName) {
        this.courseName = courseName;
        this.studentName = studentName;
    }

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "student_name")
    private String studentName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseKey that = (PurchaseKey) o;
        return Objects.equals(courseName, that.courseName) && Objects.equals(studentName, that.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, studentName);
    }
}
