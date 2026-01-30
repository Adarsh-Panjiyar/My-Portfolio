package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.portfolio.dto.ContactForm;
import com.portfolio.entities.ContactMessage;
import com.portfolio.repository.ContactMessageRepo;

@Controller
public class HomeController {

    private final ContactMessageRepo contactRepository;

    public HomeController(ContactMessageRepo contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/contact")
    public String handleContact(ContactForm form, org.springframework.ui.Model model) {

        ContactMessage message = new ContactMessage();
        message.setName(form.getName());
        message.setEmail(form.getEmail());
        message.setPhone(form.getPhone());
        message.setSubject(form.getSubject());
        message.setMessage(form.getMessage());

        contactRepository.save(message);

        model.addAttribute(
            "successMessage",
            "Thank you! Your message has been sent successfully."
        );

        return "home"; // ✅ SAME PAGE, NO REDIRECT
    }



    
}
