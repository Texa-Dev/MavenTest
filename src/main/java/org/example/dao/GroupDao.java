package org.example.dao;

import org.example.HibernateUtil;
import org.example.models.StuGroup;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupDao {
    //получение записи из таблице по id
    public static StuGroup getById(int id) {
        StuGroup g=null;
        try (Session session = HibernateUtil.getSession()) {
            g = session.find(StuGroup.class,id);
        } catch(Exception e){
            e.printStackTrace();
        }
        return g;

    }
    // добавление новой записи в таблицу
    public static StuGroup save(StuGroup stuGroup) {
        StuGroup g=null;
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            g = session.merge(stuGroup);
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }
        return g;
    }
    //удаление по id
    public static void deleteById(int id) {
        StuGroup s=GroupDao.getById(id);
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.remove(s);
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }

    }
    //удаление по объекту сущности
    public static void delete(StuGroup stuGroup) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.remove(stuGroup);
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    //обновление записи с помощью сущности
    public static void update(StuGroup stuGroup) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.merge(stuGroup);
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    //получение всех студентов
    public static List<StuGroup> getAllGroups() {
        List<StuGroup> stuGroups =null;
        try (Session session = HibernateUtil.getSession()) {
        Query fromGroup = session.createQuery("from StuGroup");
            stuGroups = fromGroup.list();
        } catch(Exception e){
            e.printStackTrace();
        }
        return stuGroups;

    }
}
