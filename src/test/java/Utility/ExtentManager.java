package Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Cucumber_Framework\\Report\\ExtentReport.html");
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
