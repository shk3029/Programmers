package com.company.pattern.factory.abstractfactory;

public abstract class AbstractFactroy {

    public abstract Monitor createMonitor();
    public abstract Speaker createSpeaker();

    int a = 4;
    enum Brand {
        삼성, LG
    }

    public static AbstractFactroy getFactory(Brand brand) {
        return null;
    }

}
