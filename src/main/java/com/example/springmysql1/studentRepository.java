package com.example.springmysql1;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<student, Long> {

    Optional<student> findByRollNo(int rollNo);

}