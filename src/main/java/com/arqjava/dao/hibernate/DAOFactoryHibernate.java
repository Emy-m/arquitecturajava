package com.arqjava.dao.hibernate;

import com.arqjava.dao.CategoriaDAO;
import com.arqjava.dao.DAOFactory;
import com.arqjava.dao.LibroDAO;

public class DAOFactoryHibernate implements DAOFactory {
    public CategoriaDAO getCategoriaDAO() {
        return new CategoriaDAOHibernate();
    }
    public LibroDAO getLibroDAO() {
        return new LibroDAOHibernate();
    }
}
