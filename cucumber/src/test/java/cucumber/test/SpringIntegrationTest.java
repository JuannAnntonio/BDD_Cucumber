package cucumber.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cucumber.Application;
import cucumber.util.ObjetctToJson;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;

@CucumberContextConfiguration
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@Slf4j
public class SpringIntegrationTest {

	@Autowired
	protected RestTemplate restTemplate;

	protected <T> ResponseEntity<T> executePost(String url, Object entity, Class<T> response) {
		return execute(url, HttpMethod.POST, entity, response);
	}

	protected <T> ResponseEntity<T> executeGetgetResponse(String url, Class<T> response) {
		return execute(url, HttpMethod.GET, null, response);
	}

	private <T> ResponseEntity<T> execute(String url, HttpMethod method, Object request, Class<T> response) {
		String valueRequest = request != null ? ObjetctToJson.convert(request) : null;
		ResponseEntity<String> res = restTemplate.exchange(url, method,
				new HttpEntity<>(valueRequest, getHttpHeaders()), String.class);

		log.info("BODY:: ", res.getBody());
		log.info("STATUS_CODE:: ", res.getStatusCode());
		return new ResponseEntity<>(ObjetctToJson.convertToObject(res.getBody(), response), res.getStatusCode());

	}

	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/json; charset=UTF-8");
		headers.add("Accept", "application/json");
		return headers;
	}

}