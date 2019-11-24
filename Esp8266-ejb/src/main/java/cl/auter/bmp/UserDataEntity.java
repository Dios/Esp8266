/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.auter.bmp;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author drobles
 */
@Entity
@Table(name = "user_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDataEntity.findAll", query = "SELECT u FROM UserDataEntity u")
    , @NamedQuery(name = "UserDataEntity.findById", query = "SELECT u FROM UserDataEntity u WHERE u.id = :id")
    , @NamedQuery(name = "UserDataEntity.findByUsername", query = "SELECT u FROM UserDataEntity u WHERE u.username = :username")
    , @NamedQuery(name = "UserDataEntity.findByIdChat", query = "SELECT u FROM UserDataEntity u WHERE u.idChat = :idChat")
    , @NamedQuery(name = "UserDataEntity.findByRunning", query = "SELECT u FROM UserDataEntity u WHERE u.running = :running")})
public class UserDataEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "username")
    private String username;
    @Column(name = "id_chat")
    private Integer idChat;
    @Column(name = "running")
    private Boolean running;

    public UserDataEntity() {
    }

    public UserDataEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
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
        if (!(object instanceof UserDataEntity)) {
            return false;
        }
        UserDataEntity other = (UserDataEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.auter.bmp.UserDataEntity[ id=" + id + " ]";
    }
    
}
