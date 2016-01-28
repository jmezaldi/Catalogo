/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "BASE_DATOS", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaseDatos.findAll", query = "SELECT b FROM BaseDatos b"),
    @NamedQuery(name = "BaseDatos.findById", query = "SELECT b FROM BaseDatos b WHERE b.id = :id"),
    @NamedQuery(name = "BaseDatos.findByNombre", query = "SELECT b FROM BaseDatos b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "BaseDatos.findByDatosSensibles", query = "SELECT b FROM BaseDatos b WHERE b.datosSensibles = :datosSensibles"),
    @NamedQuery(name = "BaseDatos.findByComentarioInterno", query = "SELECT b FROM BaseDatos b WHERE b.comentarioInterno = :comentarioInterno"),
    @NamedQuery(name = "BaseDatos.findByDescripcion", query = "SELECT b FROM BaseDatos b WHERE b.descripcion = :descripcion")})
public class BaseDatos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DATOS_SENSIBLES")
    private Character datosSensibles;
    @Size(max = 1000)
    @Column(name = "COMENTARIO_INTERNO")
    private String comentarioInterno;
    @Size(max = 1000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idBaseDatos")
    private Collection<StoreProcedure> storeProcedureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBaseDatos")
    private Collection<Entidad> entidadCollection;
    @OneToMany(mappedBy = "idBaseDatos")
    private Collection<Funcion> funcionCollection;

    public BaseDatos() {
    }

    public BaseDatos(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getDatosSensibles() {
        return datosSensibles;
    }

    public void setDatosSensibles(Character datosSensibles) {
        this.datosSensibles = datosSensibles;
    }

    public String getComentarioInterno() {
        return comentarioInterno;
    }

    public void setComentarioInterno(String comentarioInterno) {
        this.comentarioInterno = comentarioInterno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<StoreProcedure> getStoreProcedureCollection() {
        return storeProcedureCollection;
    }

    public void setStoreProcedureCollection(Collection<StoreProcedure> storeProcedureCollection) {
        this.storeProcedureCollection = storeProcedureCollection;
    }

    @XmlTransient
    public Collection<Entidad> getEntidadCollection() {
        return entidadCollection;
    }

    public void setEntidadCollection(Collection<Entidad> entidadCollection) {
        this.entidadCollection = entidadCollection;
    }

    @XmlTransient
    public Collection<Funcion> getFuncionCollection() {
        return funcionCollection;
    }

    public void setFuncionCollection(Collection<Funcion> funcionCollection) {
        this.funcionCollection = funcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaseDatos)) {
            return false;
        }
        BaseDatos other = (BaseDatos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
