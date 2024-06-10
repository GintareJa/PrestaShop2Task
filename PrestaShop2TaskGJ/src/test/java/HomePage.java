import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;


    //konstruktoriai
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //lokatoriai
    public By searchBox = By.cssSelector("input[name='s']");
    public By productLink = By.linkText("Hummingbird Printed T-Shirt");
    public By openProduct = By.cssSelector(".product-title a");
    public By addToWishlist = By.cssSelector(".wishlist-button-product .material-icons");
    public By wishlistMessage = By.cssSelector(".modal-text");
    public By cancelWishList = By.cssSelector(".show .btn-secondary");
    public By selectSize = By.cssSelector("select[name='group[1]']");
    public By addToCart = By.cssSelector(".add-to-cart.btn.btn-primary");
    public By cartMessage = By.xpath("/html//h4[@id='myModalLabel']");
    public By clickCheckoutButton = By.cssSelector(".modal-body .btn.btn-primary");


    //    metodai
    public void searchProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchBox).submit();
    }

    public String getProductTitle() {
        WebElement productLinkElement = driver.findElement(productLink);
        return productLinkElement.getText();
    }

    public void setOpenProduct() {
        driver.findElement(openProduct).click();
    }

    public void setAddToWishlist() {
        driver.findElement(addToWishlist).click();
    }

    public String getWishlistMessage() {
        WebElement wishlistMessageElement = driver.findElement(wishlistMessage);
        return wishlistMessageElement.getText();
    }

    public void setCancelWishlist() {
        driver.findElement(cancelWishList).click();
    }

    public void setSelectSize(String size) {
        driver.findElement(selectSize).sendKeys(size);
    }

    public void setAddToCart() {
        driver.findElement(addToCart).click();
    }

    public String getCartMessage() {
        WebElement carSuccessfullyMessage = driver.findElement(cartMessage);
        return carSuccessfullyMessage.getText();
    }

    public void proceedToCheckout() {
        driver.findElement(clickCheckoutButton).click();
    }
}

//        public String getCartProductName() {
//            WebElement cartProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-product-name")));
//            return cartProduct.getText();
//        }
//
//        public String getCartProductSize() {
//            WebElement cartProductSize = driver.findElement(By.cssSelector(".cart-product-size"));
//            return cartProductSize.getText();
//        }
//

