/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.Groups;
import model.Student;

/**
 *
 * @author Vladimir
 */
@Local
public interface UniverDAOLocal {

    public List<Student> getAllStudents() throws Exception;

    public void addStudent(String name, int age, int GroupId) throws Exception;

    public boolean deleteStudent(int idStudent) throws Exception;

    public List<Groups> getAllGroups() throws Exception;
}
