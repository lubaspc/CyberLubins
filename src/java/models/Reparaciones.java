/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lubas
 */
@Entity
@Table(name = "reparaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparaciones.findAll", query = "SELECT r FROM Reparaciones r")
    , @NamedQuery(name = "Reparaciones.findByIdReparaciones", query = "SELECT r FROM Reparaciones r WHERE r.idReparaciones = :idReparaciones")
    , @NamedQuery(name = "Reparaciones.findByDescripcion", query = "SELECT r FROM Reparaciones r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Reparaciones.findByCosto", query = "SELECT r FROM Reparaciones r WHERE r.costo = :costo")
    , @NamedQuery(name = "Reparaciones.findByDuracion", query = "SELECT r FROM Reparaciones r WHERE r.duracion = :duracion")})
public class Reparaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idReparaciones")
    private Integer idReparaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private long costo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "duracion")
    private String duracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreparaciones")
    private Collection<Actulisaciones> actulisacionesCollection;

    public Reparaciones() {
    }

    public Reparaciones(Integer idReparaciones) {
        this.idReparaciones = idReparaciones;
    }

    public Reparaciones(Integer idReparaciones, String descripcion, long costo, String duracion) {
        this.idReparaciones = idReparaciones;
        this.descripcion = descripcion;
        this.costo = costo;
        this.duracion = duracion;
    }

    public Integer getIdReparaciones() {
        return idReparaciones;
    }

    public void setIdReparaciones(Integer idReparaciones) {
        this.idReparaciones = idReparaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @XmlTransient
    public Collection<Actulisaciones> getActulisacionesCollection() {
        return actulisacionesCollection;
    }

    public void setActulisacionesCollection(Collection<Actulisaciones> actulisacionesCollection) {
        this.actulisacionesCollection = actulisacionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReparaciones != null ? idReparaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparaciones)) {
            return false;
        }
        Reparaciones other = (Reparaciones) object;
        if ((this.idReparaciones == null && other.idReparaciones != null) || (this.idReparaciones != null && !this.idReparaciones.equals(other.idReparaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Reparaciones[ idReparaciones=" + idReparaciones + " ]";
    }
    
}
