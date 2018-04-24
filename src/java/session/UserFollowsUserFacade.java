/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.UserFollowsUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author louisacheong
 */
@Stateless
public class UserFollowsUserFacade extends AbstractFacade<UserFollowsUser> {

    @PersistenceContext(unitName = "PinNow_4_EventsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFollowsUserFacade() {
        super(UserFollowsUser.class);
    }
    
    public UserFollowsUser findByPK(String follower, String personBeingFollowed) {
        Query q = em.createNamedQuery("UserFollowsUser.findByPK");
        q.setParameter("follower", follower);
        q.setParameter("personBeingFollowed", personBeingFollowed);
        return (UserFollowsUser)q.getSingleResult();
    }
    
    public List<UserFollowsUser> findByFollower(String follower){
        Query q = em.createNamedQuery("UserFollowsUser.findByFollower");
        q.setParameter("follower", follower);
        return q.getResultList();
    }
    
    public List<UserFollowsUser> findByPersonBeingFollowed(String personBeingFollowed){
        Query q = em.createNamedQuery("UserFollowsUser.findByPersonBeingFollowed");
        q.setParameter("personBeingFollowed",personBeingFollowed);
        return q.getResultList();
    }
}
