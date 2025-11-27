package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screenshot {

	static Date date = new Date();
	static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
	static String stringDate = sdf1.format(date);
	private static WebDriver driver = DriverFactory.DriverFactory.getDriver();

	public static void fullPageScreenshot(String pageTitle) throws IOException {

		pageTitle += stringDate;
		System.out.println(pageTitle);
		TakesScreenshot takephoto = (TakesScreenshot) driver;
		File capturePhotoFile = takephoto.getScreenshotAs(OutputType.FILE);
		File savePhotoFile = new File(
				System.getProperty("user.dir") + "\\test-output\\screenshots\\" + pageTitle + ".png");
		FileUtils.copyFile(capturePhotoFile, savePhotoFile);
		// System.out.println(scenario);
		// scenario.attach(capturePhotoFile, ".png", capturePhotoFile.toString());

	}

	public static void elementScreenshot(String pageTitle, WebElement pageElement) throws IOException {

		pageTitle += stringDate;
		System.out.println(pageTitle);

		File capturePhotoFile = pageElement.getScreenshotAs(OutputType.FILE);
		File savePhotoFile = new File(
				System.getProperty("user.dir") + "\\test-output\\screenshots\\" + pageTitle + ".png");
		FileUtils.copyFile(capturePhotoFile, savePhotoFile);

	}
}
