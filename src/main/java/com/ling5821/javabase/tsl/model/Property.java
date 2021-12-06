package com.ling5821.javabase.tsl.model;

/**
 * @author lsj
 * @date 2021/12/6 11:08
 */
public class Property {
    private String id;
    private ValueType valueType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }
}
