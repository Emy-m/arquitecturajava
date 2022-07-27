package com.arqjava.controlador.acciones;

import com.arqjava.bo.Libro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FiltrarLibrosPorCategoriaAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String categoria = request.getParameter("categoria");
        List<Libro> listaDeLibros = Libro.buscarPorCategoria(categoria);
        List<String> listaDeCategorias = Libro.buscarTodasLasCategorias();
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "/MostrarLibros.jsp";
    }
}
