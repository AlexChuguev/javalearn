package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Student;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-21T13:56:02")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, String> name;
    public static volatile ListAttribute<Groups, Student> studentList;
    public static volatile SingularAttribute<Groups, Integer> id;

}