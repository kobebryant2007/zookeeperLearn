import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

/**
 * Created by liangnan on 17-1-12.
 */
public class CreateOrder {
    @Given("^create order$")
    public void createOrder() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(1, 1);
    }

    @When("^send request success$")
    public void sendRequestSuccess() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^notify success$")
    public String notifySuccess(){
        // Write code here that turns the phrase above into concrete actions
        return "success";
    }


}
