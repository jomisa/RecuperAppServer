/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmss1
 */
@Entity
@Table(name = "tabla_lista_medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaMedicamentos.findAll", query = "SELECT l FROM ListaMedicamentos l"),
    @NamedQuery(name = "ListaMedicamentos.findByIdMedicamento", query = "SELECT l FROM ListaMedicamentos l WHERE l.idMedicamento = :idMedicamento"),
    @NamedQuery(name = "ListaMedicamentos.findByNombre", query = "SELECT l FROM ListaMedicamentos l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "ListaMedicamentos.findByDosis", query = "SELECT l FROM ListaMedicamentos l WHERE l.dosis = :dosis"),
    @NamedQuery(name = "ListaMedicamentos.findByIdSintoma", query = "SELECT l FROM ListaMedicamentos l WHERE l.idSintoma = :idSintoma")})
public class ListaMedicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MEDICAMENTO")
    private Integer idMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "DOSIS")
    private String dosis;
    @Column(name = "ID_SINTOMA")
    private Integer idSintoma;

    public ListaMedicamentos() {
    }

    public ListaMedicamentos(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public ListaMedicamentos(Integer idMedicamento, String nombre) {
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
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
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaMedicamentos)) {
            return false;
        }
        ListaMedicamentos other = (ListaMedicamentos) object;
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ListaMedicamentos[ idMedicamento=" + idMedicamento + " ]";
    }
    
}
