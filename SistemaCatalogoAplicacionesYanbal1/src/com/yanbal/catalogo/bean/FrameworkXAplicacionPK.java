package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FRAMEWORK_X_APLICACION database table.
 * 
 */
@Embeddable
public class FrameworkXAplicacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_FRAMEWORK")
	private long idFramework;

	@Column(name="ID_APLICACION")
	private long idAplicacion;

    public FrameworkXAplicacionPK() {
    }
    public FrameworkXAplicacionPK(long idFramework, long idAplicacion) {
        this.idFramework = idFramework;
        this.idAplicacion = idAplicacion;
    }    
	public long getIdFramework() {
		return this.idFramework;
	}
	public void setIdFramework(long idFramework) {
		this.idFramework = idFramework;
	}
	public long getIdAplicacion() {
		return this.idAplicacion;
	}
	public void setIdAplicacion(long idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFramework;
        hash += (int) idAplicacion;       
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrameworkXAplicacionPK)) {
            return false;
        }
        FrameworkXAplicacionPK other = (FrameworkXAplicacionPK) object;
        if (this.idAplicacion != other.idAplicacion) {
            return false;
        }
        if (this.idFramework != other.idFramework) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.FrameworkXAplicacionPK[ idAplicacion=" + idAplicacion + ", idFramework=" + idFramework + " ]";
    }
}