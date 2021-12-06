package com.ling5821.javabase.tsl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.ling5821.javabase.tsl.model.Property;
import com.ling5821.javabase.tsl.model.Tsl;
import com.ling5821.javabase.tsl.model.ValueType;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author lsj
 * @date 2021/12/6 10:33
 */
public class TslParser {

    public static void main(String[] args) {
        Tsl tsl = JSONUtil.toBean(
            FileUtil.readString("产品-物模型-2021_12_06 10_29_22.json", StandardCharsets.UTF_8),
            Tsl.class);

        Map<String, Object> example = new LinkedHashMap<>();
        for (Property property : tsl.getProperties()) {
            example.put(property.getId(), generateValue(property.getValueType()));
        }
        System.out.println(JSONUtil.toJsonStr(example));
    }

    public static Object generateValue(ValueType valueType) {
        switch (valueType.getType()) {
            case "int":
            case "long":
            case "float":
            case "double":
                return 0;
            case "boolean":
                return false;
            case "string":
                return "";
            case "array": {
                List<Object> list = new ArrayList<>();
                for (int i = 0; i < 1; i++) {
                    list.add(generateValue(valueType.getElementType()));
                }
                return list;
            }

            case "object": {
                Map<String, Object> objectMap = new LinkedHashMap<>();
                for (Property property : valueType.getProperties()) {
                    objectMap.put(property.getId(), generateValue(property.getValueType()));
                }
                return objectMap;
            }
            default:
                System.out.println("not case " + valueType.getType());
                return null;
        }

    }

}
