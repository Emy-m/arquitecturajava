package com.arqjava.dao;

public interface DAOFactory {
    CategoriaDAO getCategoriaDAO();

    LibroDAO getLibroDAO();
}
