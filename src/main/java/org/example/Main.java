package org.example;

import org.example.dao.StudentDao;
import org.example.models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class Main {

    public static void main(final String[] args)  {



        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
          //  System.out.println(session);

            //Добавление в базу данных
           /* Student s = new Student(0,"Gregory","House", LocalDate.now());
            Student s1 = new Student(0,"Tony","Stark", LocalDate.now());
            Student s2 = new Student(0,"John","Snow", LocalDate.now());
            Student s3 = new Student(0,"Dean","Winchester", LocalDate.now());
            StudentDao.save(s);
            StudentDao.save(s1);
            StudentDao.save(s2);
            StudentDao.save(s3);*/

            //получение записи из таблицы по id
          /*  Student findStu =  StudentDao.getById(1);
            System.out.println(findStu);*/

            //удаление по id
           /* System.out.println(StudentDao.getAllStudents());
            StudentDao.deleteById(2);
            System.out.println(StudentDao.getAllStudents());*/

            //удаление по объекту сущности
           /* StudentDao.delete(findStu);
            System.out.println(StudentDao.getAllStudents());*/


            //обновление записи с помощью сущности (незнаю насколько это правильно но сущьность обновляеться)
            Student updateStu =  StudentDao.getById(3);
            updateStu.setName("Well");
            updateStu.setSurname("Done");
            StudentDao.update(updateStu);
            updateStu=  StudentDao.getById(3);
            System.out.println(updateStu);

            System.out.println(StudentDao.getAllStudents());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}