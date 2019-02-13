/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Services.IdentityService;
import org.springframework.stereotype.Service;

/**
 *
 * @author jérémy
 */
@Service
public class IdentityServiceImpl implements IdentityService {

    public String getPseudo(String adresseMail) {
        String[] tab = adresseMail.split("@");
        return tab[0];
    }
    
}
