package stepdefinitions;

import Questions.GeneralQuestion;
import Tasks.Users.CreateUsers;
import Tasks.Users.PrepareUserCreation;
import Tasks.Users.ReadUser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.http.HttpStatus;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UsersStepDefinition {

    @Given("the administrator wants to access the user creation API")
    public void theAdministratorWantsToAccessTheUserCreationAPI() {
        theActorInTheSpotlight().attemptsTo(PrepareUserCreation.request());
    }


    @When("the administrator sends a request to create a new user")
    public void theAdministratorSendsARequestToCreateANewUser() {
        theActorInTheSpotlight().attemptsTo(CreateUsers.valid());

    }
    @Then("the response status code should be success")
    public void theResponseStatusCodeShouldBeSuccess() {
        theActorInTheSpotlight().should(seeThat(GeneralQuestion.is(HttpStatus.SC_OK)));
    }




    @When("the administrator wants to retrieve users")
    public void theAdministratorWantsToRetrieveUsers(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(ReadUser.valid(dataTable));

    }




    @When("the administrator consults non-created user")
    public void theAdministratorConsultsNonCreatedUser(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(ReadUser.valid(dataTable));
    }

    @Then("the response status code should be fail")
    public void theResponseStatusCodeShouldBeFail() {
        theActorInTheSpotlight().should(seeThat(GeneralQuestion.is(HttpStatus.SC_NOT_FOUND)));
    }


}
