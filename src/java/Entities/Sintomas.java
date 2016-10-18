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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmss1
 */
@Entity
@Table(name = "tabla_sintomas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sintomas.findAll", query = "SELECT s FROM Sintomas s"),
    @NamedQuery(name = "Sintomas.findById", query = "SELECT s FROM Sintomas s WHERE s.id = :id"),
    @NamedQuery(name = "Sintomas.findByCedula", query = "SELECT s FROM Sintomas s WHERE s.cedula = :cedula"),
    @NamedQuery(name = "Sintomas.findByIdSintoma", query = "SELECT s FROM Sintomas s WHERE s.idSintoma = :idSintoma"),
    @NamedQuery(name = "Sintomas.findByFecha", query = "SELECT s FROM Sintomas s WHERE s.fecha = :fecha")})
public class Sintomas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CEDULA")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ID_SINTOMA")
    private String idSintoma;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Sintomas() {
    }

    public Sintomas(Integer id) {
        this.id = id;
    }

    public Sintomas(Integer id, String cedula, String idSintoma) {
        this.id = id;
        this.cedula = cedula;
        this.idSintoma = idSintoma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(String idSintoma) {
        this.idSintoma = idSintoma;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof Sintomas)) {
            return false;
        }
        Sintomas other = (Sintomas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Sintomas[ id=" + id + " ]";
    }
    
}
