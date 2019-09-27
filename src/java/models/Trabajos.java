/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lubas
 */
@Entity
@Table(name = "trabajos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajos.findAll", query = "SELECT t FROM Trabajos t")
    , @NamedQuery(name = "Trabajos.findByIdTrabajos", query = "SELECT t FROM Trabajos t WHERE t.idTrabajos = :idTrabajos")
    , @NamedQuery(name = "Trabajos.findByFechaRecepcion", query = "SELECT t FROM Trabajos t WHERE t.fechaRecepcion = :fechaRecepcion")
    , @NamedQuery(name = "Trabajos.findByFechaEstimada", query = "SELECT t FROM Trabajos t WHERE t.fechaEstimada = :fechaEstimada")
    , @NamedQuery(name = "Trabajos.findByEstatus", query = "SELECT t FROM Trabajos t WHERE t.estatus = :estatus")
    , @NamedQuery(name = "Trabajos.findByFechaEntrega", query = "SELECT t FROM Trabajos t WHERE t.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Trabajos.findByTotal", query = "SELECT t FROM Trabajos t WHERE t.total = :total")})
public class Trabajos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrabajos")
    private Integer idTrabajos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_estimada")
    @Temporal(TemporalType.DATE)
    private Date fechaEstimada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private int estatus;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column(name = "Total")
    private Long total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajos")
    private Collection<Actulisaciones> actulisacionesCollection;
    @JoinColumn(name = "idClientes", referencedColumnName = "idClientes")
    @ManyToOne(optional = false)
    private Clientes idClientes;
    @JoinColumn(name = "idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false)
    private Usuarios idusuarios;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public Trabajos() {
    }

    public Trabajos(Integer idTrabajos) {
        this.idTrabajos = idTrabajos;
    }

    public Trabajos(Integer idTrabajos, Date fechaRecepcion, Date fechaEstimada, int estatus) {
        this.idTrabajos = idTrabajos;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEstimada = fechaEstimada;
        this.estatus = estatus;
    }

    public Integer getIdTrabajos() {
        return idTrabajos;
    }

    public void setIdTrabajos(Integer idTrabajos) {
        this.idTrabajos = idTrabajos;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Date getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(Date fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @XmlTransient
    public Collection<Actulisaciones> getActulisacionesCollection() {
        return actulisacionesCollection;
    }

    public void setActulisacionesCollection(Collection<Actulisaciones> actulisacionesCollection) {
        this.actulisacionesCollection = actulisacionesCollection;
    }

    public Clientes getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Clientes idClientes) {
        this.idClientes = idClientes;
    }

    public Usuarios getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(Usuarios idusuarios) {
        this.idusuarios = idusuarios;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajos != null ? idTrabajos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajos)) {
            return false;
        }
        Trabajos other = (Trabajos) object;
        if ((this.idTrabajos == null && other.idTrabajos != null) || (this.idTrabajos != null && !this.idTrabajos.equals(other.idTrabajos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Trabajos[ idTrabajos=" + idTrabajos + " ]";
    }
    
}
