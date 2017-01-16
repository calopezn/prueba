/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.entidadess;

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

/**
 *
 * @author CALopezN
 */
@Entity
@Table(name = "sailo_usuarios")
@NamedQueries({
    @NamedQuery(name = "SailoUsuarios.findAll", query = "SELECT s FROM SailoUsuarios s")})
public class SailoUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usua_id")
    private Integer usuaId;
    @Size(max = 50)
    @Column(name = "usua_usuario")
    private String usuaUsuario;
    @Size(max = 70)
    @Column(name = "usua_password")
    private String usuaPassword;
    @Size(max = 100)
    @Column(name = "usua_nombre")
    private String usuaNombre;
    @Size(max = 100)
    @Column(name = "usua_email")
    private String usuaEmail;
    @Column(name = "usua_activo_desde")
    @Temporal(TemporalType.DATE)
    private Date usuaActivoDesde;
    @Column(name = "usua_activo_hasta")
    @Temporal(TemporalType.DATE)
    private Date usuaActivoHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usua_fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuaFechaCreacion;
    @Size(max = 50)
    @Column(name = "usua_usuario_creacion")
    private String usuaUsuarioCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usua_fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuaFechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usua_usuario_modificacion")
    private String usuaUsuarioModificacion;

    public SailoUsuarios() {
    }

    public SailoUsuarios(Integer usuaId) {
        this.usuaId = usuaId;
    }

    public SailoUsuarios(Integer usuaId, Date usuaFechaCreacion, Date usuaFechaModificacion, String usuaUsuarioModificacion) {
        this.usuaId = usuaId;
        this.usuaFechaCreacion = usuaFechaCreacion;
        this.usuaFechaModificacion = usuaFechaModificacion;
        this.usuaUsuarioModificacion = usuaUsuarioModificacion;
    }

    public Integer getUsuaId() {
        return usuaId;
    }

    public void setUsuaId(Integer usuaId) {
        this.usuaId = usuaId;
    }

    public String getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(String usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    public String getUsuaPassword() {
        return usuaPassword;
    }

    public void setUsuaPassword(String usuaPassword) {
        this.usuaPassword = usuaPassword;
    }

    public String getUsuaNombre() {
        return usuaNombre;
    }

    public void setUsuaNombre(String usuaNombre) {
        this.usuaNombre = usuaNombre;
    }

    public String getUsuaEmail() {
        return usuaEmail;
    }

    public void setUsuaEmail(String usuaEmail) {
        this.usuaEmail = usuaEmail;
    }

    public Date getUsuaActivoDesde() {
        return usuaActivoDesde;
    }

    public void setUsuaActivoDesde(Date usuaActivoDesde) {
        this.usuaActivoDesde = usuaActivoDesde;
    }

    public Date getUsuaActivoHasta() {
        return usuaActivoHasta;
    }

    public void setUsuaActivoHasta(Date usuaActivoHasta) {
        this.usuaActivoHasta = usuaActivoHasta;
    }

    public Date getUsuaFechaCreacion() {
        return usuaFechaCreacion;
    }

    public void setUsuaFechaCreacion(Date usuaFechaCreacion) {
        this.usuaFechaCreacion = usuaFechaCreacion;
    }

    public String getUsuaUsuarioCreacion() {
        return usuaUsuarioCreacion;
    }

    public void setUsuaUsuarioCreacion(String usuaUsuarioCreacion) {
        this.usuaUsuarioCreacion = usuaUsuarioCreacion;
    }

    public Date getUsuaFechaModificacion() {
        return usuaFechaModificacion;
    }

    public void setUsuaFechaModificacion(Date usuaFechaModificacion) {
        this.usuaFechaModificacion = usuaFechaModificacion;
    }

    public String getUsuaUsuarioModificacion() {
        return usuaUsuarioModificacion;
    }

    public void setUsuaUsuarioModificacion(String usuaUsuarioModificacion) {
        this.usuaUsuarioModificacion = usuaUsuarioModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuaId != null ? usuaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SailoUsuarios)) {
            return false;
        }
        SailoUsuarios other = (SailoUsuarios) object;
        if ((this.usuaId == null && other.usuaId != null) || (this.usuaId != null && !this.usuaId.equals(other.usuaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.entidadess.SailoUsuarios[ usuaId=" + usuaId + " ]";
    }
    
}
