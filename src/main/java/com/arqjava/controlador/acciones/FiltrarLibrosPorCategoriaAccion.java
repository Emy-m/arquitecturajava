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

public class FiltrarLibrosPorCategoriaAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String categoriaId = request.getParameter("categoria");
        Categoria categoria = new Categoria(categoriaId);
        LibroDAO libroDAO = new LibroDAOJPA();
        CategoriaDAO categoriaDAO = new CategoriaDAOJPA();
        List<Libro> listaDeLibros = libroDAO.buscarPorCategoria(categoria);
        List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "/MostrarLibros.jsp";
    }
}
