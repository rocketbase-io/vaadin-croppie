package io.rocketbase.vaadin.croppie.model;

public enum ViewPortType {

    SQUARE,
    CIRCLE;

    public static io.rocketbase.vaadin.croppie.model.ViewPortType fromString(String key) {
        return key == null
                ? null
                : io.rocketbase.vaadin.croppie.model.ViewPortType.valueOf(key.toUpperCase());
    }

    public String getKey() {
        return name().toLowerCase();
    }

}
