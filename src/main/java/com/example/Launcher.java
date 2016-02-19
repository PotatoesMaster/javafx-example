package com.example;

import com.google.common.eventbus.EventBus;
import dagger.ObjectGraph;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Create object graph for injection
        ObjectGraph objectGraph = ObjectGraph.create(new InjectionModule());
        // Create the bus instance
        EventBus eventBus = objectGraph.get(EventBus.class);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        // Set up a factory to inject each controller and register them to the bus
        loader.setControllerFactory(type -> {
            // ... inject the controller
            Object controller = objectGraph.get(type);
            // ... register it
            eventBus.register(controller);
            return controller;
        });

        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}
