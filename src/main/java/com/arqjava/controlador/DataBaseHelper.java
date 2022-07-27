package com.arqjava.controlador;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper<T> {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/arquitecturajava";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";
    private static final Logger log = LogManager.getLogger(DataBaseHelper.class);

    public int modificarRegistro(String consultaSQL) {
        Connection conexion = null;
        Statement sentencia = null;
        int filasAfectadas = 0;

        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            sentencia = conexion.createStatement();
            filasAfectadas = sentencia.executeUpdate(consultaSQL);
        } catch (ClassNotFoundException e) {
            log.error("Error de acceso al driver" + e.getMessage());
            throw new DataBaseException("Error de acceso al driver", e);
        } catch (SQLException e) {
            log.error("Error de SQL" + e.getMessage());
            throw new DataBaseException("Error de SQL", e);
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    log.error("Error con la sentencia" + e.getMessage());
                    throw new DataBaseException("Error de SQL", e);
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    log.error("Error cerrando la conexion" + e.getMessage());
                    throw new DataBaseException("Error de SQL", e);
                }
            }
        }
        return filasAfectadas;
    }

    public List<T> seleccionarRegistros(String consultaSQL, Class clase) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet filas = null;
        List<T> listaDeObjetos = new ArrayList<T>();
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            sentencia = conexion.createStatement();
            filas = sentencia.executeQuery(consultaSQL);
            while (filas.next()) {
                T objeto = (T) Class.forName(clase.getName()).getDeclaredConstructor().newInstance(); // La clase necesita un constructor con 0 parametros
                Method[] metodos = objeto.getClass().getDeclaredMethods();
                for (int i = 0; i < metodos.length; i++) {
                    if (metodos[i].getName().startsWith("set")) {
                        metodos[i].invoke(objeto, filas.getString(metodos[i].getName().substring(3)));
                    }
                    if (objeto.getClass().getName().equals("java.lang.String")) {
                        objeto = (T) filas.getString(1);
                    }
                }
                listaDeObjetos.add(objeto);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada" + e.getMessage());
            throw new DataBaseException("Clase no encontrada", e);
        } catch (SQLException e) {
            System.out.println("Error de SQL" + e.getMessage());
            throw new DataBaseException("Error de SQL", e);
        } catch (InstantiationException e) {
            System.out.println("Error de instanciacion: " + e.getMessage());
            throw new DataBaseException("Error de instanciacion", e);
        } catch (NoSuchMethodException e) {
            System.out.println("Metodo no encontrado: " + e.getMessage());
            throw new DataBaseException("Metodo no encontrado", e);
        } catch (InvocationTargetException e) {
            System.out.println("Error de invocacion: " + e.getMessage());
            throw new DataBaseException("Error de invocacion", e);
        } catch (IllegalAccessException e) {
            System.out.println("Acceso Ilegal: " + e.getMessage());
            throw new DataBaseException("Acceso Ilegal", e);
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    System.out.println("Error de SQL" + e.getMessage());
                    throw new DataBaseException("Error de SQL", e);
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error de SQL" + e.getMessage());
                    throw new DataBaseException("Error de SQL", e);
                }
            }
        }
        return listaDeObjetos;
    }

}
