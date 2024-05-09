package com.example.springboot.controller;

import com.example.springboot.beans.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Nguyen Dang", "Duy");

//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return ResponseEntity.ok()
                .header("custom-header", "duyNguyen")
                .body(student);
    }


    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        return students;
    }

    // spring boot REST API with Path variable
    // {id} - URI template variable
    // http://localhost:8080/students/1/ramesh/fadate
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }


    // spring boot REST API with Request param
    // http://localhost:8080/students/query?id=1
    // http://localhost:8080/students/query?id=1               &firstName=Ramesh&lastName=Fadatare
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    // spring boot REST API that handles HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody
    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
//        return student;
        return new  ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // spring boot REST API that handles HTTP PUT Request - updating existing resource

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
//        return "Student deleted successfully";
        return ResponseEntity.ok("Student deleted successfully");
    }

}

