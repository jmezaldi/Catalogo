package com.yanbal.catalogo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AplicacionXCaracteristicaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_APLICACION")
	private long idAplicacion;

	@Column(name="ID_CARACTERISTICA_APLICACION")
	private long idCaracteristicaAplicacion;

    public AplicacionXCaracteristicaPK() {
    }

    public AplicacionXCaracteristicaPK(long idAplicacion, long idCaracteristicaAplicacion) {
        this.idAplicacion = idAplicacion;
        this.idCaracteristicaAplicacion = idCaracteristicaAplicacion;
    }
    
	public long getIdAplicacion() {
		return this.idAplicacion;
	}
	public void setIdAplicacion(long idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	public long getIdCaracteristicaAplicacion() {
		return this.idCaracteristicaAplicacion;
	}
	public void setIdCaracteristicaAplicacion(long idCaracteristicaAplicacion) {
		this.idCaracteristicaAplicacion = idCaracteristicaAplicacion;
	}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAplicacion; 
        hash += (int) idCaracteristicaAplicacion;        
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicacionXCaracteristicaPK)) {
            return false;
        }
        AplicacionXCaracteristicaPK other = (AplicacionXCaracteristicaPK) object;
        if (this.idAplicacion != other.idAplicacion) {
            return false;
        }
        if (this.idCaracteristicaAplicacion != other.idCaracteristicaAplicacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.AplicacionXCaracteristicaPK[ idAplicacion=" + idAplicacion + ", idCaracteristicaAplicacion=" + idCaracteristicaAplicacion + " ]";
    }
    
}
