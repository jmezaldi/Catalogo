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

import javax.persistence.Table;



/**
 *
 * @author usuario
 */
@Entity
@Table(name="APLICACION_X_CARACTERISTICA" , schema="CATALOGO")
public class AplicacionXCaracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AplicacionXCaracteristicaPK aplicacionXCaracteristicaPK;
	
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion;

    @JoinColumn(name = "ID_CARACTERISTICA_APLICACION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CaractetisticaAplicacion caracteristicaAplicacion;
    
    public AplicacionXCaracteristica() {
    }

    public AplicacionXCaracteristica(AplicacionXCaracteristicaPK aplicacionXCaracteristicaPK) {
        this.aplicacionXCaracteristicaPK = aplicacionXCaracteristicaPK;
    }

    public AplicacionXCaracteristica(long idAplicacion, long idCaracteristicaAplicacion) {
        this.aplicacionXCaracteristicaPK = new AplicacionXCaracteristicaPK(idAplicacion, idCaracteristicaAplicacion);
    }
    
	public AplicacionXCaracteristicaPK getAplicacionXCaracteristicaPK() {
		return this.aplicacionXCaracteristicaPK;
	}

	public void setAplicacionXCaracteristicaPK(AplicacionXCaracteristicaPK aplicacionXCaracteristicaPK) {
		this.aplicacionXCaracteristicaPK = aplicacionXCaracteristicaPK;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		aplicacionXCaracteristicaPK.setIdAplicacion(aplicacion.getId());		
		this.aplicacion = aplicacion;
	}

	public CaractetisticaAplicacion getCaracteristicaAplicacion() {
		return caracteristicaAplicacion;
	}

	public void setCaracteristicaAplicacion(
			CaractetisticaAplicacion caracteristicaAplicacion) {
		aplicacionXCaracteristicaPK.setIdCaracteristicaAplicacion(caracteristicaAplicacion.getId());		
		this.caracteristicaAplicacion = caracteristicaAplicacion;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (aplicacionXCaracteristicaPK != null ? aplicacionXCaracteristicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicacionXCaracteristica)) {
            return false;
        }
        AplicacionXCaracteristica other = (AplicacionXCaracteristica) object;
        if ((this.aplicacionXCaracteristicaPK == null && other.aplicacionXCaracteristicaPK != null) || (this.aplicacionXCaracteristicaPK != null && !this.aplicacionXCaracteristicaPK.equals(other.aplicacionXCaracteristicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.AplicacionXCaracteristica[ aplicacionXCaracteristicaPK=" + aplicacionXCaracteristicaPK + " ]";
    }
	
}
