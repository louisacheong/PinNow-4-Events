/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author louisacheong
 */
@Embeddable
public class UserFollowsUserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "follower")
    private String follower;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "personBeingFollowed")
    private String personBeingFollowed;

    public UserFollowsUserPK() {
    }

    public UserFollowsUserPK(String follower, String personBeingFollowed) {
        this.follower = follower;
        this.personBeingFollowed = personBeingFollowed;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getPersonBeingFollowed() {
        return personBeingFollowed;
    }

    public void setPersonBeingFollowed(String personBeingFollowed) {
        this.personBeingFollowed = personBeingFollowed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (follower != null ? follower.hashCode() : 0);
        hash += (personBeingFollowed != null ? personBeingFollowed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserFollowsUserPK)) {
            return false;
        }
        UserFollowsUserPK other = (UserFollowsUserPK) object;
        if ((this.follower == null && other.follower != null) || (this.follower != null && !this.follower.equals(other.follower))) {
            return false;
        }
        if ((this.personBeingFollowed == null && other.personBeingFollowed != null) || (this.personBeingFollowed != null && !this.personBeingFollowed.equals(other.personBeingFollowed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserFollowsUserPK[ follower=" + follower + ", personBeingFollowed=" + personBeingFollowed + " ]";
    }
    
}
