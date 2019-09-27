/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lubas
 */
@Entity
@Table(name = "actulisaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actulisaciones.findAll", query = "SELECT a FROM Actulisaciones a")
    , @NamedQuery(name = "Actulisaciones.findByIdactulisaciones", query = "SELECT a FROM Actulisaciones a WHERE a.idactulisaciones = :idactulisaciones")
    , @NamedQuery(name = "Actulisaciones.findByDescripcion", query = "SELECT a FROM Actulisaciones a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Actulisaciones.findByPresupuesto", query = "SELECT a FROM Actulisaciones a WHERE a.presupuesto = :presupuesto")})
public class Actulisaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactulisaciones")
    private Integer idactulisaciones;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presupuesto")
    private long presupuesto;
    @JoinColumn(name = "idTrabajos", referencedColumnName = "idTrabajos")
    @ManyToOne(optional = false)
    private Trabajos idTrabajos;
    @JoinColumn(name = "idreparaciones", referencedColumnName = "idReparaciones")
    @ManyToOne(optional = false)
    private Reparaciones idreparaciones;

    public Actulisaciones() {
    }

    public Actulisaciones(Integer idactulisaciones) {
        this.idactulisaciones = idactulisaciones;
    }

    public Actulisaciones(Integer idactulisaciones, long presupuesto) {
        this.idactulisaciones = idactulisaciones;
        this.presupuesto = presupuesto;
    }

    public Integer getIdactulisaciones() {
        return idactulisaciones;
    }

    public void setIdactulisaciones(Integer idactulisaciones) {
        this.idactulisaciones = idactulisaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(long presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Trabajos getIdTrabajos() {
        return idTrabajos;
    }

    public void setIdTrabajos(Trabajos idTrabajos) {
        this.idTrabajos = idTrabajos;
    }

    public Reparaciones getIdreparaciones() {
        return idreparaciones;
    }

    public void setIdreparaciones(Reparaciones idreparaciones) {
        this.idreparaciones = idreparaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactulisaciones != null ? idactulisaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actulisaciones)) {
            return false;
        }
        Actulisaciones other = (Actulisaciones) object;
        if ((this.idactulisaciones == null && other.idactulisaciones != null) || (this.idactulisaciones != null && !this.idactulisaciones.equals(other.idactulisaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Actulisaciones[ idactulisaciones=" + idactulisaciones + " ]";
    }
    
}
