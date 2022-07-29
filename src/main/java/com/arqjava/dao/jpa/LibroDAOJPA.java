package com.arqjava.dao.jpa;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.dao.LibroDAO;

import javax.persistence.*;
import java.util.List;

public class LibroDAOJPA extends GenericDAOJPA<Libro, String> implements LibroDAO {
    public List<Libro> buscarTodos() {
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        TypedQuery<Libro> consulta =
                manager.createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria", Libro.class);
        return consulta.getResultList();
    }

    public List<Libro> buscarPorCategoria(Categoria categoria) {
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        TypedQuery<Libro> consulta =
                manager.createQuery("Select l from Libro l where l.categoria=?1", Libro.class);
        consulta.setParameter(1, categoria);
        List<Libro> listaDeLibros = null;
        try {
            listaDeLibros = consulta.getResultList();
        } finally {
            manager.close();
        }
        return listaDeLibros;
    }
}
