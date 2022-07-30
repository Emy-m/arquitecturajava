package com.arqjava.dao.jpa;

import com.arqjava.dao.CategoriaDAO;
import com.arqjava.dao.DAOFactory;
import com.arqjava.dao.LibroDAO;

public class DAOFactoryJPA implements DAOFactory {
    public CategoriaDAO getCategoriaDAO() {
        return new CategoriaDAOJPA();
    }
    public LibroDAO getLibroDAO() {
        return new LibroDAOJPA();
    }
}
