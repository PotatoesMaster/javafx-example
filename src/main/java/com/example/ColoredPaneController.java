package com.example;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

import javax.inject.Inject;

public class ColoredPaneController {

    @Inject
    public EventBus bus;

    public Pane colorPane;

    @Subscribe
    public void changeColor(ColorChangeRequest request) {
        colorPane.setBackground(new Background(new BackgroundFill(request.getColor(), null, null)));
        System.out.println("Color changed to " + request.getColor());
    }
}
