/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UniverDAOLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Groups;
import model.Student;

/**
 *
 * @author Vladimir
 */
@Named(value = "mBeans")
@RequestScoped
public class MBeans {

    @EJB
    private UniverDAOLocal dAOLocal;
    private Student student;
    private String studentName;
    private int age;
    private int groupId;

    @PostConstruct
    private void initializeBean() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<Student> getAllStudents() throws Exception {
        return dAOLocal.getAllStudents();
    }

    public String addStudent() throws Exception {
        this.dAOLocal.addStudent(studentName, age, groupId);
        return "/Students.xhtml";
    }

    public List<Groups> getAllGroups() throws Exception {
        return dAOLocal.getAllGroups();
    }
}
