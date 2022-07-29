package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.dao.CategoriaDAO;
import com.arqjava.dao.LibroDAO;
import com.arqjava.dao.jpa.CategoriaDAOJPA;
import com.arqjava.dao.jpa.LibroDAOJPA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioEditarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        LibroDAO libroDAO = new LibroDAOJPA();
        CategoriaDAO categoriaDAO = new CategoriaDAOJPA();
        List<Categoria> categorias = categoriaDAO.buscarTodos();
        Libro libro = libroDAO.buscarPorClave(isbn);
        request.setAttribute("categorias", categorias);
        request.setAttribute("libro", libro);
        return "/FormularioEditarLibro.jsp";
    }
}