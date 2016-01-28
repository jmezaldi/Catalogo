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
 * @author usuario
 */
@Entity
@Table(name = "APLICACION_X_SOLUCION", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AplicacionXSolucion.findAll", query = "SELECT a FROM AplicacionXSolucion a"),
    @NamedQuery(name = "AplicacionXSolucion.findById", query = "SELECT a FROM AplicacionXSolucion a WHERE a.id = :id"),
    @NamedQuery(name = "AplicacionXSolucion.findByComentario", query = "SELECT a FROM AplicacionXSolucion a WHERE a.comentario = :comentario")})
public class AplicacionXSolucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 254)
    @Column(name = "COMENTARIO")
    private String comentario;
    @JoinColumn(name = "ID_SOLUCION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Solucion idSolucion;
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Aplicacion idAplicacion;

    public AplicacionXSolucion() {
    }

    public AplicacionXSolucion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Solucion getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(Solucion idSolucion) {
        this.idSolucion = idSolucion;
    }

    public Aplicacion getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Aplicacion idAplicacion) {
        this.idAplicacion = idAplicacion;
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
        if (!(object instanceof AplicacionXSolucion)) {
            return false;
        }
        AplicacionXSolucion other = (AplicacionXSolucion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " id = " + id + " Comentario = "+comentario;
    }
    
}
