package com.divandsection.siddhantspringboot.controller;

import com.divandsection.siddhantspringboot.entity.Student;
import com.divandsection.siddhantspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentRepository srobj;


    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student)
    {
        return srobj.save(student);
    }

    @GetMapping("/all")
    public List<Student> getStudents() {
        return srobj.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return srobj.findById(id).get();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {

        Student s = srobj.findById(id).get();

        s.setName(student.getName());

        return srobj.save(s);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

        srobj.deleteById(id);

        return "Student Deleted";
    }
}