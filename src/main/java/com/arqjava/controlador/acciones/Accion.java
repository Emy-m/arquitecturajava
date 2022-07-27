package com.arqjava.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.InvocationTargetException;

public abstract class Accion {
    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

    public static Accion getAccion(String tipo) {
        Accion accion = null;
        try {
            String clase = Accion.class.getPackage().getName()
                    + "." + tipo + "Accion";
            accion = (Accion) Class.forName(clase).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return accion;
    }
}
