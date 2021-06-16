package com.avp.hibernate;

import com.avp.hibernate.bean.Boy;
import com.avp.hibernate.dao.HibernateUtil;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Boy boy = new Boy();
        boy.setBoy("Vavavvv");
        session.save(boy);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shotdown();

    }
}
