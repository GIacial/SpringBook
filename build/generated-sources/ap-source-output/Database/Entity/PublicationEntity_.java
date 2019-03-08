package Database.Entity;

import Database.Entity.IdentityEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-03-08T12:15:21")
@StaticMetamodel(PublicationEntity.class)
public class PublicationEntity_ { 

    public static volatile SingularAttribute<PublicationEntity, Long> id;
    public static volatile SingularAttribute<PublicationEntity, IdentityEntity> mur;
    public static volatile SingularAttribute<PublicationEntity, String> message;
    public static volatile SingularAttribute<PublicationEntity, Date> creation;
    public static volatile SingularAttribute<PublicationEntity, IdentityEntity> auteur;

}