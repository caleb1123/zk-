package org.example;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.*;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

import java.util.List;
import java.util.NoSuchElementException;

public class StudentController extends SelectorComposer<Component> {
    @Wire
    private Listbox studentListbox;
    @Wire
    private Textbox idTextbox;
    @Wire
    private Textbox nameTextbox;
    @Wire
    private Textbox emailTextbox;
    @Wire
    private Textbox phoneTextbox;
    @Wire
    private Textbox numberTextbox;
    @Wire
    private Textbox addIdTextbox;
    @Wire
    private Textbox addNameTextbox;
    @Wire
    private Textbox addEmailTextbox;
    @Wire
    private Textbox addPhoneTextbox;
    @Wire
    private Textbox addNumberTextbox;


    private ListModelList<Student> dataModel = new ListModelList<>();
    private StudentService studentService = new StudentServiceImpl();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        if (studentListbox == null) {
            System.err.println("Error: studentListbox is null");
        } else {
            System.out.println("Initializing data model...");
            studentListbox.setModel(dataModel);
            List<Student> students = studentService.findAll();
            dataModel.addAll(students);
            System.out.println("Data model initialized with " + students.size() + " students.");
        }
    }

    @Listen("onSelect = #studentListbox")
    public void showDetail() {
        if (studentListbox == null) {
            System.err.println("Error: studentListbox is null");
            return;
        }
        Student selectedStudent = dataModel.getSelection().iterator().next();
        idTextbox.setValue(String.valueOf(selectedStudent.getId()));
        nameTextbox.setValue(selectedStudent.getName());
        emailTextbox.setValue(selectedStudent.getEmail());
        phoneTextbox.setValue(selectedStudent.getPhone());
        numberTextbox.setValue(selectedStudent.getNumber());
        System.out.println("Selected student: " + selectedStudent.getName());
    }

    @Listen("onStudentUpdate = #studentListbox")
    public void updateStudent(ForwardEvent evt) {
        int id = Integer.parseInt(idTextbox.getValue());
        String name = nameTextbox.getValue();
        String email = emailTextbox.getValue();
        String phone = phoneTextbox.getValue();
        String number = numberTextbox.getValue();

        Student updatedStudent = new Student(id, name, email, phone, number);
        studentService.updateStudent(updatedStudent);

        dataModel.clear();
        dataModel.addAll(studentService.findAll());
        System.out.println("Student updated: " + updatedStudent.getName());
    }

    @Listen("onStudentDelete = #studentListbox")
    public void deleteStudent(ForwardEvent evt) {
        try {
            Student selectedStudent = dataModel.getSelection().iterator().next();
            studentService.deleteStudent(selectedStudent);

            dataModel.clear();
            dataModel.addAll(studentService.findAll());
            System.out.println("Student deleted: " + selectedStudent.getName());
        } catch (NoSuchElementException e) {
            System.err.println("No student selected for deletion.");
        }
    }

    @Listen("onStudentAdd = #studentListbox")
    public void addStudent(ForwardEvent evt) {
        int id = Integer.parseInt(addIdTextbox.getValue());
        String name = addNameTextbox.getValue();
        String email = addEmailTextbox.getValue();
        String phone = addPhoneTextbox.getValue();
        String number = addNumberTextbox.getValue();

        Student newStudent = new Student(id, name, email, phone, number);
        studentService.createStudent(newStudent);

        dataModel.clear();
        dataModel.addAll(studentService.findAll());
        System.out.println("Student added: " + newStudent.getName());

        addIdTextbox.setValue("");
        addNameTextbox.setValue("");
        addEmailTextbox.setValue("");
        addPhoneTextbox.setValue("");
        addNumberTextbox.setValue("");
    }

    @Listen("onStudentClear = #studentListbox")
    public void clearStudent(ForwardEvent evt) {
        addIdTextbox.setValue("");
        addNameTextbox.setValue("");
        addPhoneTextbox.setValue("");
        addEmailTextbox.setValue("");
        addNumberTextbox.setValue("");
    }
}