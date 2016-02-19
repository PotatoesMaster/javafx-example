package com.example;

import javafx.scene.paint.Color;

import java.util.Objects;

public class ColorChangeRequest {

    private final Color color;

    public ColorChangeRequest(Color color) {
        this.color = Objects.requireNonNull(color, "color");
    }

    public Color getColor() {
        return color;
    }
}
