/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "EXCEPCION", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Excepcion.findAll", query = "SELECT e FROM Excepcion e"),
    @NamedQuery(name = "Excepcion.findById", query = "SELECT e FROM Excepcion e WHERE e.id = :id"),
    @NamedQuery(name = "Excepcion.findByNombre", query = "SELECT e FROM Excepcion e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Excepcion.findByDescripcion", query = "SELECT e FROM Excepcion e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Excepcion.findBySubsanada", query = "SELECT e FROM Excepcion e WHERE e.subsanada = :subsanada")})
public class Excepcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 1000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "SUBSANADA")
    private Short subsanada;

    public Excepcion() {
    }

    public Excepcion(Long id) {
        this.id = id;
    }

    public Excepcion(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getSubsanada() {
        return subsanada;
    }

    public void setSubsanada(Short subsanada) {
        this.subsanada = subsanada;
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
        if (!(object instanceof Excepcion)) {
            return false;
        }
        Excepcion other = (Excepcion) object;
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
