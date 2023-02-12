package mx.edu.utez.crud.controller;

import mx.edu.utez.crud.model.Student;
import mx.edu.utez.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/")
    public List<Student> getStudentList(){
        return studentService.getStudentList();
    }
}
