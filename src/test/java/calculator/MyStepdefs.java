package calculator;

import calculator.Calculator;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
public class MyStepdefs {
    private Calculator calculator;
    private int value;
    private String operation;
    private int result;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("^One input value and operation, (-?\\d+) and (sqr|rvs)$")
    public void oneInputValueAndOperation(int arg0, String arg1) {
        value = arg0;
        operation = arg1;
    }

    @When("^I do the operation on the value$")
    public void iDoTheOperationOnTheValue() {
        if (operation.equals("sqr")){
            result = calculator.sqrt(value);
        }
        else if (operation.equals("rvs")) {
            result = calculator.reverse(value);
        }
        System.out.print(result);
    }

    @Then("^I expect the result (-?\\d+)$")
    public void iExpectTheResult(int arg0) {
        Assert.assertEquals(arg0, result);
    }
}