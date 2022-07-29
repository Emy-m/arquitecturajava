package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioEditarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        List<Categoria> categorias = Categoria.buscarTodos();
        Libro libro = Libro.buscarPorClave(request.getParameter("isbn"));
        request.setAttribute("categorias", categorias);
        request.setAttribute("libro", libro);
        return "/FormularioEditarLibro.jsp";
    }
}