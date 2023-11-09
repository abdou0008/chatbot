package com.example.controleur;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.dao.ContactRepository;
import com.example.entities.Contact;

import java.util.List;


@Controller
@AllArgsConstructor
public class ContactControleur {

    private ContactRepository contactRepository;

    
    @GetMapping("/contact")
    @ResponseBody
    public List<Contact> listContacts(){
        return contactRepository.findAll();

    }

    @GetMapping("/delete")
    public String delete(Long id){
        contactRepository.deleteById(id);;
        return "redirect:/contact";

    }
    @GetMapping("/formContact")
    public String formContact(Model model){
        model.addAttribute("contact", new Contact());
        return "categorieTemplate/formCategorie";
    }
    @PostMapping(path = "/save")
    public Contact save(Contact contact){
        return contactRepository.save(contact); 
    }
    // @GetMapping("/admin/editContact")
    // public String editContact(Long id){
    //     Contact contact=contactRepository.findById(id);
    //     return conatct;
    // }
}
