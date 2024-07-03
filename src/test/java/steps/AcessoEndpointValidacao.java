package steps;

import components.Components;
import io.cucumber.java.en.*;

public class AcessoEndpointValidacao {

    Components components;

    @Given("que seja acessado a api {string}")
    public void queSejaAcessadoAApi(String url) {
        components = new Components(url);
        components.endpointRetorno();
    }

    @When("for validado o valor do campo name que seja igua a {string}")
    public void forValidadoOValorDoCampoNameQueSejaIguaA(String valor) {
        components.validarPath("data.first_name", valor);
    }

    @Then("efetuado o teste de contrato ou schema")
    public void efetuadoOTesteDeContratoOuSchema() {
        components.validarSchema();
    }

}
