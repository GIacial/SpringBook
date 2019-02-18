/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Database.Entity.IdentityEntity;
import Database.Entity.PublicationEntity;
import Services.IdentityService;
import Services.PublicationService;
import java.util.Collections;
import java.util.List;
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
    
    @Autowired
    private PublicationService publicationService;
    
    @RequestMapping (value="amimur" , method = RequestMethod.GET)
    public ModelAndView handleRequestInternal (HttpServletRequest request , @RequestParam long keyIdentity) throws Exception{
        String result = "Erreur d'identification";    
        ModelAndView mv = null;      
        HttpSession session = request.getSession (true);
        String currentLogin = (String) session.getAttribute("login");

        if(currentLogin != null){
            //ModelVue
            mv = new ModelAndView("mur");
            IdentityEntity identity = identityService.findIdentity(keyIdentity);
            IdentityEntity identityLogin = identityService.findIdentity(currentLogin) ;
            if(identity != null){        
                mv.addObject("pseudo", identity.getPseudo());
                mv.addObject("myPage", identityLogin.equals(identity));
                mv.addObject("ami" , false);
                mv.addObject("key",keyIdentity);
                List<PublicationEntity> pubs = publicationService.getAllPublication(identity);
                Collections.reverse( pubs);
                mv.addObject("publications", pubs);
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
    
    @RequestMapping (value="publier" , method = RequestMethod.POST)
    public ModelAndView publier (HttpServletRequest request , HttpServletResponse responce ) throws Exception{
        HttpSession session = request.getSession (true);
        ModelAndView mv = new ModelAndView("index"); 
        mv.addObject("alert", "Vous n'êtes pas connecté");
        String currentLogin = (String)session.getAttribute("login");
        if( currentLogin!= null){
            
            long key =  Integer.parseInt(request.getParameter("key"));
            IdentityEntity identity = identityService.findIdentity(key);
            IdentityEntity identityLogin = identityService.findIdentity(currentLogin) ;
            if(identity != null){           
                //regarder si c'est le sien ou d'un ami
                if(identity.equals(identityLogin)){//ma page ou celle d'un ami
                    //on enregistre   
                    this.publicationService.createPublication(request.getParameter("msg"), identityLogin);
                    
                    //puis retourne sur la page
                    mv = this.handleRequestInternal(request, key);
                }
                else{
                    mv = this.handleRequestInternal(request, key);
                    mv.addObject("alert","Vous n'avez pas les droits pour faire ça");
                }
            }
        }
        return mv;
    }
}
