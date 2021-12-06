package com.ling5821.javabase.tsl.model;

import java.util.List;

/**
 * @author lsj
 * @date 2021/12/6 11:08
 */
public class ValueType {
    private String type;
    private ValueType elementType;
    private List<Property> properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ValueType getElementType() {
        return elementType;
    }

    public void setElementType(ValueType elementType) {
        this.elementType = elementType;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
