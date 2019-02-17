/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Database.Entity.IdentityEntity;
import Database.Entity.PublicationEntity;
import java.util.List;

/**
 *
 * @author jérémy
 */
public interface PublicationService {
    
    public void createPublication(String msg , IdentityEntity auteur);
    public List<PublicationEntity> getAllPublication(IdentityEntity mur);
}
