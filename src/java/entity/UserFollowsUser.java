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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "user_follows_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserFollowsUser.findAll", query = "SELECT u FROM UserFollowsUser u")
    , @NamedQuery(name = "UserFollowsUser.findByFollower", query = "SELECT u FROM UserFollowsUser u WHERE u.userFollowsUserPK.follower = :follower")
    , @NamedQuery(name = "UserFollowsUser.findByPersonBeingFollowed", query = "SELECT u FROM UserFollowsUser u WHERE u.userFollowsUserPK.personBeingFollowed = :personBeingFollowed")
    , @NamedQuery(name = "UserFollowsUser.findByIsPermitted", query = "SELECT u FROM UserFollowsUser u WHERE u.isPermitted = :isPermitted")
    , @NamedQuery(name = "UserFollowsUser.findByFollowerandisPermitted", query = "SELECT u FROM UserFollowsUser u WHERE u.userFollowsUserPK.follower = :follower AND u.isPermitted = :isPermitted")
    , @NamedQuery(name = "UserFollowsUser.findByPersonBeingFollowedandisPermitted", query = "SELECT u FROM UserFollowsUser u WHERE u.userFollowsUserPK.personBeingFollowed = :personBeingFollowed AND u.isPermitted = :isPermitted")
})
public class UserFollowsUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserFollowsUserPK userFollowsUserPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPermitted")
    private boolean isPermitted;
    @JoinColumn(name = "follower", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "personBeingFollowed", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;

    public UserFollowsUser() {
    }

    public UserFollowsUser(UserFollowsUserPK userFollowsUserPK) {
        this.userFollowsUserPK = userFollowsUserPK;
    }

    public UserFollowsUser(UserFollowsUserPK userFollowsUserPK, boolean isPermitted) {
        this.userFollowsUserPK = userFollowsUserPK;
        this.isPermitted = isPermitted;
    }

    public UserFollowsUser(String follower, String personBeingFollowed) {
        this.userFollowsUserPK = new UserFollowsUserPK(follower, personBeingFollowed);
    }

    public UserFollowsUserPK getUserFollowsUserPK() {
        return userFollowsUserPK;
    }

    public void setUserFollowsUserPK(UserFollowsUserPK userFollowsUserPK) {
        this.userFollowsUserPK = userFollowsUserPK;
    }

    public boolean getIsPermitted() {
        return isPermitted;
    }

    public void setIsPermitted(boolean isPermitted) {
        this.isPermitted = isPermitted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userFollowsUserPK != null ? userFollowsUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserFollowsUser)) {
            return false;
        }
        UserFollowsUser other = (UserFollowsUser) object;
        if ((this.userFollowsUserPK == null && other.userFollowsUserPK != null) || (this.userFollowsUserPK != null && !this.userFollowsUserPK.equals(other.userFollowsUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserFollowsUser[ userFollowsUserPK=" + userFollowsUserPK + " ]";
    }
    
}
