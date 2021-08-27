package cucumber;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;

public class ResponseResults {

	private ClientHttpResponse theResponse;
	private String body;

	public ResponseResults(final ClientHttpResponse response) throws IOException {
		this.theResponse = response;
		InputStream bodyInputStream = response.getBody();
		StringWriter stringWriter = new StringWriter();
		IOUtils.copy(bodyInputStream, stringWriter, "UTF-8");
		this.body = stringWriter.toString();
	}

	public ClientHttpResponse getTheResponse() {
		return theResponse;
	}

	public String getBody() {
		return body;
	}
}