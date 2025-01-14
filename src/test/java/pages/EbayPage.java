package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EbayPage extends BasePage {

	public EbayPage(WebDriver d) {
		super(d);
		PageFactory.initElements(d, this);
	}
	
	
	@FindBy (xpath = "//input[@id='gh-ac']")
	private WebElement searchField;
	
	
	@FindBy (xpath = "//input[@id='gh-btn']")
	private WebElement searchButton;
	

	@FindBy (xpath = "(//a[@class='s-item__link' and contains(@href, 'ebay.com')])[3]")
	private WebElement bookLink;

	//a[@id='atcBtn_btn_1']
	@FindBy (xpath = "//a[@id='atcBtn_btn_1']")
	private WebElement addToCartLink;

	@FindBy (xpath = "//select[@data-test-id='qty-dropdown']")
	private WebElement quantitySelection;

	@FindBy (xpath="//h1[text()='Shopping cart']")
	private WebElement cartPageHeading;


	@FindBy (xpath="//i[@id='gh-cart-n']")
	private WebElement cartImage;

	// Method to enter text in the search field
	public void enterSearchText(String text) {
		searchField.clear();
		searchField.sendKeys(text);
	}

	// Method to click on the search button
	public void clickSearchButton() {
		searchButton.click();
	}

	// Method to click on the first book link
	public void clickFirstBookLink() {
		if(bookLink.isEnabled())
		{
			bookLink.click();
		}

	}

	// Method to click on the "Add to Cart" link
	public void clickAddToCart() {
		addToCartLink.click();
	}

	public String cartImage(){
		String cartValue = (cartImage.getText());
		return cartValue;
	}

	// Method to select a quantity from the dropdown
	public int selectQuantity() {
		 int value = Integer.parseInt(quantitySelection.getAttribute("value"));
		 return value;
	}

	// Method to verify if the cart page is displayed
	public boolean isCartPageDisplayed() {
		return cartPageHeading.isDisplayed();
	}

	// Method to get the heading text from the cart page
	public String getCartPageHeadingText() {
		return cartPageHeading.getText();
	}

	
}
