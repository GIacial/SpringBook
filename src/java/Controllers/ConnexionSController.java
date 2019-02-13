/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Services.IdentificationService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jérémy
 */

@Controller
public class ConnexionSController {
    
    @Autowired
    private IdentificationService identificationService;
    
    @RequestMapping (value="index" , method = RequestMethod.GET)
    public String init(){
        return "index";
    }
    
    @RequestMapping(value="connexion" , method = RequestMethod.POST)
    public ModelAndView connexion (HttpServletRequest request , HttpServletResponse responce) throws Exception{
        String result = "Erreur d'identification";    
        ModelAndView mv = null;
        String login = request.getParameter("login");
        String mdp   = request.getParameter("password");       
        HttpSession session = request.getSession (true);
        

        if(identificationService.isCorrectIdentifier(login, mdp)){
            //debug
            result = "Bienvenue " + login;
            //session
            session.setAttribute("login" , login);
            //redirect
            responce.sendRedirect("mur.htm");
        }
        else{
            mv = new ModelAndView("index");
            mv.addObject("alert", result);
            //on vide la session(sert au debug tant que pas de deco)
            session.setAttribute("login" , null);
        }
        return mv;
    }
    
    @RequestMapping(value="deconnexion" , method = RequestMethod.GET)
    public ModelAndView deconnexion (HttpServletRequest request , HttpServletResponse responce) throws Exception{
               
        HttpSession session = request.getSession (true);
        //on vide la session
        session.setAttribute("login" , null);
        return new ModelAndView("index");
    }
    
    
}
