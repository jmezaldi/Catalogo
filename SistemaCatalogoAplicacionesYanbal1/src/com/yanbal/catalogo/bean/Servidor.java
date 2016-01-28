/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "SERVIDOR", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servidor.findAll", query = "SELECT s FROM Servidor s"),
    @NamedQuery(name = "Servidor.findById", query = "SELECT s FROM Servidor s WHERE s.id = :id"),
    @NamedQuery(name = "Servidor.findByNombre", query = "SELECT s FROM Servidor s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Servidor.findByProcesador", query = "SELECT s FROM Servidor s WHERE s.procesador = :procesador"),
    @NamedQuery(name = "Servidor.findByIpAdress", query = "SELECT s FROM Servidor s WHERE s.ipAdress = :ipAdress"),
    @NamedQuery(name = "Servidor.findByMemoria", query = "SELECT s FROM Servidor s WHERE s.memoria = :memoria"),
    @NamedQuery(name = "Servidor.findByVirtual", query = "SELECT s FROM Servidor s WHERE s.virtual = :virtual"),
    @NamedQuery(name = "Servidor.findByUbicacionFisica", query = "SELECT s FROM Servidor s WHERE s.ubicacionFisica = :ubicacionFisica"),
    @NamedQuery(name = "Servidor.findByComentarioInterno", query = "SELECT s FROM Servidor s WHERE s.comentarioInterno = :comentarioInterno")})
public class Servidor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 20)
    @Column(name = "PROCESADOR")
    private String procesador;
    @Size(max = 20)
    @Column(name = "IP_ADRESS")
    private String ipAdress;
    @Size(max = 100)
    @Column(name = "MEMORIA")
    private String memoria;
    @Column(name = "VIRTUAL")
    private Character virtual;
    @Size(max = 100)
    @Column(name = "UBICACION_FISICA")
    private String ubicacionFisica;
    @Size(max = 1000)
    @Column(name = "COMENTARIO_INTERNO")
    private String comentarioInterno;
    @JoinTable(name = "SOFTWARE_BASE_INSTANCIA_X_SERVIDOR", joinColumns = {
        @JoinColumn(name = "ID_SERVIDOR", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_SOFTWARE_BASE_INSTANCIA", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<SoftwareBaseInstancia> softwareBaseInstanciaCollection;
    @OneToMany(mappedBy = "servidorFisicoId")
    private Collection<Servidor> servidorCollection;
    @JoinColumn(name = "SERVIDOR_FISICO_ID", referencedColumnName = "ID")
    @ManyToOne
    private Servidor servidorFisicoId;
    @JoinColumn(name = "ID_AMBIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ambiente idAmbiente;

    public Servidor() {
    }

    public Servidor(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public Character getVirtual() {
        return virtual;
    }

    public void setVirtual(Character virtual) {
        this.virtual = virtual;
    }

    public String getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(String ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public String getComentarioInterno() {
        return comentarioInterno;
    }

    public void setComentarioInterno(String comentarioInterno) {
        this.comentarioInterno = comentarioInterno;
    }

    @XmlTransient
    public Collection<SoftwareBaseInstancia> getSoftwareBaseInstanciaCollection() {
        return softwareBaseInstanciaCollection;
    }

    public void setSoftwareBaseInstanciaCollection(Collection<SoftwareBaseInstancia> softwareBaseInstanciaCollection) {
        this.softwareBaseInstanciaCollection = softwareBaseInstanciaCollection;
    }

    @XmlTransient
    public Collection<Servidor> getServidorCollection() {
        return servidorCollection;
    }

    public void setServidorCollection(Collection<Servidor> servidorCollection) {
        this.servidorCollection = servidorCollection;
    }

    public Servidor getServidorFisicoId() {
        return servidorFisicoId;
    }

    public void setServidorFisicoId(Servidor servidorFisicoId) {
        this.servidorFisicoId = servidorFisicoId;
    }

    public Ambiente getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Ambiente idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servidor)) {
            return false;
        }
        Servidor other = (Servidor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
