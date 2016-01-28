/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alicia Canta
 */
@Entity
@Table(name = "SUB_PROCESO_NEGOCIO", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubProcesoNegocio.findAll", query = "SELECT s FROM SubProcesoNegocio s"),
    @NamedQuery(name = "SubProcesoNegocio.findById", query = "SELECT s FROM SubProcesoNegocio s WHERE s.id = :id"),
    @NamedQuery(name = "SubProcesoNegocio.findByNombre", query = "SELECT s FROM SubProcesoNegocio s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SubProcesoNegocio.findByDescripcion", query = "SELECT s FROM SubProcesoNegocio s WHERE s.descripcion = :descripcion")})
public class SubProcesoNegocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proceso idProceso;

    public SubProcesoNegocio() {
    }

    public SubProcesoNegocio(Long id) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Proceso idProceso) {
        this.idProceso = idProceso;
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
        if (!(object instanceof SubProcesoNegocio)) {
            return false;
        }
        SubProcesoNegocio other = (SubProcesoNegocio) object;
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
