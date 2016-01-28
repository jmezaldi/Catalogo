package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SOFTWARE_BASE_INSTANCIA_X_APLICACION database table.
 * 
 */
@Embeddable
public class SoftwareBaseInstanciaXAplicacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_APLICACION")
	private long idAplicacion;

	@Column(name="ID_SOFTWARE_BASE_INSTANCIA")
	private long idSoftwareBaseInstancia;

    public SoftwareBaseInstanciaXAplicacionPK() {
    }
    public SoftwareBaseInstanciaXAplicacionPK(long idAplicacion, long idSoftwareBaseInstancia) {
        this.idAplicacion = idAplicacion;
        this.idSoftwareBaseInstancia = idSoftwareBaseInstancia;
    }
	public long getIdAplicacion() {
		return this.idAplicacion;
	}
	public void setIdAplicacion(long idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	public long getIdSoftwareBaseInstancia() {
		return this.idSoftwareBaseInstancia;
	}
	public void setIdSoftwareBaseInstancia(long idSoftwareBaseInstancia) {
		this.idSoftwareBaseInstancia = idSoftwareBaseInstancia;
	}
	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAplicacion; 
        hash += (int) idSoftwareBaseInstancia;        
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoftwareBaseInstanciaXAplicacionPK)) {
            return false;
        }
        SoftwareBaseInstanciaXAplicacionPK other = (SoftwareBaseInstanciaXAplicacionPK) object;
        if (this.idAplicacion != other.idAplicacion) {
            return false;
        }
        if (this.idSoftwareBaseInstancia != other.idSoftwareBaseInstancia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.SoftwareBaseInstanciaXAplicacionPK[ idAplicacion=" + idAplicacion + ", idSoftwareBaseInstancia=" + idSoftwareBaseInstancia + " ]";
    }
}