package entity;

import entity.Pinboards;
import entity.Pins;
import entity.Topics;
import entity.TrackLogin;
import entity.UserFollowsPinboard;
import entity.UserFollowsUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T21:37:11")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> country;
    public static volatile SingularAttribute<User, Date> lastLogin;
    public static volatile SingularAttribute<User, String> firstname;
    public static volatile CollectionAttribute<User, Pins> pinsCollection;
    public static volatile CollectionAttribute<User, Pinboards> pinboardsCollection;
    public static volatile SingularAttribute<User, Boolean> gender;
    public static volatile CollectionAttribute<User, UserFollowsUser> userFollowsUserCollection1;
    public static volatile SingularAttribute<User, Boolean> isBlocked;
    public static volatile SingularAttribute<User, Boolean> isAdmin;
    public static volatile CollectionAttribute<User, UserFollowsUser> userFollowsUserCollection;
    public static volatile SingularAttribute<User, String> selectedtopics;
    public static volatile CollectionAttribute<User, TrackLogin> trackLoginCollection;
    public static volatile SingularAttribute<User, String> lastname;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, UserFollowsPinboard> userFollowsPinboardCollection;
    public static volatile SingularAttribute<User, Integer> loginCounter;
    public static volatile CollectionAttribute<User, Topics> topicsCollection;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}