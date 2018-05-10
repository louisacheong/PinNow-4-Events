/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Notification;
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
public class NotificationFacade extends AbstractFacade<Notification> {

    @PersistenceContext(unitName = "PinNow_4_EventsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificationFacade() {
        super(Notification.class);
    }
    
    public List<Notification> findByFollower (String follower){
        Query q=em.createNamedQuery("Notification.findByFollower");
        q.setParameter("follower", follower);
        return q.getResultList();
    }
    
    public List<Notification> findByUserBeingFollowed (String beingFollowed){
        Query q=em.createNamedQuery("Notification.findByUserBeingFollowed");
        q.setParameter("beingFollowed", beingFollowed);
        q.setParameter("description", "follow user");
        return q.getResultList();
    }
    
    public Notification findByRow (String follower, String beingFollowed, String description){
        Query q=em.createNamedQuery("Notification.findByRow");
        q.setParameter("follower", follower);
        q.setParameter("beingFollowed", beingFollowed);
        q.setParameter("description", description);
        return (Notification)q.getSingleResult();

    }
     public Notification findByPinboardsRow (String follower, String beingFollowed, String pinboard_name,String description){
        Query q=em.createNamedQuery("Notification.findByPinboardsRow");
        q.setParameter("follower", follower);
        q.setParameter("beingFollowed", beingFollowed);
        q.setParameter("pinboardsName", pinboard_name);
        q.setParameter("description", description);
        return (Notification)q.getSingleResult();
    }
     
    public List<Notification> findByPinboardBeingFollowed (String beingFollowed){
        Query q=em.createNamedQuery("Notification.findByPinboardBeingFollowed");
        q.setParameter("beingFollowed", beingFollowed);
        q.setParameter("description", "follow pinboard");
        return q.getResultList();
    }
   
    
    
    
}
