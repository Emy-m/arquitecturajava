package com.arqjava.controlador.acciones;

import com.arqjava.bo.Libro;
import com.arqjava.dao.LibroDAO;
import com.arqjava.dao.jpa.LibroDAOJPA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        LibroDAO libroDAO = new LibroDAOJPA();
        Libro libro = new Libro(isbn);
        libroDAO.borrar(libro);
        return "MostrarLibros";
    }
}
