/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmss1
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicamentosPaciente.misMedicamentos", 
            query = "SELECT m.ID_MEDICAMENTO ,lm.NOMBRE, lm.DOSIS, m.FRECUENCIA, m.HORA, ls.SINTOMA, m.ASIGNADO " +
                    "FROM tabla_medicamentos m, tabla_lista_medicamentos lm, tabla_lista_sintomas ls" +
                    "WHERE m.ID_MEDICAMENTO = lm.ID_MEDICAMENTO " +
                    "and lm.ID_SINTOMA=ls.ID_SINTOMA" +
                    "and m.CEDULA :cedula")})

public class MedicamentosPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String nombreMedicamento;
    private Integer dosis;
    private Integer frecuencia;
    private Date hora;
    private String sintoma;
    private Short asignado;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public Integer getDosis() {
        return dosis;
    }

    public void setDosis(Integer dosis) {
        this.dosis = dosis;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public Short getAsignado() {
        return asignado;
    }

    public void setAsignado(Short asignado) {
        this.asignado = asignado;
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
        if (!(object instanceof MedicamentosPaciente)) {
            return false;
        }
        MedicamentosPaciente other = (MedicamentosPaciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.MedicamentosPaciente[ id=" + id + " ]";
    }
    
}
