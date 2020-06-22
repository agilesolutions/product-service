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

	@When("I search product assortment by identifier {int}")
	public void i_search_product_assortment_by_identifier(Integer id) throws Throwable {
		actions = restProductMockMvc.perform(get("/api/products/" + id).accept(MediaType.APPLICATION_JSON));
	}

	@Then("the product assortment is found")
	public void the_product_assortment_is_found() throws Throwable {
		actions.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
	}

	@Then("its assortment title is {string}")
	public void its_assortment_title_is(String title) throws Throwable {
		actions.andExpect(jsonPath("$.title").value(title));
	}

	@When("I search product rating by id {int}")
	public void i_search_product_rating_by_id(Integer id) throws Throwable {
        actions = restProductMockMvc.perform(get("/api/products/" + id)
                .accept(MediaType.APPLICATION_JSON));
	}

	@Then("the product rating is found")
	public void the_product_rating_is_found() throws Throwable {
        actions
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
	}

	@Then("its rating level is {int}")
	public void its_rating_level_is(Integer rating) throws Throwable {
        actions.andExpect(jsonPath("$.rating").value(rating));
	}

}