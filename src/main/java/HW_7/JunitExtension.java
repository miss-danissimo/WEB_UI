package HW_7;


import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.ByteArrayInputStream;

public class JunitExtension implements TestWatcher {
    ByteArrayInputStream screenshot;

    public ByteArrayInputStream getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(ByteArrayInputStream screenshot) {
        this.screenshot = screenshot;
    }

    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.addAttachment("Скриншот перед закрытие браузера", screenshot);
    }
}
