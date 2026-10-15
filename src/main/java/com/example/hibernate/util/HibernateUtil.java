package com.example.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            setDatabaseProperty(configuration, "DB_USER", "hibernate.connection.username");
            setDatabaseProperty(configuration, "DB_PASSWORD", "hibernate.connection.password");
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static void setDatabaseProperty(Configuration configuration, String environmentVariable,
            String propertyName) {
        String value = System.getenv(environmentVariable);
        if (value != null && !value.isBlank()) {
            configuration.setProperty(propertyName, value);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
