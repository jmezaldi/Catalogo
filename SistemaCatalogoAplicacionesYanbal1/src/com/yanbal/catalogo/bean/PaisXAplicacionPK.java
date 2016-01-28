package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PAIS_X_APLICACION database table.
 * 
 */
@Embeddable
public class PaisXAplicacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_APLICACION")
	private long idAplicacion;

	@Column(name="ID_PAIS")
	private long idPais;

    public PaisXAplicacionPK() {
    }
    
    public PaisXAplicacionPK(long idAplicacion, long idPais) {
        this.idAplicacion = idAplicacion;
        this.idPais = idPais;
    }
    
	public long getIdAplicacion() {
		return this.idAplicacion;
	}
	public void setIdAplicacion(long idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	public long getIdPais() {
		return this.idPais;
	}
	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}
	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAplicacion;
        hash += (int) idPais;
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaisXAplicacionPK)) {
            return false;
        }
        PaisXAplicacionPK other = (PaisXAplicacionPK) object;
        if (this.idAplicacion != other.idAplicacion) {
            return false;
        }
        if (this.idPais != other.idPais) {
            return false;
        }
        return true;
    }
	
	@Override
    public String toString() {
        return "com.yanbal.catalogo.bean.PaisXAplicacionPK[ idAplicacion=" + idAplicacion + ", idPais=" + idPais + " ]";
    }
}