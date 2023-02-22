package org.example;

import org.example.models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(final String[] args)  {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
          //  System.out.println(session);

            //Добавление в базу данных
        /* User u = new User(0,"Alla", LocalDate.of(1988 ,12,30),true,10);
         User u2 = new User(0,"Dania", LocalDate.of(2006,2,5),true,14);
         Client c1 = new Client(0,"Sania", "0503216547");
         Client c2 = new Client(0,"Serega", "09955443331");
            Transaction transaction = session.beginTransaction();
            session.merge(u);
            session.merge(u2);
            session.merge(c1);
            session.merge(c2);
            transaction.commit();*/

            //Поиск по базе
           /* Query<User> fromUsers = session.createQuery("from User where id =:p1 or id =:p2", User.class);
            fromUsers.setParameter("p1", "2");
            fromUsers.setParameter("p2", "3");

            fromUsers.setParameter(0 , "2"); //from User where id =?0 or id =?1
            fromUsers.setParameter(1, "3");

            List<User> list = fromUsers.list();
            list.forEach(System.out::println);*/

            //Удаление из базы
            Transaction transaction = session.beginTransaction();
            Student delUser = session.find(Student.class,2);

            session.remove(delUser);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}