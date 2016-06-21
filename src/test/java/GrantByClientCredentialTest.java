import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.fincil.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0", "enable.security=true"})
public class GrantByClientCredentialTest {
    
	@Value("${local.server.port}")
	private int port;

	@SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void getJwtTokenByTrustedClient() throws JsonParseException, JsonMappingException, IOException {
        ResponseEntity<String> response = new TestRestTemplate("trusted-app", "secret").postForEntity("http://localhost:" + port + "/oauth/token?client_id=trusted-app&grant_type=client_credentials", null, String.class);
        String responseText = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        HashMap jwtMap = new ObjectMapper().readValue(responseText, HashMap.class);
        
        assertEquals("bearer", jwtMap.get("token_type"));
        assertEquals("read write", jwtMap.get("scope"));
        assertTrue(jwtMap.containsKey("access_token"));
        assertTrue(jwtMap.containsKey("expires_in"));
        assertTrue(jwtMap.containsKey("jti"));
        String accessToken = (String)jwtMap.get("access_token");
        
        Jwt jwtToken = JwtHelper.decode(accessToken);
        String claims = jwtToken.getClaims();
        HashMap claimsMap = new ObjectMapper().readValue(claims, HashMap.class);
        assertEquals("spring-boot-application", ((List<String>)claimsMap.get("aud")).get(0));
        assertEquals("trusted-app", claimsMap.get("client_id"));
        assertEquals("read", ((List<String>)claimsMap.get("scope")).get(0));
        assertEquals("write", ((List<String>)claimsMap.get("scope")).get(1));
        List<String> authorities = (List<String>)claimsMap.get("authorities");
        assertEquals(1, authorities.size());
        assertEquals("ROLE_TRUSTED_CLIENT", authorities.get(0));
    }
	
	@Test
	public void accessProtectedResourceByJwtToken() throws JsonParseException, JsonMappingException, IOException{
	    ResponseEntity<String> response = new TestRestTemplate().getForEntity("http://localhost:" + port + "/resources/client", String.class);
	    assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
	    
	    response = new TestRestTemplate("trusted-app", "secret").postForEntity("http://localhost:" + port + "/oauth/token?client_id=trusted-app&grant_type=client_credentials", null, String.class);
        String responseText = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        HashMap jwtMap = new ObjectMapper().readValue(responseText, HashMap.class);
        String accessToken = (String)jwtMap.get("access_token");
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+accessToken);
        
        response = new TestRestTemplate().exchange("http://localhost:" + port + "/resources/principal", HttpMethod.GET, new HttpEntity<String>(null, headers), String.class);
        assertEquals("trusted-app", response.getBody());
        
        response = new TestRestTemplate().exchange("http://localhost:" + port + "/resources/trusted_client", HttpMethod.GET, new HttpEntity<String>(null, headers), String.class);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        
        response = new TestRestTemplate().exchange("http://localhost:" + port + "/resources/roles", HttpMethod.GET, new HttpEntity<String>(null, headers), String.class);
        assertEquals("[]", response.getBody());
        
	}

}
