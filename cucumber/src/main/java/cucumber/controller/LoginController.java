package cucumber.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cucumber.dto.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody User user) {
		log.info("### USER::: ",user.toString());
		String response = "El usuario: " + user.getIdUser() + " tiene acceso";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "login/monoproducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> isMonoproducto(@RequestBody User user) {
		log.info("### USER::: ",user.toString());
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
