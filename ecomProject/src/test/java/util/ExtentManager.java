package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.BasePage;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
    public static String fileName;
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setEncoding("utf-8");
        reporter.config().setReportName("Sample Extent Report");
        System.out.printf("attach report %s",extentReports);
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "SW Test Academy");
        extentReports.setSystemInfo("Author", "Onur Baskirt");
        
        return extentReports;
    }
//public static void captureScreenshot() throws IOException {
		
	//	Date d = new Date();
		// fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

		
		
		//Fi/le screeshot = ((TakesScreenshot)  BasePage.driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screeshot, new File(".//reports//"+fileName));
	//}


}

