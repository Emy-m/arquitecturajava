package com.arqjava.dao;

import com.arqjava.dao.hibernate.DAOFactoryHibernate;
import com.arqjava.dao.jpa.DAOFactoryJPA;

public abstract class DAOFactoryAbstract {
    public static DAOFactory getInstance() {
        String tipo = "JPA";
        if (tipo.equals("Hibernate")) {
            return new DAOFactoryHibernate();
        } else {
            return new DAOFactoryJPA();
        }
    }
}
