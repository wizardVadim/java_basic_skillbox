package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
public class Course {
    public Course() {
    }

    public Course(String name, int id, String teacherName) {
        this.name = name;
        this.id = id;
        this.teacherName = teacherName;
    }

    @NotEmpty(message = "This string is not empty")
    @Size(min = 2, max = 20, message = "Name size should be greater then 2 and smaller than 20")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "This string is not empty")
    @Size(min = 2, max = 20, message = "Name size should be greater then 2 and smaller than 20")
    private String teacherName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
