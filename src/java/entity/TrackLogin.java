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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author louisacheong
 */
@Entity
@Table(name = "track_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrackLogin.findAll", query = "SELECT t FROM TrackLogin t")
    , @NamedQuery(name = "TrackLogin.findByEmail", query = "SELECT t FROM TrackLogin t WHERE t.trackLoginPK.email = :email")
    , @NamedQuery(name = "TrackLogin.findByLastLogin", query = "SELECT t FROM TrackLogin t WHERE t.trackLoginPK.lastLogin = :lastLogin")
    , @NamedQuery(name = "TrackLogin.findByStillLoggedIn", query = "SELECT t FROM TrackLogin t WHERE t.stillLoggedIn = :stillLoggedIn AND t.trackLoginPK.lastLogin >:timeToLookBackAfter")
    , @NamedQuery(name= "TrackLogin.LoginsPast2Weeks", query = "SELECT t FROM TrackLogin t WHERE t.trackLoginPK.email =:email AND t.trackLoginPK.lastLogin >:dateToLookBackAfter")
    , @NamedQuery(name= "TrackLogin.findByPK", query = "SELECT t FROM TrackLogin t WHERE t.trackLoginPK.email =:email AND t.trackLoginPK.lastLogin =:lastLogin")})
public class TrackLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrackLoginPK trackLoginPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "still_logged_in")
    private boolean stillLoggedIn;

    public TrackLogin() {
    }

    public TrackLogin(TrackLoginPK trackLoginPK) {
        this.trackLoginPK = trackLoginPK;
    }

    public TrackLogin(TrackLoginPK trackLoginPK, boolean stillLoggedIn) {
        this.trackLoginPK = trackLoginPK;
        this.stillLoggedIn = stillLoggedIn;
    }

    public TrackLogin(String email, Date lastLogin) {
        this.trackLoginPK = new TrackLoginPK(email, lastLogin);
    }

    public TrackLoginPK getTrackLoginPK() {
        return trackLoginPK;
    }

    public void setTrackLoginPK(TrackLoginPK trackLoginPK) {
        this.trackLoginPK = trackLoginPK;
    }

    public boolean getStillLoggedIn() {
        return stillLoggedIn;
    }

    public void setStillLoggedIn(boolean stillLoggedIn) {
        this.stillLoggedIn = stillLoggedIn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackLoginPK != null ? trackLoginPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrackLogin)) {
            return false;
        }
        TrackLogin other = (TrackLogin) object;
        if ((this.trackLoginPK == null && other.trackLoginPK != null) || (this.trackLoginPK != null && !this.trackLoginPK.equals(other.trackLoginPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TrackLogin[ trackLoginPK=" + trackLoginPK + " ]";
    }
    
}
