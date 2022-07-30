package com.arqjava.dao.hibernate;

import com.arqjava.dao.GenericDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDAOHibernate<T, Id extends Serializable> implements GenericDAO<T, Id> {
    private Class<T> claseDePersistencia;

    public GenericDAOHibernate() {
        this.claseDePersistencia = (Class<T>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T buscarPorClave(Id id) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        T objeto = null;
        try {
            objeto = (T) session.get(claseDePersistencia, id);
            return objeto;
        } finally {
            session.close();
        }
    }

    @Override
    public List<T> buscarTodos() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        try {
            Query query = session.createQuery("from Libro libro");
            List<T> lista = query.getResultList();
            return lista;
        } finally {
            session.close();
        }
    }

    @Override
    public void salvar(T objeto) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(objeto);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void borrar(T objeto) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.delete(objeto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void insertar(T objeto) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.save(objeto);
        session.getTransaction().commit();
        session.close();
    }
}
