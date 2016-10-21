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
import javax.persistence.NamedNativeQuery;

/**
 *
 * @author jmss1
 */
@Entity
@NamedNativeQuery(
 name="misMedicamentos", 
 query = "SELECT m.ID_MEDICAMENTO as idMed, lm.NOMBRE as nombreMed, lm.DOSIS as dosis, m.FRECUENCIA as frecuencia, m.HORA as hora, ls.SINTOMA as sintoma, m.ASIGNADO as asignado " +
                "FROM tabla_medicamentos m, tabla_lista_medicamentos lm, tabla_lista_sintomas ls " +
                "WHERE m.ID_MEDICAMENTO = lm.ID_MEDICAMENTO " +
                "and lm.ID_SINTOMA=ls.ID_SINTOMA " +
                "and m.CEDULA = ?1", 
 resultClass = MisMedicamentos.class)
public class MisMedicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer idMed;
    private String nombreMed;
    private String dosis;
    private int frecuencia;
    private String hora;
    private String sintoma;
    private int asignado;

    public Integer getIdMed() {
        return idMed;
    }

    public void setIdMed(Integer idMed) {
        this.idMed = idMed;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public int getAsignado() {
        return asignado;
    }

    public void setAsignado(int asignado) {
        this.asignado = asignado;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMed != null ? idMed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MisMedicamentos)) {
            return false;
        }
        MisMedicamentos other = (MisMedicamentos) object;
        if ((this.idMed == null && other.idMed != null) || (this.idMed != null && !this.idMed.equals(other.idMed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.MisMedicamentos[ id=" + idMed + " ]";
    }
    
}
