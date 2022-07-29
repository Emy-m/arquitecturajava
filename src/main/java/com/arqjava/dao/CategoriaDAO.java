package com.arqjava.dao;

import com.arqjava.bo.Categoria;

import java.util.List;

public interface CategoriaDAO {
    List<Categoria> buscarTodos();

    Categoria buscar(String categoriaId);
}
