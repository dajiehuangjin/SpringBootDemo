package com.wq.springboot.controller;

import com.wq.springboot.common.json.CallResult;
import com.wq.springboot.entity.MyStudent;
import com.wq.springboot.mapper.MyStudentMapper;
import com.wq.springboot.mapper.StudentMapper;
import com.wq.springboot.pojo.Student;
import com.wq.springboot.service.IMyStudentService;
import com.wq.springboot.service.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;    //测试用

    @Autowired
    private IStudentService studentService;     //测试用

    //正式使用 myStudentMapper和myStudentService
    @Autowired
    private MyStudentMapper myStudentMapper;
    @Autowired
    private IMyStudentService myStudentService;
   
    @RequestMapping("/students")
    public String listStudent(Model model) {
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @RequestMapping("/mapper_students")
    public String map_list(Model model){
        List<MyStudent> students = studentService.findAllByOrder("student_id desc");
        model.addAttribute("students", students);
        return "students";
    }

    @ResponseBody
    @RequestMapping(value = "/id/{id}/json", method = RequestMethod.GET)
    public CallResult student_json(@PathVariable Long id){
        MyStudent userInfo = myStudentService.getById(myStudentMapper, id);
        CallResult cr = new CallResult(true);
        cr.setData(userInfo);
        return cr;
    }
    
    @ResponseBody
    @RequestMapping(value = "/names/json", method = RequestMethod.GET)
    public CallResult student_name_json(){
        List<String> name_list = myStudentService.getAllName(myStudentMapper);
        CallResult cr = new CallResult(true);
        cr.setRows(name_list);
        return cr;
    }
}
