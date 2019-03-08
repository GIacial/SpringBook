package Database.Entity;

import Database.Entity.AuthentificationEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-03-08T12:15:21")
@StaticMetamodel(IdentityEntity.class)
public class IdentityEntity_ { 

    public static volatile SingularAttribute<IdentityEntity, String> profession;
    public static volatile SingularAttribute<IdentityEntity, String> ville;
    public static volatile SingularAttribute<IdentityEntity, String> naissance;
    public static volatile SingularAttribute<IdentityEntity, AuthentificationEntity> authentification;
    public static volatile SingularAttribute<IdentityEntity, String> adresse;
    public static volatile SingularAttribute<IdentityEntity, String> genre;
    public static volatile SingularAttribute<IdentityEntity, Long> id;
    public static volatile SingularAttribute<IdentityEntity, String> codePostal;
    public static volatile SingularAttribute<IdentityEntity, String> pseudo;

}