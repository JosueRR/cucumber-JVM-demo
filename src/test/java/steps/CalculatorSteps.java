package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class CalculatorSteps {
    private int total;
    private Calculator calculator = new Calculator();

    @Given("I have entered {int} into the calculator")
    public void i_have_entered_into_the_calculator(int number) {
        calculator.enter(number);
    }

    @When("I press add")
    public void i_press_add() {
        calculator.add();
        total = calculator.getResult();
    }

    @Then("the result should be {int} on the screen")
    public void the_result_should_be_on_the_screen(int result) {
        assertEquals(result, total);
    }
}

class Calculator {
    private int result = 0;
    private int number1 = 0;
    private int number2 = 0;

    public void enter(int number) {
        if (number1 == 0) {
            number1 = number;
        } else {
            number2 = number;
        }
    }

    public void add() {
        result = number1 + number2;
    }

    public int getResult() {
        return result;
    }
}
