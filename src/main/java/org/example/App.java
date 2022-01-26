package org.example;

import org.example.entity.Student;
import org.example.util.HibernateUtl;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Student student = new Student("meder", "tynychbekov", 25);
        Student student1 = new Student("aza", "asanov", 22);
        Student student2 = new Student("aza", "kerimov", 11);
        createTable(student);
        createTable(student1);
        createTable(student2);
        System.out.println(getUser());
        changeAge();
        deleteColumn();
    }

    public static void createTable(Student student) {
        Session session = HibernateUtl.getSession().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully added!");
    }

    public static List getUser() {
        Session session = HibernateUtl.getSession().openSession();
        session.beginTransaction();
        List list = session.createQuery("from Student where name='aza' and age>20").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("your table is sorted!!!!!!!!!!!!!!");
        return list;
    }

    public static void changeAge() {
        Session session = HibernateUtl.getSession().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("update student set age=18 where name='aza'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("changed!!!!!!!!!!!!!!");
    }
    public static void deleteColumn() {
        Session session = HibernateUtl.getSession().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("delete from student where name='aza'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("changed!!!!!!!!!!!!!!");
    }

}
