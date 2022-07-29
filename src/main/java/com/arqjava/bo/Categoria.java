package com.arqjava.bo;

import com.arqjava.JPAHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    private String id;
    private String descripcion;
    @OneToMany
    @JoinColumn(name = "categoria")
    private List<Libro> listaDeLibros;

    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        String categoriaId = ((Categoria) o).getId();
        return id.equals(categoriaId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Libro> getListaDeLibros() {
        return listaDeLibros;
    }

    public void setListaDeLibros(List<Libro> listaDeLibros) {
        this.listaDeLibros = listaDeLibros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static List<Categoria> buscarTodos() {
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        TypedQuery<Categoria> consulta = manager.createQuery("SELECT c FROM Categoria c", Categoria.class);
        List<Categoria> listaDeCategorias = null;
        listaDeCategorias = consulta.getResultList();
        manager.close();
        return listaDeCategorias;
    }

    public static Categoria buscar(String categoriaId) {
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
