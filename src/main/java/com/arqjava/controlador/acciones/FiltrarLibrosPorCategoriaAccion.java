package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.servicios.IServicioLibros;
import com.arqjava.servicios.ServicioLibros;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FiltrarLibrosPorCategoriaAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String categoriaId = request.getParameter("categoria");
        IServicioLibros servicio = new ServicioLibros();
        List<Libro> listaDeLibros = servicio.buscarLibrosPorCategoria(categoriaId);
        List<Categoria> listaDeCategorias = servicio.buscarCategoriasLibros();
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "/MostrarLibros.jsp";
    }
}
