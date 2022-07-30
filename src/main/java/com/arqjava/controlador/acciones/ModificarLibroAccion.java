package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.dao.CategoriaDAO;
import com.arqjava.dao.DAOFactory;
import com.arqjava.dao.DAOFactoryAbstract;
import com.arqjava.dao.LibroDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        DAOFactory factory = DAOFactoryAbstract.getInstance();
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoriaId = request.getParameter("categoria");

        CategoriaDAO categoriaDAO = factory.getCategoriaDAO();
        Categoria categoria = categoriaDAO.buscarPorClave(categoriaId);

        Libro libro = new Libro(isbn, titulo, categoria);
        LibroDAO libroDAO = factory.getLibroDAO();
        libroDAO.salvar(libro);

        return "MostrarLibros";
    }
}
