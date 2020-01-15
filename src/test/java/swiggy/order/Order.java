package swiggy.order;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;



public class Order {
	@Test
	public void orderDish() throws Exception {
		//File f = new File("./com.order/apk/swiggy.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY322F84K8");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8");
		cap.setCapability(MobileCapabilityType.APP, "E:\\swiggy-automation\\com.order\\apk\\swiggy.apk");
		cap.setCapability("appPackage", "in.swiggy.android");
		cap.setCapability("appActivity", "in.swiggy.android.activities.HomeActivity");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability(MobileCapabilityType.FULL_RESET, true);
		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		//cap.setCapability("appWaitActivity","in.swiggy.android.activities.NewUserExperienceActivity");
		
		AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);

		// Click on LOGIN Button
		//driver.findElement(By.id("in.swiggy.android:id/item_menu_top_header_restaurant_name3")).click();
		
		// Assert LOGIN Text
		//Assert.assertEquals("LOGIN", driver.findElement(By.id("in.swiggy.android:id/loginCheckHeader")).getText());
		
		// Enter Mobile number
		//driver.findElement(By.xpath("//*[@text='10 digit mobile number']")).sendKeys("7090003800");
		
		// Click Continue button
		//driver.findElement(By.id("in.swiggy.android:id/loginCheckButton")).click();
		
		// Here I am giving a wait of 5 seconds as I need to enter the OTP manually as I don't have static OTP
		//Thread.sleep(5000);
		
		// Click Verify And Proceed Button
		//driver.findElement(By.id("in.swiggy.android:id/forgotPasswordSubmitBtn")).click();
		
		// Click on SET DELIVERY LOCATION
		driver.findElement(By.id("set_location_text")).click();
		
		// Assert Change Button
		Assert.assertEquals("CHANGE", driver.findElement(By.id("in.swiggy.android:id/item_menu_top_header_restaurant_name1")).getText());
		
		// Click on CONFIRM LOCATION
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("in.swiggy.android:id/google_place_search_title_text1")));
		driver.findElement(By.id("in.swiggy.android:id/google_place_search_title_text1")).click();
		System.out.println("Conf Loc Clicked.");
		// Click on X of Add
		driver.navigate().back();
		
		// Click on Search Button
		driver.findElement(By.id("in.swiggy.android:id/bottom_bar_explore_title")).click();
		
		// Serch Input
		driver.findElement(By.id("in.swiggy.android:id/et_search")).sendKeys("chole bhature");
		
		// Select Chole Bhature
		driver.findElement(By.id("in.swiggy.android:id/textName")).click();
		
		// Click on ADD button
		driver.findElement(By.id("in.swiggy.android:id/add_to_cart_item_add_text")).click();
		
		// Click on View Cart
		driver.findElement(By.id("in.swiggy.android:id/dishMenuCartCTA")).click();
		
		// Click on Fee Applicable OK
		driver.findElement(By.id("in.swiggy.android:id/dialog_neutral_layout_text")).click();
		//driver.navigate().back();
		
		// Click on the + icon
		driver.findElement(By.id("in.swiggy.android:id/add_to_cart_item_count_increment")).click();
		
		// Click on Continue
		driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
		
		// Assert ALMOST THERE text
		Assert.assertEquals("ALMOST THERE", driver.findElement(By.id("in.swiggy.android:id/loginCheckHeader")).getText());
		
		// Enter Mobile number
		driver.findElement(By.id("in.swiggy.android:id/loginCheckPhoneNumberEditText")).sendKeys("7090003800");
		
		// Click Continue button
		driver.findElement(By.id("in.swiggy.android:id/loginCheckButton")).click();
		
		// Assert Verify Details Text
		Assert.assertEquals("VERIFY DETAILS", driver.findElement(By.id("in.swiggy.android:id/header_text")).getText());
		
		// Assert the entered mobile number
		Assert.assertEquals("OTP sent to 7090003800", driver.findElement(By.id("in.swiggy.android:id/sub_header_text")).getText());
		
		// OTP verification can be done only if there is a static OTP.
	}
}