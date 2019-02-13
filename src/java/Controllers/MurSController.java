/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    
    @RequestMapping (value="amimur" , method = RequestMethod.GET)
    public ModelAndView handleRequestInternal (HttpServletRequest request , HttpServletResponse responce , @RequestParam String pseudo) throws Exception{
        String result = "Erreur d'identification";    
        ModelAndView mv = null;      
        HttpSession session = request.getSession (true);
        

        if(session.getAttribute("login") != null){
            //ModelVue
            mv = new ModelAndView("mur");
            mv.addObject("pseudo", pseudo);
        }
        else{
            mv = new ModelAndView("index");
            mv.addObject("alert", result);
        }
        return mv;
    }
    
    @RequestMapping (value="mur" , method = RequestMethod.GET)
    public ModelAndView handleRequestInternal (HttpServletRequest request , HttpServletResponse responce ) throws Exception{
        
        return this.handleRequestInternal(request, responce,"pseudo");
    }
}
