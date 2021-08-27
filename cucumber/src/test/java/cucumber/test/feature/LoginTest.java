package cucumber.test.feature;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import cucumber.dto.User;
import cucumber.test.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginTest extends SpringIntegrationTest {

	private final String PATH = "http://localhost:9090/";

	@When("el cliente ingrese credenciales")
	public void el_cliente_ingrese_credenciales() {
		User usuario = User.builder().idUser("001").password("p455w0rd").build();

		ResponseEntity<String> response = executePost(PATH + "login", usuario, String.class);
		log.info("### BODY: ", response.getBody());
		assertThat(response.getBody(), true);

	}

	@Then("se valida que sea un cliente monoproducto")
	public void se_valida_que_sea_un_cliente_monoproducto() {
		User usuario = User.builder().idUser("001").password("p455w0rd").build();

		executePost(PATH + "login/monoproducto", usuario, String.class);
	}

	@And("recibe estatus (\\d+)$")
	public void recibe_estatus(Integer statusCode) throws IOException {
		User usuario = User.builder().idUser("001").password("p455w0rd").build();

		ResponseEntity<String> response = executePost(PATH + "login/monoproducto", usuario, String.class);
		assertThat(response.getStatusCode().value(), is(statusCode));
	}

}
