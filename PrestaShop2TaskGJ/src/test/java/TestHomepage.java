
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestHomepage extends BaseTest {
    @Test
    public void testProductsName() throws IOException {
        List<String[]> records = TestDataReader.readCSVData("src/test/java/resources/products.csv");
        for (String[] record : records) {
            String productName = record[0];
            String size = record[1];

            HomePage homePage = new HomePage(driver);
            homePage.searchProduct(productName);
            assertEquals(productName, homePage.getProductTitle(), "Product name does not match");
        }
    }

    @Test
    public void testAddToWishlist() throws IOException {
        List<String[]> records = TestDataReader.readCSVData("src/test/java/resources/products.csv");
        for (String[] record : records) {
            String productName = record[0];
            String size = record[1];

            HomePage homePage = new HomePage(driver);
            homePage.searchProduct(productName);
            homePage.setOpenProduct();
            homePage.setAddToWishlist();
            assertTrue(homePage.getWishlistMessage().contains("You need to be logged in to save products in your wishlist."), "message is correct");
        }
    }

    @Test
    public void testAddToCart() throws IOException, InterruptedException {
        List<String[]> records = TestDataReader.readCSVData("src/test/java/resources/products.csv");
        for (String[] record : records) {
            String productName = record[0];
            String size = record[1];

            HomePage homePage = new HomePage(driver);
            driver.get("http://192.168.88.64/women/2-9-brown-bear-printed-sweater.html#/1-size-s");

            homePage.setAddToWishlist();
            homePage.setCancelWishlist();
            homePage.setSelectSize(size);
            homePage.setAddToCart();
            assertEquals("Product successfully added to your shopping cart".contains(homePage.getCartMessage()), "Wishlist message is not correct");
        }
    }

    @Test
    public void testCheckOut() throws IOException, InterruptedException {
        List<String[]> records = TestDataReader.readCSVData("src/test/java/resources/products.csv");
        for (String[] record : records) {
            String productName = record[0];
            String size = record[1];

            HomePage homePage = new HomePage(driver);
            driver.get("http://192.168.88.64/women/2-9-brown-bear-printed-sweater.html#/1-size-s");

            homePage.setSelectSize(size);
            homePage.setAddToCart();
            Thread.sleep(2000);
            homePage.proceedToCheckout();
        }
    }
}
