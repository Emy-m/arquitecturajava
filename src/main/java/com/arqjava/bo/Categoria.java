package com.arqjava.bo;

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

    public Categoria() {
    }

    public Categoria(String id) {
        this.id = id;
    }

    public Categoria(String id, String descripcion) {
        this(id);
        this.descripcion = descripcion;
    }

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
}
