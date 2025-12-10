package org.sk.mavenProject;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int marks;
    @Column
    private String email;
    
    public Student() {
    
    }
    
    public Student(int id, String name, int marks, String email) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.email = email;
    }
    
    public Student(String name, int marks, String email) {
        this.name = name;
        this.marks = marks;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getMarks() {
        return marks;
    }
    
    public void setMarks(int marks) {
        this.marks = marks;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", email='" + email + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && marks == student.marks && Objects.equals(name, student.name) && Objects.equals(email, student.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, marks, email);
    }
}
