package com.arqjava.main;

import com.arqjava.bo.HibernateHelper;
import com.arqjava.bo.Libro;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Principal {
    /*public static void main(String[] args) {
     *//*insertar*//*
        Session session = null;
        Transaction transaccion = null;
        try {
            SessionFactory factoria = new Configuration().configure().buildSessionFactory();
            session = factoria.openSession();
            transaccion = session.beginTransaction();
            Libro l = new Libro("1", "java", "programacion");
            session.saveOrUpdate(l);
            transaccion.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaccion.rollback();
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }*/

    /*public static void main(String[] args) {
     *//*Leer todos*//*
        Session session = null;
        try {
            SessionFactory factoria = new Configuration().configure()
                    .buildSessionFactory();
            session = factoria.openSession();
            Query consulta = session.createQuery("from Libro libro");
            List<Libro> lista = consulta.list();
            for (Libro l : lista) {
                System.out.println(l.getIsbn());
                System.out.println(l.getTitulo());
                System.out.println(l.getCategoria());
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }*/

    /*public static void main(String[] args) {
     *//*Leer uno*//*
        Session session = null;
        try {
            SessionFactory factoria = new Configuration().configure()
                    .buildSessionFactory();
            session = factoria.openSession();
            Libro libro = (Libro) session.get(Libro.class, "1");
            System.out.println(libro.getTitulo());
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }*/

    /*public static void main(String[] args) {
     *//*Borrar*//*
        Session session = null;
        try {
            SessionFactory factoria = new Configuration().configure().buildSessionFactory();
            session = factoria.openSession();
            session.beginTransaction();
            Libro libro = (Libro) session.get(Libro.class, "1");
            session.delete(libro);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }*/

    public static void main(String[] args) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        List<Libro> listaDeLibros = session.createQuery("from Libro libro").list();
        for (Libro l : listaDeLibros) {
            System.out.println(l.getTitulo());
            //accedemos a la categoria a traves de la relacion.
            System.out.println(l.getCategoria().getDescripcion());
        }
        session.close();
    }
}