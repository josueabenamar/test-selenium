var server = "http://localhost:4444/wd/hub";
var url = "http://localhost/selenium";

const {Builder, By, Key, promise, until} = require('selenium-webdriver');

promise.consume(function* ()
{
	let driver;

	try
	{
		driver = yield new Builder().forBrowser("firefox").usingServer(server).build();
		yield driver.get(url);

		let username = yield driver.findElement(By.id("username"));
		yield username.sendKeys("hola");

		let password = yield driver.findElement(By.id("password"));
		yield password.sendKeys("holamundo");

		let send = yield driver.findElement(By.id("send"));
		yield send.click();

		yield driver.wait(until.titleIs("Home"), 1000);
	}
	finally
	{
		yield driver && driver.quit();
	}
}).then(_ => console.log('SUCCESS'), err => console.error('ERROR: ' + err));

