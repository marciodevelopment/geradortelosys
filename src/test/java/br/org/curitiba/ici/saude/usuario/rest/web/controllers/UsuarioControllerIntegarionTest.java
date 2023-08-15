


                	    	    	                    	    	    	                    		    	                    	    	    	            		    	        		    	package error.folder.not.started.with.the.given.src.folder;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
importbr.org.curitiba.ici.saude.AlmoxarifadoApplication;
import br.org.curitiba.ici.saude.usuario.entity.view.UsuarioPesquisaView;
import br.org.curitiba.ici.saude.usuario.rest.web.request.UsuarioAtualizacaoRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.request.UsuarioNovoRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.response.UsuarioResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


@TestMethodOrder(OrderAnnotation.class)
@ActiveProfiles("test")
@SpringBootTest(classes = AlmoxarifadoApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT)
class UsuarioControllerIntegarionTest {
  @LocalServerPort
  private int port;

  private String url = "http://localhost:%s/usuarios";
  private static Integer cdUsuarioCriado = null;

  @BeforeEach
  void beforeEach() {
    url = String.format(url, port);
  }

  @Order(1)
  @Test
  void deveSalvarUmNovoUsuario() throws Exception {
    UsuarioNovoRequest request = Instancio.create(UsuarioNovoRequest.class);

    Response httpResponse = given().contentType(ContentType.JSON).body(request).when().post(url);
    httpResponse.then().statusCode(HttpStatus.CREATED.value()).log().ifError();

    cdUsuarioCriado = httpResponse.getBody().as(Integer.class).intValue();

  }

  @Order(2)
  @Test
  void deveAtualizarUmUsuario() throws Exception {
    UsuarioAtualizacaoRequest request = Instancio.create(UsuarioAtualizacaoRequest.class);

    String urlPut = url + "/" + cdUsuarioCriado;
    given().contentType(ContentType.JSON).body(request).when().put(urlPut).then()
        .statusCode(HttpStatus.OK.value()).log().ifError();
  }

  @Order(3)
  @Test
  void deveRetornarUmUsuario() throws Exception {
    String urlGet = url + "/" + cdUsuarioCriado;
    Response httpResponse = given().contentType(ContentType.JSON).when().get(urlGet);
    httpResponse.then().statusCode(HttpStatus.OK.value()).log().ifError();
    UsuarioResponse fabricanteResponse = httpResponse.getBody().as(UsuarioResponse.class);
    assertEquals(cdUsuarioCriado, fabricanteResponse.getCdUsuario());
  }
  
  @Order(4)
  @Test
  void deveEncontrarUmaUsuarioParaPrimeiraPaginaDeTamanho1() {
    List<UsuarioPesquisaView> request =
        given().contentType(ContentType.JSON).when().queryParam("page", 0).queryParam("size", 1)
            .get(url).then().extract().jsonPath().get("content");
    Assertions.assertEquals(1, request.size());
  }

  @Order(5)
  @Test
  void deveDeletarUmUsuario() throws Exception {
    String urlDelete = url + "/" + cdUsuarioCriado;
    given().contentType(ContentType.JSON).when().delete(urlDelete).then()
        .statusCode(HttpStatus.OK.value()).log().ifError();
  }	
 
}

