/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Pinboards;
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
public class PinboardsFacade extends AbstractFacade<Pinboards> {

    @PersistenceContext(unitName = "PinNow_4_EventsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PinboardsFacade() {
        super(Pinboards.class);
    }
    
     public List<Pinboards> findByUserEmail(String email){
        Query q=em.createNamedQuery("Pinboards.findByUserEmail");
        q.setParameter("userEmail", email);
        return q.getResultList();
    }
     
    public Pinboards findByUserEmailandName(String email, String name){
        Query q=em.createNamedQuery("Pinboards.findByUserEmailandName");
        q.setParameter("userEmail", email);
        q.setParameter("name", name);
        return (Pinboards)q.getSingleResult();
    }
    
    public List<Pinboards> findByName (String name){
        Query q=em.createNamedQuery("Pinboards.findByName");
        q.setParameter("name", name);
        return q.getResultList();
    }
    
    
}
