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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lubas
 */
@Entity
@Table(name = "tipo_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEquipo.findAll", query = "SELECT t FROM TipoEquipo t")
    , @NamedQuery(name = "TipoEquipo.findByIdtipoEquipo", query = "SELECT t FROM TipoEquipo t WHERE t.idtipoEquipo = :idtipoEquipo")
    , @NamedQuery(name = "TipoEquipo.findByTipo", query = "SELECT t FROM TipoEquipo t WHERE t.tipo = :tipo")})
public class TipoEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_equipo")
    private Integer idtipoEquipo;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoEquipo")
    private Collection<Producto> productoCollection;

    public TipoEquipo() {
    }

    public TipoEquipo(Integer idtipoEquipo) {
        this.idtipoEquipo = idtipoEquipo;
    }

    public Integer getIdtipoEquipo() {
        return idtipoEquipo;
    }

    public void setIdtipoEquipo(Integer idtipoEquipo) {
        this.idtipoEquipo = idtipoEquipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoEquipo != null ? idtipoEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEquipo)) {
            return false;
        }
        TipoEquipo other = (TipoEquipo) object;
        if ((this.idtipoEquipo == null && other.idtipoEquipo != null) || (this.idtipoEquipo != null && !this.idtipoEquipo.equals(other.idtipoEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
}
