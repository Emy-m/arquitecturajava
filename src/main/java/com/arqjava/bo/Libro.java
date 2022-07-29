package com.arqjava.bo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    private String isbn;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        String isbnLibro = ((Libro) o).getIsbn();
        return isbnLibro.equals(isbn);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Libro(String isbn, String titulo, Categoria categoria) {
        super();
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public Libro(String isbn) {
        super();
        this.isbn = isbn;
    }

    public Libro() {
        super();
    }

    public void insertar() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
    }

    public void borrar() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.delete(this);
        session.getTransaction().commit();
    }

    public void salvar() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.saveOrUpdate(this);
        session.getTransaction().commit();
    }

    public static List<Libro> buscarTodos() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        Query query = session.createQuery("from Libro libro right join fetch libro.categoria");
        List<Libro> listaDeLibros = query.list();
        session.close();
        return listaDeLibros;
    }

    public static List<Libro> buscarTodos(String categoria) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        Query consulta = session.createQuery("from Libro libro where categoria like :categoria");
        consulta.setParameter("categoria", categoria);
        List<Libro> listaDeLibros = consulta.list();
        session.close();
        return listaDeLibros;
    }

    public static Libro buscarPorClave(String isbn) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        Libro libro = (Libro) session.get(Libro.class, isbn);
        session.close();
        return libro;
    }
}