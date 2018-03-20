/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TrackLogin;
import entity.User;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author louisacheong
 */
@Stateless
public class TrackLoginFacade extends AbstractFacade<TrackLogin> {

    @PersistenceContext(unitName = "PinNow_4_EventsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrackLoginFacade() {
        super(TrackLogin.class);
    }
    
    public List<TrackLogin> LoginsPast2Weeks(String email){
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC-1")); //Munich Time
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, - 14); //subtract 14 days/ 2 weeks to look back
        Date dateToLookBackAfter = calendar.getTime();
        System.out.println(dateToLookBackAfter);
        Query q = em.createNamedQuery("TrackLogin.LoginsPast2Weeks");
        q.setParameter("email",email);
        q.setParameter("dateToLookBackAfter", dateToLookBackAfter, TemporalType.TIMESTAMP);
        return q.getResultList();
        
    }
    
}
