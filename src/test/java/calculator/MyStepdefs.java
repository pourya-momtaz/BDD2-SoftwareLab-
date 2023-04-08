package calculator;

import calculator.Calculator;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class MyStepdefs {
    private Calculator calculator;
    private int value;
    private String operation;
    private double result;
    private Exception exception;

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
            try{
                result = calculator.sqrt(value);
                System.out.println(result);
            } catch (Exception e){
                exception = e;
                System.out.println(e.getMessage());
            }
        }
        else if (operation.equals("rvs")) {
            try {
                result = calculator.reverse(value);
                System.out.println(result);
            } catch (Exception e){
                exception = e;
                System.out.println(e.getMessage());
            }
        }

    }

    @Then("^I expect the result (-?\\d*.?\\d+)$")
    public void iExpectTheResult(double arg0) {
        Assert.assertEquals(arg0, result, 0.00001);
    }

    @And("^I expect the exception (.+)$")
    public void iExpectException(String arg0) {
        Assert.assertEquals(arg0 ,exception.getMessage());

    }
}