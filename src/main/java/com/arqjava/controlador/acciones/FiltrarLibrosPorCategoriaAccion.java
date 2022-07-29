package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FiltrarLibrosPorCategoriaAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String categoria = request.getParameter("categoria");
        List<Libro> listaDeLibros = Libro.buscarTodos(categoria);
        List<Categoria> listaDeCategorias = Categoria.buscarTodos();
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "/MostrarLibros.jsp";
    }
}
