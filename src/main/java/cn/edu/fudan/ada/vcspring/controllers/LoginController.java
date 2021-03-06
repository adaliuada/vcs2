package cn.edu.fudan.ada.vcspring.controllers;

import cn.edu.fudan.ada.vcspring.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private IdentityDao identityDao;

    @RequestMapping("/login")
    public String login(@RequestParam(value="id") String id, @RequestParam(value="password")String password,Model model) {
        Identity identity=identityDao.findByIdAndPassword(id,password);
        if (identity==null){
            return "bye";
        }
        else {
            return "redirect:/"+identity.getRole()+"/"+identity.getId();
        }
    }

}
