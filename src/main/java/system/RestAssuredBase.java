package system;

import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.*;

public class RestAssuredBase {

    public static void setup(String url) {
        // Quando a validacao der erro ele imprime
        enableLoggingOfRequestAndResponseIfValidationFails();

        baseURI = url;
        // Verifica se está OK a url fazendo uma chamada
        given().when().get().then().assertThat().statusCode(HttpStatus.SC_OK);
    }

}
