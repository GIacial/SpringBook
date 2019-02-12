/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Services.IdentificationService;
import org.springframework.stereotype.Service;

/**
 *
 * @author jérémy
 */
@Service
public class IdentificationServiceImpl implements IdentificationService{

    public boolean isCorrectIdentifier(String email, String mdp) {
        return (!email.equals("")) && (!mdp.equals(""));
    }
    
}
