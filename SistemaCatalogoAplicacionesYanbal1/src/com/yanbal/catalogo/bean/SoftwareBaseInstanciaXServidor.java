package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SOFTWARE_BASE_INSTANCIA_X_SERVIDOR database table.
 * 
 */
@Entity
@Table(name="SOFTWARE_BASE_INSTANCIA_X_SERVIDOR" , schema="CATALOGO")
public class SoftwareBaseInstanciaXServidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SoftwareBaseInstanciaXServidorPK softwareBaseInstanciaXServidorPK;

    @JoinColumn(name = "ID_SERVIDOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servidor servidor;
   
    @JoinColumn(name = "ID_SOFTWARE_BASE_INSTANCIA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SoftwareBaseInstancia softwareBaseInstancia;
    
    public SoftwareBaseInstanciaXServidor() {
    }
    
    public SoftwareBaseInstanciaXServidor(SoftwareBaseInstanciaXServidorPK softwareBaseInstanciaXServidorPK) {
        this.softwareBaseInstanciaXServidorPK = softwareBaseInstanciaXServidorPK;
    }

    public SoftwareBaseInstanciaXServidor(long idServidor, long idSoftwareBaseInstancia) {
        this.softwareBaseInstanciaXServidorPK = new SoftwareBaseInstanciaXServidorPK(idServidor, idSoftwareBaseInstancia);
    }

	public SoftwareBaseInstanciaXServidorPK getSoftwareBaseInstanciaXServidorPK() {
		return softwareBaseInstanciaXServidorPK;
	}

	public void setSoftwareBaseInstanciaXServidorPK(
			SoftwareBaseInstanciaXServidorPK softwareBaseInstanciaXServidorPK) {
		this.softwareBaseInstanciaXServidorPK = softwareBaseInstanciaXServidorPK;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		softwareBaseInstanciaXServidorPK.setIdServidor(servidor.getId());
		this.servidor = servidor;
	}
		
	public SoftwareBaseInstancia getSoftwareBaseInstancia() {
		return softwareBaseInstancia;
	}

	public void setSoftwareBaseInstancia(SoftwareBaseInstancia softwareBaseInstancia) {
		softwareBaseInstanciaXServidorPK.setIdSoftwareBaseInstancia(softwareBaseInstancia.getId());
		this.softwareBaseInstancia = softwareBaseInstancia;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (softwareBaseInstanciaXServidorPK != null ? softwareBaseInstanciaXServidorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoftwareBaseInstanciaXServidor)) {
            return false;
        }
        SoftwareBaseInstanciaXServidor other = (SoftwareBaseInstanciaXServidor) object;
        if ((this.softwareBaseInstanciaXServidorPK == null && other.softwareBaseInstanciaXServidorPK != null) || (this.softwareBaseInstanciaXServidorPK != null && !this.softwareBaseInstanciaXServidorPK.equals(other.softwareBaseInstanciaXServidorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServidor[ SoftwareBaseInstanciaXServidorPK=" + softwareBaseInstanciaXServidorPK + " ]";
    }

	
}