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


    // ADD STUDENT

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {

        return srobj.save(student);
    }


    // GET ALL STUDENTS

    @GetMapping("/all")
    public List<Student> getStudents() {

        return srobj.findAll();
    }


    // GET STUDENT BY ID

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {

        return srobj.findById(id).get();
    }


    // UPDATE STUDENT

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        Student s = srobj.findById(id).get();

        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setAddress(student.getAddress());
        s.setPhone(student.getPhone());
        s.setAge(student.getAge());

        return srobj.save(s);
    }


    // DELETE STUDENT

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

        srobj.deleteById(id);

        return "Student Deleted";
    }
}
