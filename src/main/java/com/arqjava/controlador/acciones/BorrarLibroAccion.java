package com.arqjava.controlador.acciones;

import com.arqjava.bo.Libro;
import com.arqjava.dao.DAOFactory;
import com.arqjava.dao.DAOFactoryAbstract;
import com.arqjava.dao.LibroDAO;
import com.arqjava.servicios.IServicioLibros;
import com.arqjava.servicios.ServicioLibros;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        IServicioLibros servicio = new ServicioLibros();
        Libro libro = new Libro(isbn);
        servicio.borrarLibro(libro);
        return "MostrarLibros";
    }
}
