package com.avp.hibernate_annotation.dao;

import com.avp.hibernate_annotation.bean.Alumnus;
import com.avp.hibernate_annotation.bean.AlumnusPIIData;
import com.avp.hibernate_annotation.bean.Boy;
import com.avp.hibernate_annotation.bean.Student;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties settings = loadProperties();
                settings.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                Configuration configuration = new Configuration();
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Boy.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Alumnus.class);
                configuration.addAnnotatedClass(AlumnusPIIData.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static void shotdown() {
        //Close cashes and connection pools
        getSessionFactory().close();
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try(InputStream in = new FileInputStream("src/main/resources/avp02.properties")) {
            properties.load(in);
        } catch (Exception ex) {
            return null;
        }
        return properties;
    }
}
