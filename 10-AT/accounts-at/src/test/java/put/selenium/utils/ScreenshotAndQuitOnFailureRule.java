package put.selenium.utils;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScreenshotAndQuitOnFailureRule extends TestWatcher {

    private WebDriver webDriver;


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        String methodName = description.getMethodName();
        String fileName = description.getTestClass().getSimpleName() + "-" + methodName + ".png";

        try {
            captureScreenshot(fileName);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public void captureScreenshot(String fileName) throws IOException {
            new File("target/failed-tests-screenshots/").mkdirs(); // Insure directory is there
            FileOutputStream out = new FileOutputStream("target/failed-tests-screenshots/" + fileName);
            out.write(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
            out.close();
    }

    @Override
    protected void finished(Description description) {
        webDriver.quit();
    }
}
