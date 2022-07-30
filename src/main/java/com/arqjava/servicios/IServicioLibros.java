package com.arqjava.servicios;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;

import java.util.List;

public interface IServicioLibros {
    void insertarLibro(Libro libro);
    void salvarLibro(Libro libro);
    void borrarLibro(Libro libro);
    List<Libro> buscarTodosLosLibros();
    List<Categoria> buscarCategoriasLibros();
    Libro buscarLibroPorClave(String isbn);
    Categoria buscarCategoriaPorClave(String id);
    List<Libro> buscarLibrosPorCategoria(String categoria);
}