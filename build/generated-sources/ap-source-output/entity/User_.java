package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-16T22:47:50")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> country;
    public static volatile SingularAttribute<User, Date> lastLogin;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> firstname;
    public static volatile SingularAttribute<User, Boolean> gender;
    public static volatile SingularAttribute<User, Integer> loginCounter;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> lastname;

}