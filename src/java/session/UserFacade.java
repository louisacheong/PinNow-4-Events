/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.User;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "PinNow_4_EventsPU")/*injects a container-managed EM into class, i.e. EJB container will open/close EMs*/
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    

    
    public User authenticate(String email){
        if (email == null)
            return null;
        return findByEmail(email.trim());
    }
    
    
    public User authenticate(String email, String password){
        if (email == null || password == null)
            return null;
        User user = authenticate(email);
        if (user != null){
            String hashedPassword = hash(password.trim());
            if (!user.getPassword().equals(hashedPassword))
                user = null;
        }
        return user;
    }
    
    private String hash(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            return bigInt.toString(16);
        }catch (UnsupportedEncodingException ex){
            throw new RuntimeException("UTF-8 not supported");
        }catch (NoSuchAlgorithmException ex){
            throw new RuntimeException("SHA-256 not supported");
        }
    }
    
    
    
    public User findByEmailAndUsername(String email, String userName){
        Query q = em.createNamedQuery("User.findByEmailAndUsername");
        q.setParameter("email",email);
        q.setParameter("username",userName);
        return (User)q.getSingleResult();
    }

    public User findByEmailAndPassword(String email, String password){
        Query q = em.createNamedQuery("User.findByEmailAndPassword");
        q.setParameter("email",email);
        q.setParameter("password",password);
        return (User)q.getSingleResult();
    }
    
    public User findByEmail(String email) {
        Query q = em.createNamedQuery("User.findByEmail");
        q.setParameter("email",email);
        return (User)q.getSingleResult();
    }
    
}

