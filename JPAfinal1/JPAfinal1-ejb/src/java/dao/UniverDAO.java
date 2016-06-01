/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Groups;
import model.Student;


@Stateless
public class UniverDAO implements UniverDAOLocal {

    
     @PersistenceContext(unitName = "JPAfinal1-ejbPU")
     private EntityManager em;
    
    @Override
    public List<Student> getAllStudents() throws Exception {
       TypedQuery<Student> namedQuery = em.createNamedQuery("Student.findAll", Student.class);
       return namedQuery.getResultList();
    }

    @Override
    public void addStudent(String name, int age, int GroupId) throws Exception {
       Student student = new Student();
       student.setName(name);
       student.setAge(age);
       student.setGroupId(em.getReference(Groups.class, GroupId));
       Groups group = em.getReference(Groups.class, GroupId);
       group.getStudentList().add(student);
       em.merge(group);
    }

    @Override
    public boolean deleteStudent(int idStudent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Groups> getAllGroups() throws Exception {
       Query query = em.createQuery("SELECT g FROM Groups g", Groups.class);
       return query.getResultList();
    }

    
}
