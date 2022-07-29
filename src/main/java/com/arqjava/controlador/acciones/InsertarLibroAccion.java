package com.arqjava.controlador.acciones;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertarLibroAccion extends Accion {
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoriaId = request.getParameter("categoria");
        Categoria categoria = Categoria.buscar(categoriaId);
        Libro libro = new Libro(isbn, titulo, categoria);
        libro.insertar();
        return "MostrarLibros";
    }
}
