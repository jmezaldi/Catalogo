/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "APLICACION_X_BASE_DATOS", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AplicacionXBaseDatos.findAll", query = "SELECT a FROM AplicacionXBaseDatos a"),
    @NamedQuery(name = "AplicacionXBaseDatos.findByIdAplicacion", query = "SELECT a FROM AplicacionXBaseDatos a WHERE a.aplicacionXBaseDatosPK.idAplicacion = :idAplicacion"),
    @NamedQuery(name = "AplicacionXBaseDatos.findByIdBaseDatos", query = "SELECT a FROM AplicacionXBaseDatos a WHERE a.aplicacionXBaseDatosPK.idBaseDatos = :idBaseDatos")})
public class AplicacionXBaseDatos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AplicacionXBaseDatosPK aplicacionXBaseDatosPK;
    
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion;
    
    @JoinColumn(name = "ID_BASE_DATOS", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BaseDatos basedatos;   

    public AplicacionXBaseDatos() {
    }

    public AplicacionXBaseDatos(AplicacionXBaseDatosPK aplicacionXBaseDatosPK) {
        this.aplicacionXBaseDatosPK = aplicacionXBaseDatosPK;
    }

    public AplicacionXBaseDatos(long idAplicacion, long idBaseDatos) {
        this.aplicacionXBaseDatosPK = new AplicacionXBaseDatosPK(idAplicacion, idBaseDatos);
    }

    public AplicacionXBaseDatosPK getAplicacionXBaseDatosPK() {
        return aplicacionXBaseDatosPK;
    }

    public void setAplicacionXBaseDatosPK(AplicacionXBaseDatosPK aplicacionXBaseDatosPK) {
        this.aplicacionXBaseDatosPK = aplicacionXBaseDatosPK;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
    	aplicacionXBaseDatosPK.setIdAplicacion(aplicacion.getId());		    	
        this.aplicacion = aplicacion;
    }

    
    public BaseDatos getBasedatos() {
		return basedatos;
	}

	public void setBasedatos(BaseDatos basedatos) {
    	aplicacionXBaseDatosPK.setIdBaseDatos(basedatos.getId());		
		this.basedatos = basedatos;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (aplicacionXBaseDatosPK != null ? aplicacionXBaseDatosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicacionXBaseDatos)) {
            return false;
        }
        AplicacionXBaseDatos other = (AplicacionXBaseDatos) object;
        if ((this.aplicacionXBaseDatosPK == null && other.aplicacionXBaseDatosPK != null) || (this.aplicacionXBaseDatosPK != null && !this.aplicacionXBaseDatosPK.equals(other.aplicacionXBaseDatosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.AplicacionXBaseDatos[ aplicacionXBaseDatosPK=" + aplicacionXBaseDatosPK + " ]";
    }
    
}
