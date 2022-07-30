package com.arqjava.servicios;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.dao.CategoriaDAO;
import com.arqjava.dao.DAOFactory;
import com.arqjava.dao.DAOFactoryAbstract;
import com.arqjava.dao.LibroDAO;

import java.util.List;

public class ServicioLibros implements IServicioLibros {
    private LibroDAO libroDAO = null;
    private CategoriaDAO categoriaDAO = null;

    public ServicioLibros() {
        DAOFactory factoria = DAOFactoryAbstract.getInstance();
        libroDAO = factoria.getLibroDAO();
        categoriaDAO = factoria.getCategoriaDAO();
    }

    @Override
    public void insertarLibro(Libro libro) {
        libroDAO.insertar(libro);
    }

    @Override
    public void salvarLibro(Libro libro) {
        libroDAO.salvar(libro);
    }

    @Override
    public void borrarLibro(Libro libro) {
        libroDAO.borrar(libro);
    }

    @Override
    public List<Libro> buscarTodosLosLibros() {
        return libroDAO.buscarTodos();
    }

    @Override
    public List<Categoria> buscarCategoriasLibros() {
        return categoriaDAO.buscarTodos();
    }

    @Override
    public Libro buscarLibroPorClave(String isbn) {
        return libroDAO.buscarPorClave(isbn);
    }

    @Override
    public Categoria buscarCategoriaPorClave(String id) {
        return categoriaDAO.buscarPorClave(id);
    }

    @Override
    public List<Libro> buscarLibrosPorCategoria(String id) {
        Categoria categoria = categoriaDAO.buscarPorClave(id);
        return libroDAO.buscarPorCategoria(categoria);
    }
}
