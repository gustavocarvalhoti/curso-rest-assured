package steps;

import components.Components;
import io.cucumber.java.en.*;

public class CrudApi {

    Components components;

    @Given("que for acessado o endpoint {string}")
    public void queForAcessadoOEndpoint(String url) {
        components = new Components(url);
    }

    @When("seja efetuado o CREATED")
    public void sejaEfetuadoOCREATED() {
        components.postEndpoint();
    }

    @When("seja efetuado o UPDATE")
    public void sejaEfetuadoOUPDATE() {
        components.updateEndpoint();
    }

    @Then("seja efetuado o DELETE")
    public void sejaEfetuadoODELETE() {
        components.deleteEndpoint();
    }

}
