/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Topics;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author louisacheong
 */
@Stateless
public class TopicsFacade extends AbstractFacade<Topics> {

    @PersistenceContext(unitName = "PinNow_4_EventsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TopicsFacade() {
        super(Topics.class);
    }
    public Topics findByName(String topic){
        Query q = em.createNamedQuery("Topics.findByName");
        q.setParameter("name", topic);
        return (Topics)q.getSingleResult();
    }
}
