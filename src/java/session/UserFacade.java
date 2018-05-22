/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.User;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author louisacheong
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "PinNow_4_EventsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    public User findByEmailAndPassword(String email, String password){
        Query q = em.createNamedQuery("User.findByEmailAndPassword");
        q.setParameter("email",email);
        q.setParameter("password",password);
        return (User)q.getSingleResult();
    }
    
    public User findByEmail(String email){
        Query q = em.createNamedQuery("User.findByEmail");
        q.setParameter("email",email);
        return (User)q.getSingleResult();
    }
    
    public User findByEmailAndUsername(String email, String username){
        Query q = em.createNamedQuery("User.findByEmailAndUsername");
        q.setParameter("username", username);
        q.setParameter("email", email);
        return (User)q.getSingleResult();
    }
    
    public List<User> findByUsername(String username){
        Query q = em.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);
        return q.getResultList();
    }
    
     public List<User> findByLastname(String lastname){
        Query q = em.createNamedQuery("User.findByLastname");
        q.setParameter("lastname", lastname);
        return q.getResultList();
    }
    
    public List<User> findByFirstname(String firstname){
        Query q = em.createNamedQuery("User.findByFirstname");
        q.setParameter("firstname", firstname);
        return q.getResultList();
    }
    
     public User auth(String email){
        if (email == null)
            return null;
        return find(email.trim());
    }
    
    
    public User authenticate(String email, String password){
        if (email == null || password == null)
            return null;
        User user = auth(email);
        if (user != null){
            String hashedPassword = hash(password.trim());
            if (!user.getPassword().equals(hashedPassword)) //authentication is successful when the user found by email has a password that matches the hashed password
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

    
}
