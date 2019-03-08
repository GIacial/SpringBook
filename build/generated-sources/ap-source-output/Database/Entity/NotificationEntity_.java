package Database.Entity;

import Database.Entity.IdentityEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-03-08T12:15:21")
@StaticMetamodel(NotificationEntity.class)
public class NotificationEntity_ { 

    public static volatile SingularAttribute<NotificationEntity, String> msg;
    public static volatile SingularAttribute<NotificationEntity, IdentityEntity> cible;
    public static volatile SingularAttribute<NotificationEntity, Long> id;
    public static volatile SingularAttribute<NotificationEntity, IdentityEntity> auteur;

}