package com.arqjava.controlador.acciones;

import com.arqjava.bo.Libro;
import com.arqjava.dao.DAOFactory;
import com.arqjava.dao.DAOFactoryAbstract;
import com.arqjava.dao.LibroDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        DAOFactory factory = DAOFactoryAbstract.getInstance();
        LibroDAO libroDAO = factory.getLibroDAO();
        Libro libro = new Libro(isbn);
        libroDAO.borrar(libro);
        return "MostrarLibros";
    }
}
