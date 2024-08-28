package org.example;

import java.util.List;
import java.util.ArrayList;

public class StudentViewModel {
    private List<Student> students;
    private Student selectedStudent;



    // Getter for students
    public List<Student> getStudents() {
        return students;
    }

    // Getter and Setter for selectedStudent
    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    // Command methods
    public void addStudent() {
        students.add(selectedStudent);
        selectedStudent = new Student();
    }

    public void updateStudent() {
        // Update logic here
    }

    public void findStudentByID(Student student) {
        selectedStudent = student;
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }
}