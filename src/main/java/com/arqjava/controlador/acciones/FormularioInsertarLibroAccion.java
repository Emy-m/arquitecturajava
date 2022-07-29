package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.dao.jpa.CategoriaDAOJPA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioInsertarLibroAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        CategoriaDAOJPA categoriaDAO = new CategoriaDAOJPA();
        List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "/FormularioInsertarLibro.jsp";
    }
}
