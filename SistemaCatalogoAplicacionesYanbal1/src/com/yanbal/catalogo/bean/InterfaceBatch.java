/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "INTERFACE_BATCH", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterfaceBatch.findAll", query = "SELECT i FROM InterfaceBatch i"),
    @NamedQuery(name = "InterfaceBatch.findByIdAplicacionFuente", query = "SELECT i FROM InterfaceBatch i WHERE i.interfaceBatchPK.idAplicacionFuente = :idAplicacionFuente"),
    @NamedQuery(name = "InterfaceBatch.findByIdAplicacionDestino", query = "SELECT i FROM InterfaceBatch i WHERE i.interfaceBatchPK.idAplicacionDestino = :idAplicacionDestino"),
    @NamedQuery(name = "InterfaceBatch.findByNombreComponente", query = "SELECT i FROM InterfaceBatch i WHERE i.nombreComponente = :nombreComponente"),
    @NamedQuery(name = "InterfaceBatch.findByDescripcion", query = "SELECT i FROM InterfaceBatch i WHERE i.descripcion = :descripcion")})
public class InterfaceBatch implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InterfaceBatchPK interfaceBatchPK;
    @Size(max = 100)
    @Column(name = "NOMBRE_COMPONENTE")
    private String nombreComponente;
    @Size(max = 1000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @JoinColumn(name = "ID_APLICACION_FUENTE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion;
    
    @JoinColumn(name = "ID_APLICACION_DESTINO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion1;

    public InterfaceBatch() {
    }

    public InterfaceBatch(InterfaceBatchPK interfaceBatchPK) {
        this.interfaceBatchPK = interfaceBatchPK;
    }

    public InterfaceBatch(long idAplicacionFuente, long idAplicacionDestino) {
        this.interfaceBatchPK = new InterfaceBatchPK(idAplicacionFuente, idAplicacionDestino);
    }

    public InterfaceBatchPK getInterfaceBatchPK() {
        return interfaceBatchPK;
    }

    public void setInterfaceBatchPK(InterfaceBatchPK interfaceBatchPK) {
        this.interfaceBatchPK = interfaceBatchPK;
    }

    public String getNombreComponente() {
        return nombreComponente;
    }

    public void setNombreComponente(String nombreComponente) {
        this.nombreComponente = nombreComponente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
    	interfaceBatchPK.setIdAplicacionFuente(aplicacion.getId());
        this.aplicacion = aplicacion;
    }

    public Aplicacion getAplicacion1() {
        return aplicacion1;
    }

    public void setAplicacion1(Aplicacion aplicacion1) {
    	interfaceBatchPK.setIdAplicacionDestino(aplicacion1.getId());
        this.aplicacion1 = aplicacion1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interfaceBatchPK != null ? interfaceBatchPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterfaceBatch)) {
            return false;
        }
        InterfaceBatch other = (InterfaceBatch) object;
        if ((this.interfaceBatchPK == null && other.interfaceBatchPK != null) || (this.interfaceBatchPK != null && !this.interfaceBatchPK.equals(other.interfaceBatchPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreComponente;
    }
    
}
