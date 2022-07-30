package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.servicios.IServicioLibros;
import com.arqjava.servicios.ServicioLibros;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MostrarLibrosAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        IServicioLibros servicioLibros = new ServicioLibros();
        List<Libro> listaDeLibros = servicioLibros.buscarTodosLosLibros();
        List<Categoria> listaDeCategorias = servicioLibros.buscarCategoriasLibros();
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "/MostrarLibros.jsp";
    }
}
