package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Saucelabs extends Driver {
	DesiredCapabilities caps;

	public void setCapabilities() {

		if (getSaucelabsProperty("browser").equalsIgnoreCase("chrome")) {

			caps = DesiredCapabilities.chrome();
		} else if (getSaucelabsProperty("browser").equalsIgnoreCase("ie")) {
			caps = DesiredCapabilities.internetExplorer();

		} else if (getSaucelabsProperty("browser").equalsIgnoreCase("safari")) {
			caps = DesiredCapabilities.safari();
		} else if (getSaucelabsProperty("browser").equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		} else {
			caps = DesiredCapabilities.firefox();
		}
		caps.setCapability("platform", getSaucelabsProperty("platform"));
		caps.setCapability("version", getSaucelabsProperty("browserVersion"));
	}

	public void setSaucelabs() {

		String USERNAME = getSaucelabsProperty("userName");
		String ACCESS_KEY = getSaucelabsProperty("accessKey");
		String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

		setCapabilities();
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get(getProperty("appUrl"));

	}

}
