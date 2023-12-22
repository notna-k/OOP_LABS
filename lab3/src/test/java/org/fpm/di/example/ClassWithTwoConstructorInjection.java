package org.fpm.di.example;

import javax.inject.Inject;

public class ClassWithTwoConstructorInjection {

    private Van van;
    private VanGarage vanGarage;

    @Inject
    public ClassWithTwoConstructorInjection(Van van) {
        this.van = van;
    }

    @Inject
    public ClassWithTwoConstructorInjection(VanGarage vanGarage) {
        this.vanGarage = vanGarage;
    }

}
