package org.example.dao;


import org.example.HibernateUtil;
import org.example.models.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDao  {

    //получение записи из таблице по id
    public static Student getById(int id) {
        Student s=null;
        try (Session session = HibernateUtil.getSession()) {
            s = session.find(Student.class,id);
        } catch(Exception e){
            e.printStackTrace();
        }
        return s;

    }
    // добавление новой записи в таблицу
    public static Student save(Student student) {
        Student s=null;
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            s = session.merge(student);
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
    //удаление по id
    public static void deleteById(int id) {
        Student s=StudentDao.getById(id);
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.remove(s);
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }

    }
    //удаление по объекту сущности
    public static void delete(Student  student) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.remove(student);
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    //обновление записи с помощью сущности
    public static void update(Student student) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    //получение всех студентов
    public static List<Student> getAllStudents() {
       List<Student> students=null;
        try (Session session = HibernateUtil.getSession()) {
            Query fromStudent = session.createQuery("from Student");
            students = fromStudent.list();
        } catch(Exception e){
            e.printStackTrace();
        }
        return students;

    }

}
