package com.divandsection.siddhantspringboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.divandsection.siddhantspringboot.entity.Student;


public interface StudentRepository extends JpaRepository<Student,Long>
{


}