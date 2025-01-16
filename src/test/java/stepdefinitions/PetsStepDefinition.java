package stepdefinitions;

import Questions.GeneralQuestion;
import Tasks.Pets.CreatePets;
import Tasks.Pets.InvalidModify;
import Tasks.Pets.ModifyPets;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.http.HttpStatus;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PetsStepDefinition {

    @When("the administrator sends a request to create a new pet")
    public void theAdministratorSendsARequestToCreateANewPet() {
        theActorInTheSpotlight().attemptsTo(CreatePets.withPayloadFrom("src/main/java/utils/Payloads/CreatePet.json"));
    }

    @When("the administrator sends a request to modify pet")
    public void theAdministratorSendsARequestToModifyPet() {
        theActorInTheSpotlight().attemptsTo(ModifyPets.valid());
    }


    @When("the administrator sends a request to modify pet invalid")
    public void theAdministratorSendsARequestToModifyPetInvalid() {
        theActorInTheSpotlight().attemptsTo(InvalidModify.user());
    }

    @Then("the response status code should be a error")
    public void theResponseStatusCodeShouldBeAError() {
        theActorInTheSpotlight().should(seeThat(GeneralQuestion.is(HttpStatus.SC_BAD_REQUEST)));
    }
}
