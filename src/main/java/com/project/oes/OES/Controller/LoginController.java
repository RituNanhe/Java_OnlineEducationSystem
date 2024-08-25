package com.project.oes.OES.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.oes.OES.Model.Contact;
import com.project.oes.OES.Model.Login;

@Controller
public class LoginController {
	@Autowired
	SessionFactory sf;
	
	@RequestMapping("loginpage")
	public String loginpage() {
		return "login";
	}
	
	@RequestMapping("loginp")
	public String loginp(Login login, Model model) {
		
		Session s=sf.openSession();
		Login log = s.get(Login.class, login.getPassword());
	
		String page= "login";
		String msg=null;
		
		if (log!= null) {
		if(login.getUsername().equals(log.getUsername())) {
			msg="Welcome";
			page="home";
			}
		}else {	
			msg = "Invalid User and Password";
		}
		
		model.addAttribute("msg", msg);
		return page;	
	}
	
	@RequestMapping("createaccount")
	public String createaccount() {
		return "createAccount";
	}
	
	@RequestMapping("createaccountdata") 
	public String createaccountdata(Login login) {

		Session s = sf.openSession();
		Login log = s.get(Login.class, login.getPassword());
		String page = "login";
		String msg = null;

		if (log!= null) {
			if (login.getUsername().equals(log.getUsername())) {
				msg = "Already Register User and Password";
			}
		} else {
			Transaction t = s.beginTransaction();
			s.save(login); 
			t.commit();
		}

		return "createAccount"; 
	} 

	@RequestMapping("homepage")
	public String homepage() {
		return "home";
	}
	
	@RequestMapping("servicepage")
	public String servicepage() {
		return "service";
	}

	
	@RequestMapping("aboutpage")
	public String aboutpage() {
		return "about";
	}
	
	@RequestMapping("contactpage")
	public String contactpage() {
		return "contact";
	}
	
	@RequestMapping("contactdata") 
	public String contactdata(Contact contact) {
		Session s = sf.openSession();

		Contact con = s.get(Contact.class, contact.getMobile()); 
		String page = "login";
		String msg = null;

		if (con != null) {
			if (contact.getEmail().equals(con.getEmail())) {
				msg = "Already Register Email and Mobile";
			}
		} else {
			Transaction t = s.beginTransaction();
			s.save(contact); 
			t.commit();
		}

		return "contact"; 
	
	}
}
