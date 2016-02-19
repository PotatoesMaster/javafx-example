package com.example;

import com.google.common.eventbus.EventBus;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;

import javax.inject.Inject;
import java.util.Random;

public class MainController {

    @Inject
    public EventBus eventBus;

    Random random = new Random();

    @FXML
    private void changeColorClick() {
        System.out.println("Changing color...");
        eventBus.post(new ColorChangeRequest(Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble())));
    }
}
