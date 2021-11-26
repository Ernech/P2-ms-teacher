package com.arquitecturasoftware.msteacher.controllers;

import com.arquitecturasoftware.msteacher.config.TeacherConfig;
import com.arquitecturasoftware.msteacher.entities.Teacher;
import com.arquitecturasoftware.msteacher.services.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/teacher")
public class TeacherController {

    @Autowired
    TeacherServiceImpl teacherService;

    @Autowired
    TeacherConfig teacherConfig;


    @GetMapping(path = "test")
    public String testEncrypt(){
        return teacherConfig.showConfiguration();
    }


    @PostMapping
    public Teacher createNewTeacher(@RequestBody Teacher teacher){

        return teacherService.createTeacher(teacher);
    }


    @GetMapping(path = "/all")
    public List<Teacher> getAllTeachers(){
        
        return teacherService.listAllTeachers();
    }
    @PutMapping(path = "/{id}")
    public Teacher updateTeacher(@PathVariable(value = "id") Integer id, @RequestBody Teacher teacher){
        return teacherService.updateTeacher(id,teacher);
    }

}
