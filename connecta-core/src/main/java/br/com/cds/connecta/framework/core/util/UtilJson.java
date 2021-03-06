package br.com.cds.connecta.framework.core.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author raphael
 */
public class UtilJson {

//    public static JSONArray listToJson(List list, String[] excludes) {
//        JsonConfig config = new JsonConfig();
//        config.setExcludes(excludes);
//        config.setIgnoreDefaultExcludes(false);
//        config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
//        return JSONArray.fromObject(list, config);
//    }

    public static <T> T fromJson(String json, Class<T> clazz) throws IOException {
        if (!Util.isEmpty(json) && json.startsWith("{") && json.endsWith("}")) {
            return new ObjectMapper().readValue(json, clazz);
        }
        return null;
    }

    public static <T> T fromJson(String json, TypeReference<T> ref) throws IOException {
        if (!Util.isEmpty(json) && json.startsWith("{") && json.endsWith("}")) {
            return new ObjectMapper().readValue(json, ref);
        }
        return null;
    }

}
