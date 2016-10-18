/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
@Table(name = "tabla_caminatas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caminatas.findAll", query = "SELECT c FROM Caminatas c"),
    @NamedQuery(name = "Caminatas.findById", query = "SELECT c FROM Caminatas c WHERE c.id = :id"),
    @NamedQuery(name = "Caminatas.findByCedula", query = "SELECT c FROM Caminatas c WHERE c.cedula = :cedula"),
    @NamedQuery(name = "Caminatas.findByFecha", query = "SELECT c FROM Caminatas c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Caminatas.findByTiempo", query = "SELECT c FROM Caminatas c WHERE c.tiempo = :tiempo"),
    @NamedQuery(name = "Caminatas.findByDistancia", query = "SELECT c FROM Caminatas c WHERE c.distancia = :distancia"),
    @NamedQuery(name = "Caminatas.findByPasos", query = "SELECT c FROM Caminatas c WHERE c.pasos = :pasos"),
    @NamedQuery(name = "Caminatas.findByIdSintoma", query = "SELECT c FROM Caminatas c WHERE c.idSintoma = :idSintoma")})
public class Caminatas implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIEMPO")
    private int tiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISTANCIA")
    private int distancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PASOS")
    private int pasos;
    @Column(name = "ID_SINTOMA")
    private Integer idSintoma;

    public Caminatas() {
    }

    public Caminatas(Integer id) {
        this.id = id;
    }

    public Caminatas(Integer id, int cedula, Date fecha, int tiempo, int distancia, int pasos) {
        this.id = id;
        this.cedula = cedula;
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.distancia = distancia;
        this.pasos = pasos;
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

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public Integer getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(Integer idSintoma) {
        this.idSintoma = idSintoma;
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
        if (!(object instanceof Caminatas)) {
            return false;
        }
        Caminatas other = (Caminatas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Caminatas[ id=" + id + " ]";
    }
    
}
