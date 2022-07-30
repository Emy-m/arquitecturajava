package com.arqjava.dao.hibernate;

import com.arqjava.bo.Categoria;
import com.arqjava.bo.Libro;
import com.arqjava.dao.LibroDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class LibroDAOHibernate extends GenericDAOHibernate<Libro, String> implements LibroDAO {
    @Override
    public List<Libro> buscarPorCategoria(Categoria categoria) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        List<Libro> listaDeLibros = null;
        try {
            Query query = session.createQuery("from Libro libro where categoria = :categ");
            query.setParameter("categ", categoria);
            listaDeLibros = query.getResultList();
        } finally {
            session.close();
        }
        return listaDeLibros;
    }
}
