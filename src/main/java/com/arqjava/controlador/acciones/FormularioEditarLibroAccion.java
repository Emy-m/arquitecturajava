package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.dao.CategoriaDAO;
import com.arqjava.dao.DAOFactory;
import com.arqjava.dao.DAOFactoryAbstract;
import com.arqjava.dao.LibroDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioEditarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        DAOFactory factory = DAOFactoryAbstract.getInstance();
        LibroDAO libroDAO = factory.getLibroDAO();
        CategoriaDAO categoriaDAO = factory.getCategoriaDAO();
        List<Categoria> categorias = categoriaDAO.buscarTodos();
        Libro libro = libroDAO.buscarPorClave(isbn);
        request.setAttribute("categorias", categorias);
        request.setAttribute("libro", libro);
        return "/FormularioEditarLibro.jsp";
    }
}