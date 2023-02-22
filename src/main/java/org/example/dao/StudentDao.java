package org.example.dao;


import org.example.HibernateUtil;
import org.example.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDao  {

    //получение записи из таблице по id
    public static Student getById(int id) {
        return null;
    }
    //пример метода для добавления новой записи в таблицу
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
    public static void deleteById(int id) {}
    //удаление по объекту сущности
    public static void delete(Student  user) {}
    //обновление записи с помощью сущности
    public static void update(Student student) {}

}
