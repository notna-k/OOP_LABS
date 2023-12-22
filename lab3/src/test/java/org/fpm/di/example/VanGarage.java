package org.fpm.di.example;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class VanGarage {

    private final Van van;

    @Inject
    public VanGarage(Van van) {
        this.van = van;
    }

    public Van getVan() {
        return van;
    }

}
