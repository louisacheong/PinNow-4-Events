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
public class UserFollowsPinboardPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_email")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pinboards_name")
    private String pinboardsName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pinboards_user_email")
    private String pinboardsUserEmail;

    public UserFollowsPinboardPK() {
    }

    public UserFollowsPinboardPK(String userEmail, String pinboardsName, String pinboardsUserEmail) {
        this.userEmail = userEmail;
        this.pinboardsName = pinboardsName;
        this.pinboardsUserEmail = pinboardsUserEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPinboardsName() {
        return pinboardsName;
    }

    public void setPinboardsName(String pinboardsName) {
        this.pinboardsName = pinboardsName;
    }

    public String getPinboardsUserEmail() {
        return pinboardsUserEmail;
    }

    public void setPinboardsUserEmail(String pinboardsUserEmail) {
        this.pinboardsUserEmail = pinboardsUserEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userEmail != null ? userEmail.hashCode() : 0);
        hash += (pinboardsName != null ? pinboardsName.hashCode() : 0);
        hash += (pinboardsUserEmail != null ? pinboardsUserEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserFollowsPinboardPK)) {
            return false;
        }
        UserFollowsPinboardPK other = (UserFollowsPinboardPK) object;
        if ((this.userEmail == null && other.userEmail != null) || (this.userEmail != null && !this.userEmail.equals(other.userEmail))) {
            return false;
        }
        if ((this.pinboardsName == null && other.pinboardsName != null) || (this.pinboardsName != null && !this.pinboardsName.equals(other.pinboardsName))) {
            return false;
        }
        if ((this.pinboardsUserEmail == null && other.pinboardsUserEmail != null) || (this.pinboardsUserEmail != null && !this.pinboardsUserEmail.equals(other.pinboardsUserEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserFollowsPinboardPK[ userEmail=" + userEmail + ", pinboardsName=" + pinboardsName + ", pinboardsUserEmail=" + pinboardsUserEmail + " ]";
    }
    
}
