package org.fpm.di.example;

import javax.inject.Inject;

public class ClassWithNestedInjection {

    private final VanGarage vanGarage;

    @Inject
    public ClassWithNestedInjection(VanGarage vanGarage) {
        this.vanGarage = vanGarage;
    }

    public VanGarage getVanGarage() {
        return vanGarage;
    }

}
