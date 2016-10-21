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
@Table(name = "tabla_lista_sintomas_medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaSintomasMedicamentos.findAll", query = "SELECT l FROM ListaSintomasMedicamentos l"),
    @NamedQuery(name = "ListaSintomasMedicamentos.findByIdSintomaMedicamento", query = "SELECT l FROM ListaSintomasMedicamentos l WHERE l.idSintomaMedicamento = :idSintomaMedicamento"),
    @NamedQuery(name = "ListaSintomasMedicamentos.findBySintoma", query = "SELECT l FROM ListaSintomasMedicamentos l WHERE l.sintoma = :sintoma")})
public class ListaSintomasMedicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SINTOMA_MEDICAMENTO")
    private Integer idSintomaMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SINTOMA")
    private String sintoma;

    public ListaSintomasMedicamentos() {
    }

    public ListaSintomasMedicamentos(Integer idSintomaMedicamento) {
        this.idSintomaMedicamento = idSintomaMedicamento;
    }

    public ListaSintomasMedicamentos(Integer idSintomaMedicamento, String sintoma) {
        this.idSintomaMedicamento = idSintomaMedicamento;
        this.sintoma = sintoma;
    }

    public Integer getIdSintomaMedicamento() {
        return idSintomaMedicamento;
    }

    public void setIdSintomaMedicamento(Integer idSintomaMedicamento) {
        this.idSintomaMedicamento = idSintomaMedicamento;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSintomaMedicamento != null ? idSintomaMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaSintomasMedicamentos)) {
            return false;
        }
        ListaSintomasMedicamentos other = (ListaSintomasMedicamentos) object;
        if ((this.idSintomaMedicamento == null && other.idSintomaMedicamento != null) || (this.idSintomaMedicamento != null && !this.idSintomaMedicamento.equals(other.idSintomaMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ListaSintomasMedicamentos[ idSintomaMedicamento=" + idSintomaMedicamento + " ]";
    }
    
}
