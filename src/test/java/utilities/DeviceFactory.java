package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class DeviceFactory {

    private static AppiumDriverLocalService appiumService;
    private static AppiumServiceBuilder builder;
    private static AppiumDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceFactory.class);

    public static AppiumDriverLocalService startMacAppiumServer(String address, int port, DesiredCapabilities capabilities){
        LOGGER.info("-- Building and starting the server: --");

        String OS = System.getProperty("os.name");
        String path = System.getProperty("user.home");

        builder = new AppiumServiceBuilder();

        if (OS.toLowerCase().contains("mac")){
            builder.usingDriverExecutable(new File(Util.getAppiumDriverExecutable()));
            //builder.withAppiumJS(new File(path+BaseUtil.getAppiumJS()));
            builder.withAppiumJS(new File(BaseUtil.getAppiumJS()));
        }

        builder.withCapabilities(capabilities);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);

        builder.withIPAddress(address);
        builder.usingPort(port);
        appiumService = builder.build();
        appiumService.start();
        LOGGER.info("-- Server started on Port : " + port + " --");
        return appiumService;
    }

}
