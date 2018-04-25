/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "user_follows_pinboard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserFollowsPinboard.findAll", query = "SELECT u FROM UserFollowsPinboard u")
    , @NamedQuery(name = "UserFollowsPinboard.findByUserEmail", query = "SELECT u FROM UserFollowsPinboard u WHERE u.userFollowsPinboardPK.userEmail = :userEmail")
    , @NamedQuery(name = "UserFollowsPinboard.findByPinboardsName", query = "SELECT u FROM UserFollowsPinboard u WHERE u.userFollowsPinboardPK.pinboardsName = :pinboardsName")
    , @NamedQuery(name = "UserFollowsPinboard.findByPinboardsUserEmail", query = "SELECT u FROM UserFollowsPinboard u WHERE u.userFollowsPinboardPK.pinboardsUserEmail = :pinboardsUserEmail")
    , @NamedQuery(name = "UserFollowsPinboard.findByIsPermitted", query = "SELECT u FROM UserFollowsPinboard u WHERE u.isPermitted = :isPermitted")})
public class UserFollowsPinboard implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserFollowsPinboardPK userFollowsPinboardPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPermitted")
    private boolean isPermitted;

    public UserFollowsPinboard() {
    }

    public UserFollowsPinboard(UserFollowsPinboardPK userFollowsPinboardPK) {
        this.userFollowsPinboardPK = userFollowsPinboardPK;
    }

    public UserFollowsPinboard(UserFollowsPinboardPK userFollowsPinboardPK, boolean isPermitted) {
        this.userFollowsPinboardPK = userFollowsPinboardPK;
        this.isPermitted = isPermitted;
    }

    public UserFollowsPinboard(String userEmail, String pinboardsName, String pinboardsUserEmail) {
        this.userFollowsPinboardPK = new UserFollowsPinboardPK(userEmail, pinboardsName, pinboardsUserEmail);
    }

    public UserFollowsPinboardPK getUserFollowsPinboardPK() {
        return userFollowsPinboardPK;
    }

    public void setUserFollowsPinboardPK(UserFollowsPinboardPK userFollowsPinboardPK) {
        this.userFollowsPinboardPK = userFollowsPinboardPK;
    }

    public boolean getIsPermitted() {
        return isPermitted;
    }

    public void setIsPermitted(boolean isPermitted) {
        this.isPermitted = isPermitted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userFollowsPinboardPK != null ? userFollowsPinboardPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserFollowsPinboard)) {
            return false;
        }
        UserFollowsPinboard other = (UserFollowsPinboard) object;
        if ((this.userFollowsPinboardPK == null && other.userFollowsPinboardPK != null) || (this.userFollowsPinboardPK != null && !this.userFollowsPinboardPK.equals(other.userFollowsPinboardPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserFollowsPinboard[ userFollowsPinboardPK=" + userFollowsPinboardPK + " ]";
    }
    
}
