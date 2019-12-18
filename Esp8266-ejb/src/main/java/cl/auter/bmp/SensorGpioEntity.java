/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.auter.bmp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author drobles
 */
@Entity
@Table(name = "sensorgpio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SensorGpioEntity.findAll", query = "SELECT s FROM SensorGpioEntity s")
    , @NamedQuery(name = "SensorGpioEntity.findById", query = "SELECT s FROM SensorGpioEntity s WHERE s.id = :id")
    , @NamedQuery(name = "SensorGpioEntity.findByGpioValue", query = "SELECT s FROM SensorGpioEntity s WHERE s.gpioValue = :gpioValue")
    , @NamedQuery(name = "SensorGpioEntity.findByLastDate", query = "SELECT s FROM SensorGpioEntity s WHERE s.lastDate = :lastDate")})
public class SensorGpioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "gpio_value")
    private Integer gpioValue;
    @Column(name = "last_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastDate;

    public SensorGpioEntity() {
    }

    public SensorGpioEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGpioValue() {
        return gpioValue;
    }

    public void setGpioValue(Integer gpioValue) {
        this.gpioValue = gpioValue;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
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
        if (!(object instanceof SensorGpioEntity)) {
            return false;
        }
        SensorGpioEntity other = (SensorGpioEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.auter.bmp.SensorGpioEntity[ id=" + id + " ]";
    }
    
}
