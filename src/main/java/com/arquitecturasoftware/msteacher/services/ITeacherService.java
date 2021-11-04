package com.arquitecturasoftware.msteacher.services;

import com.arquitecturasoftware.msteacher.entities.Teacher;

import java.util.List;

public interface ITeacherService {

    Teacher createTeacher(Teacher teacher);

    List<Teacher> listAllTeachers();

    Teacher updateTeacher(Integer id, Teacher teacher);
}
