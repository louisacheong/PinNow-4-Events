/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author louisacheong
 */
@Entity
@Table(name = "pinboards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pinboards.findAll", query = "SELECT p FROM Pinboards p")
    , @NamedQuery(name = "Pinboards.findByName", query = "SELECT p FROM Pinboards p WHERE p.pinboardsPK.name = :name")
    , @NamedQuery(name = "Pinboards.findByCreateTime", query = "SELECT p FROM Pinboards p WHERE p.createTime = :createTime")
    , @NamedQuery(name = "Pinboards.findByLastUpdated", query = "SELECT p FROM Pinboards p WHERE p.lastUpdated = :lastUpdated")
    , @NamedQuery(name = "Pinboards.findByIsPrivate", query = "SELECT p FROM Pinboards p WHERE p.isPrivate = :isPrivate")
    , @NamedQuery(name = "Pinboards.findByUserEmail", query = "SELECT p FROM Pinboards p WHERE p.pinboardsPK.userEmail = :userEmail")})
public class Pinboards implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PinboardsPK pinboardsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPrivate")
    private boolean isPrivate;
    @OneToMany(mappedBy = "pinboards")
    private Collection<Pins> pinsCollection;

    public Pinboards() {
    }

    public Pinboards(PinboardsPK pinboardsPK) {
        this.pinboardsPK = pinboardsPK;
    }

    public Pinboards(PinboardsPK pinboardsPK, Date createTime, Date lastUpdated, boolean isPrivate) {
        this.pinboardsPK = pinboardsPK;
        this.createTime = createTime;
        this.lastUpdated = lastUpdated;
        this.isPrivate = isPrivate;
    }

    public Pinboards(String name, String userEmail) {
        this.pinboardsPK = new PinboardsPK(name, userEmail);
    }

    public PinboardsPK getPinboardsPK() {
        return pinboardsPK;
    }

    public void setPinboardsPK(PinboardsPK pinboardsPK) {
        this.pinboardsPK = pinboardsPK;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    @XmlTransient
    public Collection<Pins> getPinsCollection() {
        return pinsCollection;
    }

    public void setPinsCollection(Collection<Pins> pinsCollection) {
        this.pinsCollection = pinsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pinboardsPK != null ? pinboardsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pinboards)) {
            return false;
        }
        Pinboards other = (Pinboards) object;
        if ((this.pinboardsPK == null && other.pinboardsPK != null) || (this.pinboardsPK != null && !this.pinboardsPK.equals(other.pinboardsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pinboards[ pinboardsPK=" + pinboardsPK + " ]";
    }
    
}
