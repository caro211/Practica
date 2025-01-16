package stepdefinitions;

import Tasks.Stores.CreateStores;
import Tasks.Stores.DeleteStore;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StoreStepDefinition {

    @When("the administrator sends a request to create a new store")
    public void theAdministratorSendsARequestToCreateANewStore() {
        theActorInTheSpotlight().attemptsTo(CreateStores.valid());
    }

    @When("the administrator sends a request to delete a store")
    public void theAdministratorSendsARequestToDeleteAStore(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(DeleteStore.valid(dataTable));
    }
}
