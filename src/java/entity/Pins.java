/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
 * @author louisacheong
 */
@Entity
@Table(name = "pins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pins.findAll", query = "SELECT p FROM Pins p")
    , @NamedQuery(name = "Pins.findByName", query = "SELECT p FROM Pins p WHERE p.pinsPK.name = :name")
    , @NamedQuery(name = "Pins.findByLastPinned", query = "SELECT p FROM Pins p WHERE p.lastPinned = :lastPinned")
    , @NamedQuery(name = "Pins.findByCreateTime", query = "SELECT p FROM Pins p WHERE p.createTime = :createTime")
    , @NamedQuery(name = "Pins.findByDescription", query = "SELECT p FROM Pins p WHERE p.description = :description")
    , @NamedQuery(name = "Pins.findByTopicsName", query = "SELECT p FROM Pins p WHERE p.pinsPK.topicsName = :topicsName")
    , @NamedQuery(name = "Pins.findByLocation", query = "SELECT p FROM Pins p WHERE p.location = :location")
    , @NamedQuery(name = "Pins.findByUserEmail", query = "SELECT p FROM Pins p WHERE p.pinsPK.userEmail = :userEmail")})
public class Pins implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PinsPK pinsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_pinned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPinned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "location")
    private String location;
    @JoinColumns({
        @JoinColumn(name = "pinboards_name", referencedColumnName = "name")
        , @JoinColumn(name = "pinboards_user_email", referencedColumnName = "user_email")})
    @ManyToOne
    private Pinboards pinboards;
    @JoinColumn(name = "topics_name", referencedColumnName = "name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Topics topics;

    public Pins() {
    }

    public Pins(PinsPK pinsPK) {
        this.pinsPK = pinsPK;
    }

    public Pins(PinsPK pinsPK, Date lastPinned, Date createTime) {
        this.pinsPK = pinsPK;
        this.lastPinned = lastPinned;
        this.createTime = createTime;
    }

    public Pins(String name, String topicsName, String userEmail) {
        this.pinsPK = new PinsPK(name, topicsName, userEmail);
    }

    public PinsPK getPinsPK() {
        return pinsPK;
    }

    public void setPinsPK(PinsPK pinsPK) {
        this.pinsPK = pinsPK;
    }

    public Date getLastPinned() {
        return lastPinned;
    }

    public void setLastPinned(Date lastPinned) {
        this.lastPinned = lastPinned;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Pinboards getPinboards() {
        return pinboards;
    }

    public void setPinboards(Pinboards pinboards) {
        this.pinboards = pinboards;
    }

    public Topics getTopics() {
        return topics;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pinsPK != null ? pinsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pins)) {
            return false;
        }
        Pins other = (Pins) object;
        if ((this.pinsPK == null && other.pinsPK != null) || (this.pinsPK != null && !this.pinsPK.equals(other.pinsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pins[ pinsPK=" + pinsPK + " ]";
    }
    
}
