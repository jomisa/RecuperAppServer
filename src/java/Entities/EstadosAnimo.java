/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmss1
 */
@Entity
@Table(name = "tabla_estados_animo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosAnimo.findAll", query = "SELECT e FROM EstadosAnimo e"),
    @NamedQuery(name = "EstadosAnimo.findById", query = "SELECT e FROM EstadosAnimo e WHERE e.id = :id"),
    @NamedQuery(name = "EstadosAnimo.findByCedula", query = "SELECT e FROM EstadosAnimo e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "EstadosAnimo.findByFecha", query = "SELECT e FROM EstadosAnimo e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "EstadosAnimo.findByValor", query = "SELECT e FROM EstadosAnimo e WHERE e.valor = :valor")})
public class EstadosAnimo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEDULA")
    private int cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;

    public EstadosAnimo() {
    }

    public EstadosAnimo(Integer id) {
        this.id = id;
    }

    public EstadosAnimo(Integer id, int cedula, Date fecha) {
        this.id = id;
        this.cedula = cedula;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
        if (!(object instanceof EstadosAnimo)) {
            return false;
        }
        EstadosAnimo other = (EstadosAnimo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.EstadosAnimo[ id=" + id + " ]";
    }
    
}
