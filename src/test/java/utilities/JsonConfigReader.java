package utilities;

import java.util.Map;

public class JsonConfigReader {

    String path = System.getProperty("user.dir");
    String jsonFileConfigPath;

    public Map<String, Object> getAppiumJsonConfig(String fileConfig) {
        jsonFileConfigPath = path + "" + fileConfig + ".json";
        return getConfig(jsonFileConfigPath);
    }

    public Map<String, Object> getConfig(String jsonFileConfigPath) {
        return JsonReader.getJsonObject(jsonFileConfigPath);
    }

}
