package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.servicios.IServicioLibros;
import com.arqjava.servicios.ServicioLibros;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioInsertarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        IServicioLibros servicio = new ServicioLibros();
        List<Categoria> listaDeCategorias = servicio.buscarCategoriasLibros();
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "/FormularioInsertarLibro.jsp";
    }
}
