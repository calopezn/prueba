/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.entidadess;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CALopezN
 */
@Entity
@Table(name = "sailo_perfiles")
@NamedQueries({
    @NamedQuery(name = "SailoPerfiles.findAll", query = "SELECT s FROM SailoPerfiles s")})
public class SailoPerfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "perfil_id")
    private Integer perfilId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "perfil_nombre")
    private String perfilNombre;
    @Size(max = 150)
    @Column(name = "perfil_descripcion")
    private String perfilDescripcion;

    public SailoPerfiles() {
    }

    public SailoPerfiles(Integer perfilId) {
        this.perfilId = perfilId;
    }

    public SailoPerfiles(Integer perfilId, String perfilNombre) {
        this.perfilId = perfilId;
        this.perfilNombre = perfilNombre;
    }

    public Integer getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Integer perfilId) {
        this.perfilId = perfilId;
    }

    public String getPerfilNombre() {
        return perfilNombre;
    }

    public void setPerfilNombre(String perfilNombre) {
        this.perfilNombre = perfilNombre;
    }

    public String getPerfilDescripcion() {
        return perfilDescripcion;
    }

    public void setPerfilDescripcion(String perfilDescripcion) {
        this.perfilDescripcion = perfilDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilId != null ? perfilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SailoPerfiles)) {
            return false;
        }
        SailoPerfiles other = (SailoPerfiles) object;
        if ((this.perfilId == null && other.perfilId != null) || (this.perfilId != null && !this.perfilId.equals(other.perfilId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.entidadess.SailoPerfiles[ perfilId=" + perfilId + " ]";
    }
    
}
