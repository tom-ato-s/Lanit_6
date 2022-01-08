package allure;

        import io.qameta.allure.Attachment;
        import org.openqa.selenium.WebDriver;
        import org.testng.ITestContext;
        import org.testng.ITestListener;
        import org.testng.ITestResult;
        import ru.yandex.qatools.ashot.AShot;

        import javax.imageio.ImageIO;
        import java.awt.image.BufferedImage;
        import java.io.ByteArrayOutputStream;
        import java.io.IOException;

public class MyTestListener implements ITestListener {

    //Text attachments for Allure
    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[]  saveScreenshotPNG(WebDriver driver) {
        BufferedImage image = new AShot().takeScreenshot(driver).getImage();
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", stream);
            byte[] bytes = stream.toByteArray();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}