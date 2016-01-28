package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
@Table(name="APLICACION_X_ARCHIVO_DESPLEGABLE", schema="CATALOGO")
public class AplicacionXArchivoDesplegablePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ID_APLICACION")
	private long idAplicacion;

	@Column(name="ID_ARCHIVO_DESPLEGABLE")
	private long idArchivoDesplegable;

    public AplicacionXArchivoDesplegablePK() {
    }
    public AplicacionXArchivoDesplegablePK(long idAplicacion, long idArchivoDesplegable) {
        this.idAplicacion = idAplicacion;
        this.idArchivoDesplegable = idArchivoDesplegable;
    }
	public long getIdAplicacion() {
		return this.idAplicacion;
	}

	public void setIdAplicacion(long idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public long getIdArchivoDesplegable() {
		return this.idArchivoDesplegable;
	}

	public void setIdArchivoDesplegable(long idArchivoDesplegable) {
		this.idArchivoDesplegable = idArchivoDesplegable;
	}

    @Override
    public int hashCode() {
        int hash = 0;        
        hash += (int) idAplicacion;   
        hash += (int) idArchivoDesplegable;
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicacionXArchivoDesplegablePK)) {
            return false;
        }
        AplicacionXArchivoDesplegablePK other = (AplicacionXArchivoDesplegablePK) object;
        if (this.idAplicacion != other.idAplicacion) {
            return false;
        }
        if (this.idArchivoDesplegable != other.idArchivoDesplegable) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.AplicacionXArchivoDesplegablePK[ idAplicacion=" + idAplicacion + ", idFramework=" + idArchivoDesplegable + " ]";
    }
}