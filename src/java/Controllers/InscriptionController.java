/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Services.InscriptionService;
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
public class InscriptionController {
    
    @Autowired
    private InscriptionService inscriptionService;
    
    @RequestMapping (value="inscription" , method = RequestMethod.GET)
    public ModelAndView getFormulaireInscription () throws Exception{

        return new ModelAndView("inscription");
    }
    
    @RequestMapping (value="inscription" , method = RequestMethod.POST)
    public ModelAndView inscription (HttpServletRequest request , HttpServletResponse responce) throws Exception{
        
        String login = request.getParameter("login");
        String mdp   = request.getParameter("password");
        String pseudo = request.getParameter("pseudo");     
        HttpSession session = request.getSession (true);
        
        ModelAndView mv = null;
        
        if(inscriptionService.inscription(login, mdp, pseudo)){
            //connexion auto lors de l'inscription
            session.setAttribute("login" , login);
            //redirect
            responce.sendRedirect("mur.htm");
        }
        else{
           mv = new ModelAndView("index");
           mv.addObject("alert", "Erreur lors de l'inscription");
        }
        
         
        return mv;
    }
}
