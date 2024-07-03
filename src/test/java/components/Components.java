package components;

import org.apache.http.HttpStatus;
import org.json.JSONObject;
import system.RestAssuredBase;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class Components {

    private String urlDelete;

    public Components(String url) {
        RestAssuredBase.setup(url);
        urlDelete = url;
    }

    public void endpointRetorno() {
        // Imprime o que recebeu
        //given().when().get().then().log().all();
        get().then().log().all();
    }

    public void validarPath(String path, String valor) {
        // Verifica se tem no body o first_name = George
        //given().when().get().then().body(path, is(valor));
        get().then().body(path, is(valor));
    }

    public void validarSchema() {
        // Verifica o contrato
        //given().when().get().then().body(matchesJsonSchemaInClasspath("jsonValidation.json"));
        get().then().body(matchesJsonSchemaInClasspath("jsonValidation.json"));
    }

    public void postEndpoint() {
        JSONObject json = new JSONObject();
        json.put("name", "Gustavo");
        json.put("job", "music");

        // Cria e verifica se o retorno contem createdAt
        given().body(json).when().post().then().statusCode(HttpStatus.SC_CREATED)
                .body(containsString("createdAt"));
    }

    public void updateEndpoint() {
        JSONObject json = new JSONObject();
        json.put("name", "Gustavo02");
        json.put("job", "gospel_music");

        // Cria e verifica se o retorno contem createdAt
        given().body(json).when().put().then().statusCode(HttpStatus.SC_OK)
                .body(containsString("updatedAt"));
    }

    public void deleteEndpoint() {
        // Cria e verifica se o retorno contem createdAt
        when().delete(urlDelete).then().statusCode(HttpStatus.SC_NO_CONTENT);
    }

}
