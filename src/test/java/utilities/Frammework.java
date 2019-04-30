package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class Frammework {

    private static Frammework framework;
    private static Map<String, Object> capMap;
    private static JsonConfigReader jsonConfigReader = new JsonConfigReader();
    private static final HashMap<String, Object> serverParameters = new HashMap<String, Object>();

    public static Frammework getSingletonInstance() {
        if(framework == null) {
            framework = new Frammework();
        }
        return framework;
    }

    public static void updateCapabilities(Map<String, String> table) {
        if (table != null) {
            for (Map.Entry<String, String> entry : table.entrySet()) {
                if (entry.getKey().equals("appWaitDuration")) {
                    capMap.put(entry.getKey(), Integer.parseInt(entry.getValue()));
                } else {
                    capMap.put(entry.getKey(), entry.getValue());
                }

            }
        }
    }

    public static AppiumDriver setupAppiumDriver(Map<String, String> table, String config) throws Exception {
        capMap = jsonConfigReader.getAppiumJsonConfig(config);
        updateCapabilities(table);

        String device = capMap.get("platformName").toString();

        String address = "127.0.0.1";
        String port = "4723";
        serverParameters.put("address", address);
        serverParameters.put("port", port);

        if (context.getValue("appium_subprocess") == null) {
            context.setValue("appium_subprocess", start_appium_server(serverParameters, new DesiredCapabilities(capMap)));
            context.setValue("appium_server_url", "http://" + address + ":" + port + "/wd/hub"); //added
        }

    }

    public static AppiumDriverLocalService start_appium_server(HashMap<String, Object> serverPar, DesiredCapabilities capability) {

        return startMacAppiumServer(serverPar.get("address").toString(), Integer.parseInt(serverPar.get("port").toString()), capability);
    }

}