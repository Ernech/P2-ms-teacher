package com.arquitecturasoftware.msteacher.services;

import com.arquitecturasoftware.msteacher.entities.Teacher;
import com.arquitecturasoftware.msteacher.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements ITeacherService{

    @Autowired
    TeacherRepository teacherRepository;


    @Override
    @Transactional
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Teacher> listAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    @Transactional
    public Teacher updateTeacher(Integer id, Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if(teacherOptional.isPresent()){
            Teacher teacherToUpdate = teacherOptional.get();
            teacherToUpdate.setName(teacher.getName());
            teacherToUpdate.setSubject(teacher.getSubject());
            return teacherRepository.save(teacherToUpdate);
        }
        else {
            return new Teacher(0,"","");
        }
    }
}
