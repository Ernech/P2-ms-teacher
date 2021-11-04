package com.arquitecturasoftware.msteacher.repositories;

import com.arquitecturasoftware.msteacher.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {



}
