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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author louisacheong
 */
@Entity
@Table(name = "topics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topics.findAll", query = "SELECT t FROM Topics t")
    , @NamedQuery(name = "Topics.findByName", query = "SELECT t FROM Topics t WHERE t.name = :name")
    , @NamedQuery(name = "Topics.findByCreateTime", query = "SELECT t FROM Topics t WHERE t.createTime = :createTime")})
public class Topics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @JoinTable(name = "admin_create_or_update_topics", joinColumns = {
        @JoinColumn(name = "topics_name", referencedColumnName = "name")}, inverseJoinColumns = {
        @JoinColumn(name = "user_email", referencedColumnName = "email")})
    @ManyToMany
    private Collection<User> userCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topics")
    private Collection<Pins> pinsCollection;

    public Topics() {
    }

    public Topics(String name) {
        this.name = name;
    }

    public Topics(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
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
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topics)) {
            return false;
        }
        Topics other = (Topics) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Topics[ name=" + name + " ]";
    }
    
}
