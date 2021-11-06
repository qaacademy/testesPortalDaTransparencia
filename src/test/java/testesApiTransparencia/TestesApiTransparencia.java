package testesApiTransparencia;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import org.junit.Test;

public class TestesApiTransparencia {
	
	@Test
	public void testePortalDaTransparenciaAuxilioEmergencialPorCidade() {
		String token = "Inserir Token"; 
		
		Map<String, String> queryParams = new HashMap();
		Map<String, String> headerMap = new HashMap();
		String url = "http://api.portaldatransparencia.gov.br"; 
		String path = "/api-de-dados/auxilio-emergencial-beneficiario-por-municipio";
		headerMap.put("chave-api-dados",token);
		queryParams.put("codigoIbge", "3515004"); 
		queryParams.put("mesAno", "202012"); 
		queryParams.put("pagina", "1"); 


		given()
			.headers(headerMap)
			.queryParams(queryParams)
			.log().all()
		.when()
			.get(url+path)
			.then().assertThat()
			.log().all()
			.statusCode(200)
			.body(containsString("KATIA"));
			
			
	}

}
