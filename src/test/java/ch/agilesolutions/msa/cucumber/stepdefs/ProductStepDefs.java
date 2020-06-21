package ch.agilesolutions.msa.cucumber.stepdefs;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ch.agilesolutions.msa.web.rest.ProductResource;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDefs extends StepDefs {

    @Autowired
    private ProductResource productResource;

    private MockMvc restProductMockMvc;

    @Before
    public void setup() {
        this.restProductMockMvc = MockMvcBuilders.standaloneSetup(productResource).build();
    }

    @When("I search product {int}")
    public void i_search_product(int productId) throws Throwable {
        actions = restProductMockMvc.perform(get("/api/categories/" + productId)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("the product is found")
    public void the_product_is_found() throws Throwable {
        actions
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Then("its description is {string}")
    public void his_last_name_is(String lastName) throws Throwable {
        actions.andExpect(jsonPath("$.description").value(lastName));
    }

}