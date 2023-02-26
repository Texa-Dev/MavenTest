package org.example;

import org.example.dao.GroupDao;
import org.example.dao.StudentDao;
import org.example.models.StuGroup;
import org.example.models.Student;
import org.hibernate.Session;

import java.time.LocalDate;

public class Main {

    public static void main(final String[] args) {


       /* Student s = new Student(0, "Gregory", "House", LocalDate.now());
        Student s1 = new Student(0, "Tony", "Stark", LocalDate.now());
        Student s2 = new Student(0, "John", "Snow", LocalDate.now());
        Student s3 = new Student(0, "Dean", "Winchester", LocalDate.now());
        StuGroup g = new StuGroup(0, "PV121");
        StuGroup g1 = new StuGroup(0, "PV221");
        StuGroup g2 = new StuGroup(0, "PV321");
        StuGroup g3 = new StuGroup(0, "PV421");*/
        //Добавление в базу данных
       /* StudentDao.save(s);
        StudentDao.save(s1);
        StudentDao.save(s2);
        StudentDao.save(s3);
        GroupDao.save(g);
        GroupDao.save(g1);
        GroupDao.save(g2);
        GroupDao.save(g3);*/

        //получение записи из таблицы по id
            Student findStu =  StudentDao.getById(1);
            System.out.println(findStu);
            StuGroup findGrp =  GroupDao.getById(2);
        System.out.println(findGrp);

        //удаление по id
       /*     System.out.println(StudentDao.getAllStudents());
            StudentDao.deleteById(2);
            System.out.println(StudentDao.getAllStudents());
        System.out.println("///----------------------------///");
        System.out.println(GroupDao.getAllGroups());
        GroupDao.deleteById(3);
        System.out.println(GroupDao.getAllGroups());*/



        //удаление по объекту сущности
   /*     StudentDao.delete(findStu);
        System.out.println(StudentDao.getAllStudents());
        GroupDao.delete(findGrp);
        System.out.println(GroupDao.getAllGroups());*/


        //обновление записи с помощью сущности (незнаю насколько это правильно но сущьность обновляеться)
            Student updateStu =  StudentDao.getById(3);
            updateStu.setName("Well");
            updateStu.setSurname("Done");
            StudentDao.update(updateStu);
            updateStu=  StudentDao.getById(3);
            System.out.println(updateStu);
        System.out.println("///----------------------------///");
        StuGroup updateGrp =  GroupDao.getById(4);
        updateGrp.setStuGrp("Done");
        GroupDao.update(updateGrp);
        updateGrp= GroupDao.getById(4);
        System.out.println(updateGrp);

//            System.out.println(StudentDao.getAllStudents());
        // System.out.println(GroupDao.getAllGroups());

    }

}