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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "User.findByGender", query = "SELECT u FROM User u WHERE u.gender = :gender")
    , @NamedQuery(name = "User.findByCountry", query = "SELECT u FROM User u WHERE u.country = :country")
    , @NamedQuery(name = "User.findBySelectedtopics", query = "SELECT u FROM User u WHERE u.selectedtopics = :selectedtopics")
    , @NamedQuery(name = "User.findByIsAdmin", query = "SELECT u FROM User u WHERE u.isAdmin = :isAdmin")
    , @NamedQuery(name = "User.findByIsBlocked", query = "SELECT u FROM User u WHERE u.isBlocked = :isBlocked")
    , @NamedQuery(name = "User.findByLastLogin", query = "SELECT u FROM User u WHERE u.lastLogin = :lastLogin")
    , @NamedQuery(name = "User.findByLoginCounter", query = "SELECT u FROM User u WHERE u.loginCounter = :loginCounter")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private boolean gender;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "selectedtopics")
    private String selectedtopics;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_admin")
    private boolean isAdmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_blocked")
    private boolean isBlocked;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "login_counter")
    private Integer loginCounter;
    @ManyToMany(mappedBy = "userCollection")
    private Collection<Topics> topicsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<TrackLogin> trackLoginCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<UserFollowsPinboard> userFollowsPinboardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Pins> pinsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Pinboards> pinboardsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<UserFollowsUser> userFollowsUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private Collection<UserFollowsUser> userFollowsUserCollection1;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public User(String email, String username, String password, String firstname, String lastname, boolean gender, String selectedtopics, boolean isAdmin, boolean isBlocked) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.selectedtopics = selectedtopics;
        this.isAdmin = isAdmin;
        this.isBlocked = isBlocked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSelectedtopics() {
        return selectedtopics;
    }

    public void setSelectedtopics(String selectedtopics) {
        this.selectedtopics = selectedtopics;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getLoginCounter() {
        return loginCounter;
    }

    public void setLoginCounter(Integer loginCounter) {
        this.loginCounter = loginCounter;
    }

    @XmlTransient
    public Collection<Topics> getTopicsCollection() {
        return topicsCollection;
    }

    public void setTopicsCollection(Collection<Topics> topicsCollection) {
        this.topicsCollection = topicsCollection;
    }

    @XmlTransient
    public Collection<TrackLogin> getTrackLoginCollection() {
        return trackLoginCollection;
    }

    public void setTrackLoginCollection(Collection<TrackLogin> trackLoginCollection) {
        this.trackLoginCollection = trackLoginCollection;
    }

    @XmlTransient
    public Collection<UserFollowsPinboard> getUserFollowsPinboardCollection() {
        return userFollowsPinboardCollection;
    }

    public void setUserFollowsPinboardCollection(Collection<UserFollowsPinboard> userFollowsPinboardCollection) {
        this.userFollowsPinboardCollection = userFollowsPinboardCollection;
    }

    @XmlTransient
    public Collection<Pins> getPinsCollection() {
        return pinsCollection;
    }

    public void setPinsCollection(Collection<Pins> pinsCollection) {
        this.pinsCollection = pinsCollection;
    }

    @XmlTransient
    public Collection<Pinboards> getPinboardsCollection() {
        return pinboardsCollection;
    }

    public void setPinboardsCollection(Collection<Pinboards> pinboardsCollection) {
        this.pinboardsCollection = pinboardsCollection;
    }

    @XmlTransient
    public Collection<UserFollowsUser> getUserFollowsUserCollection() {
        return userFollowsUserCollection;
    }

    public void setUserFollowsUserCollection(Collection<UserFollowsUser> userFollowsUserCollection) {
        this.userFollowsUserCollection = userFollowsUserCollection;
    }

    @XmlTransient
    public Collection<UserFollowsUser> getUserFollowsUserCollection1() {
        return userFollowsUserCollection1;
    }

    public void setUserFollowsUserCollection1(Collection<UserFollowsUser> userFollowsUserCollection1) {
        this.userFollowsUserCollection1 = userFollowsUserCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ email=" + email + " ]";
    }
    
}
