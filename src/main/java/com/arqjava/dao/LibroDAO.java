package com.arqjava.dao;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;

import java.util.List;

public interface LibroDAO {
    void borrar(Libro libro);

    void salvar(Libro libro);

    List<Libro> buscarTodos();

    Libro buscarPorClave(String isbn);

    List<Libro> buscarPorCategoria(Categoria categoria);

    void insertar(Libro libro);
}
