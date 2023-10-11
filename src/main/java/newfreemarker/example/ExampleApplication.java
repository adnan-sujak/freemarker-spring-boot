package newfreemarker.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication //identifies main application - which class it should run
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}
}
	@Controller
	class WebController{

		private List<Users> users = new ArrayList<>(); //data structure in which the users are stored
		@Autowired //injecting userrepo using @Autowired
		private UserRepository userrepository;
		@GetMapping("/") //binds home method to handle HTTP get requests at the root URL
		public String home(Model model) { //model object is an interface that defines methods to add and retrieve attrivutes (Key- value pairs_
			model.addAttribute("message", "Welcome to FreeMarker w/ Spring Boot");
			model.addAttribute("users", userrepository.findAll());
			return "hello"; //when this is rendered, it will gain access tp these attributes

		}

		@PostMapping("/addUser") //handles HTTP post requests at the /addUser URL. This is triggered when a form on the frontend submits data
		public String addUser(@RequestParam String name, @RequestParam String email) {
			Users user = new Users(name, email);
			userrepository.save(user);
			return "redirect:/";
		}
		}




