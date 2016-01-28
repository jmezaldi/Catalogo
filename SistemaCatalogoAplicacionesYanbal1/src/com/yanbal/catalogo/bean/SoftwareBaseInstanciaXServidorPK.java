package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SOFTWARE_BASE_INSTANCIA_X_SERVIDOR database table.
 * 
 */
@Embeddable
public class SoftwareBaseInstanciaXServidorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_SERVIDOR")
	private long idServidor;

	@Column(name="ID_SOFTWARE_BASE_INSTANCIA")
	private long idSoftwareBaseInstancia;

    public SoftwareBaseInstanciaXServidorPK() {
    }
    
    public SoftwareBaseInstanciaXServidorPK(long idServidor, long idSoftwareBaseInstancia) {
        this.idServidor = idServidor;
        this.idSoftwareBaseInstancia = idSoftwareBaseInstancia;
    }    
	public long getIdServidor() {
		return this.idServidor;
	}
	public void setIdServidor(long idServidor) {
		this.idServidor = idServidor;
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
        hash += (int) idServidor; 
        hash += (int) idSoftwareBaseInstancia;        
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoftwareBaseInstanciaXServidorPK)) {
            return false;
        }
        SoftwareBaseInstanciaXServidorPK other = (SoftwareBaseInstanciaXServidorPK) object;
        if (this.idServidor != other.idServidor) {
            return false;
        }
        if (this.idSoftwareBaseInstancia != other.idSoftwareBaseInstancia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServidorPK[ idServidor=" + idServidor + ", idSoftwareBaseInstancia=" + idSoftwareBaseInstancia + " ]";
    }
}