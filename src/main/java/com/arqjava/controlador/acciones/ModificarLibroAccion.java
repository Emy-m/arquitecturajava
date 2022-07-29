package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.dao.CategoriaDAO;
import com.arqjava.dao.LibroDAO;
import com.arqjava.dao.jpa.CategoriaDAOJPA;
import com.arqjava.dao.jpa.LibroDAOJPA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoriaId = request.getParameter("categoria");

        CategoriaDAO categoriaDAO = new CategoriaDAOJPA();
        Categoria categoria = categoriaDAO.buscar(categoriaId);

        Libro libro = new Libro(isbn, titulo, categoria);
        LibroDAO libroDAO = new LibroDAOJPA();
        libroDAO.salvar(libro);

        return "MostrarLibros";
    }
}
