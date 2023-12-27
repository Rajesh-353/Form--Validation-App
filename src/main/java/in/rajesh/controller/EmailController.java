package in.rajesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.rajesh.mailForm.EmailForm;


@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/mailform")
	public String showEmail(Model model) {

		model.addAttribute("EmailForm", new EmailForm());
	
		return "index";	
	}
	
	@PostMapping("/emailSent")
	public String sendEmail( EmailForm emailForm) {
		
		SimpleMailMessage message =new SimpleMailMessage();
		
		message.setTo(emailForm.getTo());
		message.setSubject(emailForm.getSubject());
		message.setText(emailForm.getBody());
		
		mailSender.send(message);
		
     return "success";		
		
		
	}
	

}
