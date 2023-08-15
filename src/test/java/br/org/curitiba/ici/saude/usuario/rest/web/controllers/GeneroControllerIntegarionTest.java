


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
import br.org.curitiba.ici.saude.usuario.entity.view.GeneroPesquisaView;
import br.org.curitiba.ici.saude.usuario.rest.web.request.GeneroAtualizacaoRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.request.GeneroNovoRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.response.GeneroResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


@TestMethodOrder(OrderAnnotation.class)
@ActiveProfiles("test")
@SpringBootTest(classes = AlmoxarifadoApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT)
class GeneroControllerIntegarionTest {
  @LocalServerPort
  private int port;

  private String url = "http://localhost:%s/generos";
  private static Integer cdGeneroCriado = null;

  @BeforeEach
  void beforeEach() {
    url = String.format(url, port);
  }

  @Order(1)
  @Test
  void deveSalvarUmNovoGenero() throws Exception {
    GeneroNovoRequest request = Instancio.create(GeneroNovoRequest.class);

    Response httpResponse = given().contentType(ContentType.JSON).body(request).when().post(url);
    httpResponse.then().statusCode(HttpStatus.CREATED.value()).log().ifError();

    cdGeneroCriado = httpResponse.getBody().as(Integer.class).intValue();

  }

  @Order(2)
  @Test
  void deveAtualizarUmGenero() throws Exception {
    GeneroAtualizacaoRequest request = Instancio.create(GeneroAtualizacaoRequest.class);

    String urlPut = url + "/" + cdGeneroCriado;
    given().contentType(ContentType.JSON).body(request).when().put(urlPut).then()
        .statusCode(HttpStatus.OK.value()).log().ifError();
  }

  @Order(3)
  @Test
  void deveRetornarUmGenero() throws Exception {
    String urlGet = url + "/" + cdGeneroCriado;
    Response httpResponse = given().contentType(ContentType.JSON).when().get(urlGet);
    httpResponse.then().statusCode(HttpStatus.OK.value()).log().ifError();
    GeneroResponse fabricanteResponse = httpResponse.getBody().as(GeneroResponse.class);
    assertEquals(cdGeneroCriado, fabricanteResponse.getCdGenero());
  }
  
  @Order(4)
  @Test
  void deveEncontrarUmaGeneroParaPrimeiraPaginaDeTamanho1() {
    List<GeneroPesquisaView> request =
        given().contentType(ContentType.JSON).when().queryParam("page", 0).queryParam("size", 1)
            .get(url).then().extract().jsonPath().get("content");
    Assertions.assertEquals(1, request.size());
  }

  @Order(5)
  @Test
  void deveDeletarUmGenero() throws Exception {
    String urlDelete = url + "/" + cdGeneroCriado;
    given().contentType(ContentType.JSON).when().delete(urlDelete).then()
        .statusCode(HttpStatus.OK.value()).log().ifError();
  }	
 
}

