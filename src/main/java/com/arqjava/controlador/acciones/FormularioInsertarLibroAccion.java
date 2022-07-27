package com.arqjava.controlador.acciones;

import com.arqjava.bo.Libro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioInsertarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<String> listaDeCategorias = null;
        listaDeCategorias = Libro.buscarTodasLasCategorias();
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "/FormularioInsertarLibro.jsp";
    }
}
