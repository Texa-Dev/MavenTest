package org.example;

public class Main {
    public static void main(String[] args){
        try {

            HibernateUtil.getSessionFactory().openSession();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}