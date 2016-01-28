package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PAIS_X_APLICACION database table.
 * 
 */
@Entity
@Table(name="PAIS_X_APLICACION")
public class PaisXAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PaisXAplicacionPK paisXAplicacionPK;

    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion;
    
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pais pais;
    
    public PaisXAplicacion() {
    }
    
    public PaisXAplicacion(PaisXAplicacionPK paisXAplicacionPK) {
        this.paisXAplicacionPK = paisXAplicacionPK;
    }

    public PaisXAplicacion(long idPais, long idAplicacion) {
        this.paisXAplicacionPK = new PaisXAplicacionPK(idAplicacion, idPais);
    }
    
	public PaisXAplicacionPK getPaisXAplicacionPK() {
		return paisXAplicacionPK;
	}

	public void setPaisXAplicacionPK(PaisXAplicacionPK paisXAplicacionPK) {
		this.paisXAplicacionPK = paisXAplicacionPK;
	}
	
	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		paisXAplicacionPK.setIdAplicacion(aplicacion.getId());
		this.aplicacion = aplicacion;
	}
	
	
	public Pais getPais() {		
		return pais;
	}

	public void setPais(Pais pais) {
		paisXAplicacionPK.setIdPais(pais.getId());
		this.pais = pais;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (paisXAplicacionPK != null ? paisXAplicacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaisXAplicacion)) {
            return false;
        }
        PaisXAplicacion other = (PaisXAplicacion) object;
        if ((this.paisXAplicacionPK == null && other.paisXAplicacionPK != null) || (this.paisXAplicacionPK != null && !this.paisXAplicacionPK.equals(other.paisXAplicacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.PaisXAplicacion[ paisXAplicacionPK=" + paisXAplicacionPK + " ]";
    }
    

}