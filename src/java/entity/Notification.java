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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author louisacheong
 */
@Entity
@Table(name = "notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
    , @NamedQuery(name = "Notification.findById", query = "SELECT n FROM Notification n WHERE n.id = :id")
    , @NamedQuery(name = "Notification.findByFollower", query = "SELECT n FROM Notification n WHERE n.follower = :follower")
    , @NamedQuery(name = "Notification.findByUserBeingFollowed", query = "SELECT n FROM Notification n WHERE n.beingFollowed = :beingFollowed AND n.description = :description")
    , @NamedQuery(name = "Notification.findByUpdateTime", query = "SELECT n FROM Notification n WHERE n.updateTime = :updateTime")
    , @NamedQuery(name = "Notification.findByPinboardsName", query = "SELECT n FROM Notification n WHERE n.pinboardsName = :pinboardsName")
    , @NamedQuery(name = "Notification.findByIsPermitted", query = "SELECT n FROM Notification n WHERE n.isPermitted = :isPermitted")
    , @NamedQuery(name = "Notification.findByDescription", query = "SELECT n FROM Notification n WHERE n.description = :description")
    , @NamedQuery(name = "Notification.findByPinboardsRow", query = "SELECT n FROM Notification n WHERE n.follower = :follower AND n.beingFollowed = :beingFollowed AND n.pinboardsName = :pinboardsName AND n.description = :description")
    , @NamedQuery(name = "Notification.findByPinboardBeingFollowed", query = "SELECT n FROM Notification n WHERE n.beingFollowed = :beingFollowed AND n.description = :description")

})

public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "follower")
    private String follower;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "BeingFollowed")
    private String beingFollowed;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Size(max = 255)
    @Column(name = "pinboards_name")
    private String pinboardsName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPermitted")
    private boolean isPermitted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;

    public Notification() {
    }

    public Notification(Integer id) {
        this.id = id;
    }

    public Notification(Integer id, String follower, String beingFollowed, boolean isPermitted, String description) {
        this.id = id;
        this.follower = follower;
        this.beingFollowed = beingFollowed;
        this.isPermitted = isPermitted;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getBeingFollowed() {
        return beingFollowed;
    }

    public void setBeingFollowed(String beingFollowed) {
        this.beingFollowed = beingFollowed;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPinboardsName() {
        return pinboardsName;
    }

    public void setPinboardsName(String pinboardsName) {
        this.pinboardsName = pinboardsName;
    }

    public boolean getIsPermitted() {
        return isPermitted;
    }

    public void setIsPermitted(boolean isPermitted) {
        this.isPermitted = isPermitted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Notification[ id=" + id + " ]";
    }
    
}
