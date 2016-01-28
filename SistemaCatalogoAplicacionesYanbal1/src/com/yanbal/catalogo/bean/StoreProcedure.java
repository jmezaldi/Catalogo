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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "STORE_PROCEDURE" , schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreProcedure.findAll", query = "SELECT s FROM StoreProcedure s"),
    @NamedQuery(name = "StoreProcedure.findById", query = "SELECT s FROM StoreProcedure s WHERE s.id = :id"),
    @NamedQuery(name = "StoreProcedure.findByNombre", query = "SELECT s FROM StoreProcedure s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "StoreProcedure.findByDescripcion", query = "SELECT s FROM StoreProcedure s WHERE s.descripcion = :descripcion")})
public class StoreProcedure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "ID")
    private Long id=null;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 250)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_BASE_DATOS", referencedColumnName = "ID")
    @ManyToOne
    private BaseDatos idBaseDatos;

    public StoreProcedure() {
    }

    public StoreProcedure(Long id) {
        this.id = id;
    }

    public StoreProcedure(Long id, String nombre) {
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

    public BaseDatos getIdBaseDatos() {
        return idBaseDatos;
    }

    public void setIdBaseDatos(BaseDatos idBaseDatos) {
        this.idBaseDatos = idBaseDatos;
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
        if (!(object instanceof StoreProcedure)) {
            return false;
        }
        StoreProcedure other = (StoreProcedure) object;
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
