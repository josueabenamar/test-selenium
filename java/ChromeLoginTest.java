import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;


public class ChromeLoginTest
{
	private String server = "http://localhost:4444/wd/hub";
	private String url = "http://localhost/selenium";

	private WebDriver driver;


	@Before
	public void setUp() throws Exception
	{
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.get(url);
	}

	@Test
	public void testLoginSuccess() throws Exception
	{
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement send = driver.findElement(By.id("send"));

		username.sendKeys("hola");
		password.sendKeys("holamundo");
		send.click();

		assertEquals("Home", driver.getTitle());
	}

	@Test
	public void testLoginError() throws Exception
	{
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement send = driver.findElement(By.id("send"));

		username.sendKeys("hola");
		password.sendKeys("adios");
		send.click();

		assertEquals("Inicio", driver.getTitle());
	}

	@After
	public void tearDown() throws Exception
	{
		driver.quit();
	}
}
