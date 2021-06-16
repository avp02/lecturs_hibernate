package com.avp.hibernate_annotation;

import com.avp.hibernate_annotation.bean.Boy;
import com.avp.hibernate_annotation.dao.HibernateUtil;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Boy boy = new Boy();
        boy.setBoy("Sania");
        session.save(boy);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shotdown();

    }
}
