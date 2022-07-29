package com.arqjava.dao.jpa;

import com.arqjava.bo.Categoria;
import com.arqjava.dao.CategoriaDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class CategoriaDAOJPA extends GenericDAOJPA<Categoria, String> implements CategoriaDAO {
    @Override
    public Categoria buscar(String categoriaId) {
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        TypedQuery<Categoria> consulta =
                manager.createQuery("SELECT c FROM Categoria c where c.id = :categoriaId", Categoria.class);
        consulta.setParameter("categoriaId", categoriaId);
        Categoria categoria = manager.find(Categoria.class, categoriaId);
        manager.close();
        return categoria;
    }
}
