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

public class FiltrarLibrosPorCategoriaAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String categoriaId = request.getParameter("categoria");
        Categoria categoria = new Categoria(categoriaId);
        DAOFactory factory = DAOFactoryAbstract.getInstance();
        LibroDAO libroDAO = factory.getLibroDAO();
        CategoriaDAO categoriaDAO = factory.getCategoriaDAO();
        List<Libro> listaDeLibros = libroDAO.buscarPorCategoria(categoria);
        List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "/MostrarLibros.jsp";
    }
}
