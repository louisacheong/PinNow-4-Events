/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Pins;
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
public class PinsFacade extends AbstractFacade<Pins> {

    @PersistenceContext(unitName = "PinNow_4_EventsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PinsFacade() {
        super(Pins.class);
    }
    public List<Pins> findByUserEmail(String email){
        Query q=em.createNamedQuery("Pins.findByUserEmail");
        q.setParameter("userEmail", email);
        return q.getResultList();
    }
    public List<Pins> findByTopicsName(String topicsName){
        Query q=em.createNamedQuery("Pins.findByTopicsName");
        q.setParameter("topicsName", topicsName);
        return q.getResultList();
    }
    public List<Pins> findByTopicsNameandUserEmail(String topicsName, String email){
        Query q=em.createNamedQuery("Pins.findByTopicsNameandUserEmail");
        q.setParameter("topicsName", topicsName);
        q.setParameter("userEmail",email);
        return q.getResultList();
    }
    
    
}
