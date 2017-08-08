package com.foldik.xml.homework.xml.homework.model;

public final class Color {

    private final String hex;

    public Color(String hex) {
        this.hex = hex;
    }

    @Override
    public String toString() {
        return "Color{" +
                "hex='" + hex + '\'' +
                '}';
    }

    public String getHex() {
        return hex;
    }
}
