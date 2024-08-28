package org.example;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void deleteStudent(Student student);
    Student findByID(int ID);
    Student createStudent(Student student);
    Student updateStudent(Student student);
}
