/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Database.Entity.IdentityEntity;
import Database.Entity.NotificationEntity;
import Database.Entity.PublicationEntity;
import Services.AmitieService;
import Services.IdentityService;
import Services.NotificationService;
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
    
    
    @Autowired
    private AmitieService amitieService;
     
    @Autowired
    private NotificationService notificationService;
    
    @RequestMapping (value="amimur" , method = RequestMethod.GET)
    public ModelAndView handleRequestInternal (HttpServletRequest request , @RequestParam long pseudo) throws Exception{
        String result = "Erreur d'identification";    
        ModelAndView mv = null;      
        HttpSession session = request.getSession (true);
        String currentLogin = (String) session.getAttribute("login");

        if(currentLogin != null){
            //ModelVue
            mv = new ModelAndView("mur");
            long keyIdentity = pseudo;
            IdentityEntity identity = identityService.findIdentity(keyIdentity);
            IdentityEntity identityLogin = identityService.findIdentity(currentLogin) ;
            if(identity != null){     
                
                List<PublicationEntity> pubs = publicationService.getAllPublication(identity);
                Collections.reverse( pubs);
                List<NotificationEntity> notifs = notificationService.getMyNotification(identityLogin);
                Collections.reverse(notifs);
                
                mv.addObject("identity", identity);
                mv.addObject("myPage", identityLogin.equals(identity));
                mv.addObject("ami" , amitieService.isMyFriends(identityLogin, identity) );
                mv.addObject("key",keyIdentity);
                mv.addObject("notifs",notifs);
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
                if(identity.equals(identityLogin) || this.amitieService.isMyFriends(identityLogin, identity) ){//ma page ou celle d'un ami
                    //on enregistre  
                    String msg = request.getParameter("msg");
                    this.publicationService.createPublication(msg, request.getParameter("media"),identityLogin,identity);
                    this.verifItentification(msg, identityLogin, identity);
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
    
    @RequestMapping (value="addami" , method = RequestMethod.POST)
    public ModelAndView ajouterAmi (HttpServletRequest request ) throws Exception{
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
                if(identity.equals(identityLogin) || this.amitieService.isMyFriends(identityLogin, identity)){//ma page ou celle d'un ami
                    mv = this.handleRequestInternal(request, key);
                    mv.addObject("alert","Vous etes déjà ami");
                     
                }
                else{
                    //ajouter en ami 
                    amitieService.addAmi(identityLogin, identity);
                    this.notificationService.createNotification(identityLogin.getPseudo() + " vous a ajouté comme amis", identityLogin , identity);
                    //puis retourne sur la page
                    mv = this.handleRequestInternal(request, key);
                }
            }
        }
        return mv;
    }
    
    private void verifItentification(String msg , IdentityEntity auteur , IdentityEntity mur){
        
        String[] mots = msg.split(" ");
        for(String mot : mots){
            
            if(mot.startsWith("#")){
                List<IdentityEntity> identifPeople  = this.identityService.findByName(mot.substring(1));
                for(IdentityEntity i : identifPeople){
                    if(this.amitieService.isMyFriends(auteur, i)){
                        //identification seulement si mon ami
                        this.notificationService.createNotification(auteur.getPseudo()+ " vous a identifié dans une publication sur le mur de " + mur.getPseudo(), auteur, i);
                    }
                }
            }
        }
    }
}
