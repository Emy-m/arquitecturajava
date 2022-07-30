package com.arqjava.dao;

import com.arqjava.bo.Categoria;

import java.util.List;

public interface CategoriaDAO {
    Categoria buscarPorClave(String id);

    List<Categoria> buscarTodos();

    void salvar(Categoria objeto);

    void borrar(Categoria objeto);

    void insertar(Categoria objeto);
}
