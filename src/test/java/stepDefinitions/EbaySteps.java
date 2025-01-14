package stepDefinitions;

import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.EbayPage;
public class EbaySteps {
	
	EbayPage ebayPage;


	@Given("User enters {string} in search field")
	public void user_enters_in_search_field(String string) {
		ebayPage = new EbayPage(Hooks.driver);

		ebayPage.enterSearchText(string);
	}

	@Given("User click on the search button")
	public void user_click_on_the_search_button() {

		ebayPage.clickSearchButton();
	}

	@Given("User clicks on the link")
	public void user_clicks_on_the_link() {
		String originalTab = Hooks.driver.getWindowHandle();

		ebayPage.clickFirstBookLink();

		for (String handle : Hooks.driver.getWindowHandles()) {
			if (!handle.equals(originalTab)) {
				Hooks.driver.switchTo().window(handle);
				break;
			}
		}
	}

	@Given("User clicks on AddToCart button")
	public void user_clicks_on_add_to_cart_button() {

		ebayPage.clickAddToCart();

	}

	@Given("users verifies that the checkout page is visible")
	public void users_verifies_that_the_checkout_page_is_visible() {

		Assert.assertEquals(ebayPage.getCartPageHeadingText(),"Shopping cart","cart page is not displayed");


	}

	@Then("user validate the cart image is updated")
	public void user_validate_the_cart_image_is_updated() {
		Assert.assertEquals(ebayPage.cartImage(),"1","cart image is not updated properly");

	}


	@Then("user verifies the cart has been updated")
	public void user_verifies_the_cart_has_been_updated() {

		Assert.assertEquals(ebayPage.selectQuantity(),1,"cart has not added correct quantity");
	}
	
	
	

}
