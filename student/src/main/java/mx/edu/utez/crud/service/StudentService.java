package mx.edu.utez.crud.service;

import mx.edu.utez.crud.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getStudentList();

}
