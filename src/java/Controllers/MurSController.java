/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Database.Entity.IdentityEntity;
import Services.IdentityService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jérémy
 */
@Controller
public class MurSController {
    
    @Autowired
    private IdentityService identityService;
    
    @RequestMapping (value="amimur" , method = RequestMethod.GET)
    public ModelAndView handleRequestInternal (HttpServletRequest request , @RequestParam long keyIdentity) throws Exception{
        String result = "Erreur d'identification";    
        ModelAndView mv = null;      
        HttpSession session = request.getSession (true);
        

        if(session.getAttribute("login") != null){
            //ModelVue
            mv = new ModelAndView("mur");
            IdentityEntity identity = identityService.findIdentity(keyIdentity);
            if(identity != null){        
                mv.addObject("pseudo", identity.getPseudo());
            }
            else{
                mv.addObject("pseudo", "Error");
                mv.addObject("alert", "Identity not found");
            }
        }
        else{
            mv = new ModelAndView("index");
            mv.addObject("alert", result);
        }
        return mv;
    }
    
    @RequestMapping (value="mur" , method = RequestMethod.GET)
    public ModelAndView handleRequestInternal (HttpServletRequest request  ) throws Exception{
        long pseudo = -1;
        HttpSession session = request.getSession (true);
        String currentLogin = (String)session.getAttribute("login");
        if( currentLogin!= null){
            
            IdentityEntity identity = identityService.findIdentity(currentLogin);
            if(identity != null){           
                pseudo = identity.getId();
            }
        }
        return this.handleRequestInternal(request,pseudo);
    }
}
