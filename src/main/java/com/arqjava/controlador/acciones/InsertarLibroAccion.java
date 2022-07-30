package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.servicios.IServicioLibros;
import com.arqjava.servicios.ServicioLibros;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertarLibroAccion extends Accion {
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoriaId = request.getParameter("categoria");

        IServicioLibros servicio = new ServicioLibros();
        Categoria categoria = servicio.buscarCategoriaPorClave(categoriaId);
        Libro libro = new Libro(isbn, titulo, categoria);
        servicio.insertarLibro(libro);

        return "MostrarLibros";
    }
}
