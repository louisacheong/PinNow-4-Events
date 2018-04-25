/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.UserFollowsPinboard;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author louisacheong
 */
@Stateless
public class UserFollowsPinboardFacade extends AbstractFacade<UserFollowsPinboard> {

    @PersistenceContext(unitName = "PinNow_4_EventsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFollowsPinboardFacade() {
        super(UserFollowsPinboard.class);
    }
    
}
