package org.example;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String number;

    public Student() {
    }

    public Student(int id, String name, String email, String phone, String number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.number = number;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s', email='%s', phone='%s', number='%s'}", id, name, email, phone, number);
    }
}