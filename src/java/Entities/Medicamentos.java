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
@Table(name = "tabla_medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamentos.findAll", query = "SELECT m FROM Medicamentos m"),
    @NamedQuery(name = "Medicamentos.findById", query = "SELECT m FROM Medicamentos m WHERE m.id = :id"),
    @NamedQuery(name = "Medicamentos.findByCedula", query = "SELECT m FROM Medicamentos m WHERE m.cedula = :cedula"),
    @NamedQuery(name = "Medicamentos.findByIdMedicamento", query = "SELECT m FROM Medicamentos m WHERE m.idMedicamento = :idMedicamento"),
    @NamedQuery(name = "Medicamentos.findByFrecuencia", query = "SELECT m FROM Medicamentos m WHERE m.frecuencia = :frecuencia"),
    @NamedQuery(name = "Medicamentos.findByAsignado", query = "SELECT m FROM Medicamentos m WHERE m.asignado = :asignado"),
    @NamedQuery(name = "Medicamentos.findByHora", query = "SELECT m FROM Medicamentos m WHERE m.hora = :hora"),
    @NamedQuery(name = "Medicamentos.findByIdSintoma", query = "SELECT m FROM Medicamentos m WHERE m.idSintoma = :idSintoma"),
    @NamedQuery(name = "Medicamentos.findByActivo", query = "SELECT m FROM Medicamentos m WHERE m.activo = :activo")})
public class Medicamentos implements Serializable {

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
    @Column(name = "ID_MEDICAMENTO")
    private int idMedicamento;
    @Column(name = "FRECUENCIA")
    private Integer frecuencia;
    @Column(name = "ASIGNADO")
    private Short asignado;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "ID_SINTOMA")
    private Integer idSintoma;
    @Column(name = "ACTIVO")
    private Short activo;

    public Medicamentos() {
    }

    public Medicamentos(Integer id) {
        this.id = id;
    }

    public Medicamentos(Integer id, int cedula, int idMedicamento) {
        this.id = id;
        this.cedula = cedula;
        this.idMedicamento = idMedicamento;
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

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Short getAsignado() {
        return asignado;
    }

    public void setAsignado(Short asignado) {
        this.asignado = asignado;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Integer getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(Integer idSintoma) {
        this.idSintoma = idSintoma;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
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
        if (!(object instanceof Medicamentos)) {
            return false;
        }
        Medicamentos other = (Medicamentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Medicamentos[ id=" + id + " ]";
    }
    
}
