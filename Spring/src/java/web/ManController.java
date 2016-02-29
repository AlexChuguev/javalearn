/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import dao.ManDAO;
import domain.Man;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Alexey
 */
public class ManController {
     @Autowired
    private ManDAO dao;
    
    @RequestMapping(value = "/mans", method = RequestMethod.GET)
    public String listAllMans(Model model) {
        model.addAttribute("mans", dao.listAllMans());
        return "/man/mans";
}
    
     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getManById(@PathVariable("id") int id, Model model) {
        Man man = dao.getManById(id);
        if (man == null) {
            throw new NotFoundException();
        }
        model.addAttribute("man", man);
        return "/man/man";
    }
    
     @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addMan(Model model) {
        model.addAttribute("title", "Add new Man");
        model.addAttribute("sendURL", "/man/add");
        return "/man/form";
    }
    
     @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMan(@ModelAttribute Man man, Model model) {
        dao.addMan(man);
        return "redirect:/man/list";
    }
    
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editMan(@PathVariable("id") int id, Model model) {
        Man man = dao.getManById(id);
        if (man == null) {
            throw new NotFoundException();
        }
        model.addAttribute("title", "Edit man");
        model.addAttribute("sendURL", "/man/editConfirm");
        model.addAttribute("man", man);
        return "/man/form";
    }
    
     @RequestMapping(value = "/editConfirm", method = RequestMethod.POST)
    public String editMan(@ModelAttribute Man man, Model model) {
        if (dao.editMan(man)) {
            return "redirect:/man/list";
        } else {
            return "redirect:/fail";
        }
    }
    
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deletePet(@PathVariable("id") int id, Model model) {
        Man man =dao.getManById(id);
        if (man == null) {
            throw new NotFoundException();
        }
        model.addAttribute("man", man);
        return "/man/delete";
    }
    
    @RequestMapping(value = "/deleteConfirm", method = RequestMethod.POST)
    public String deleteManConfirm(@PathVariable("id") int id, Model model) {
        if (dao.deleteMan(dao.getManById(id))) {
            return "redirect:/man/mans";
        } else {
            return "redirect:/fail";
        }
    }
    
     @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "Entity with specified id not found")
    public void handleNotFoundException(NotFoundException ex,
            HttpServletResponse response) throws IOException {
    }
}
