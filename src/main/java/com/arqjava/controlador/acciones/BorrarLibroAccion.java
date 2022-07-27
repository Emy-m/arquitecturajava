package com.arqjava.controlador.acciones;

import com.arqjava.bo.Libro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        Libro libro = new Libro(isbn);
        libro.borrar();
        return "MostrarLibros";
    }
}
