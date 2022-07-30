package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.servicios.IServicioLibros;
import com.arqjava.servicios.ServicioLibros;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioEditarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        IServicioLibros servicio = new ServicioLibros();
        List<Categoria> categorias = servicio.buscarCategoriasLibros();
        Libro libro = servicio.buscarLibroPorClave(isbn);
        request.setAttribute("categorias", categorias);
        request.setAttribute("libro", libro);
        return "/FormularioEditarLibro.jsp";
    }
}