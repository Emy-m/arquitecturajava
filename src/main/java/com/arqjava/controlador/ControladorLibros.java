package com.arqjava.controlador;

import com.arqjava.controlador.acciones.Accion;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ControladorLibros", value = "/ControladorLibros")
public class ControladorLibros extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        String url = request.getPathInfo().replace("/", "");
        Accion accion = Accion.getAccion(url);

        despachador = request.getRequestDispatcher(accion.ejecutar(request, response));
        despachador.forward(request, response);
    }
}