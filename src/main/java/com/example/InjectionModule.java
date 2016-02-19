package com.example;

import com.google.common.eventbus.EventBus;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(injects = {
        EventBus.class,
        ColoredPaneController.class,
        MainController.class,
})
public class InjectionModule {

    @Provides
    @Singleton
    public EventBus defaultEventBus() {
        return new EventBus();
    }
}
