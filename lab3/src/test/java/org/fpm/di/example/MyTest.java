package org.fpm.di.example;

import org.fpm.di.*;

import static org.junit.Assert.assertSame;
import org.junit.Test;

public class MyTest {

    private final Environment environment = new BasicEnvironment();

    @Test(expected = BindException.class)
    public void shouldThrowBindExceptionWhenTryingToRebindWithClass() {
        environment.configure((binder) -> {
            binder.bind(Car.class, Van.class);
            binder.bind(Car.class, Sedan.class);
        });
    }

    @Test(expected = BindException.class)
    public void shouldThrowBindExceptionWhenTryingToRebindWithInstance() {
        environment.configure((binder) -> {
            binder.bind(Car.class, Van.class);
            binder.bind(Car.class, new Sedan());
        });
    }

    @Test(expected = BindException.class)
    public void shouldThrowBindExceptionWhenTryingToRegisterAbstractClass() {
        environment.configure((binder) -> {
            binder.bind(Car.class);
        });
    }

    @Test(expected = BindException.class)
    public void shouldThrowBindExceptionWhenTryingToRegisterInterface() {
        environment.configure((binder) -> {
            binder.bind(Vehicle.class);
        });
    }

    @Test(expected = BindException.class)
    public void shouldThrowBindExceptionWhenTryingToRegisterNull() {
        environment.configure((binder) -> {
            binder.bind(null);
        });
    }

    @Test(expected = BindException.class)
    public void shouldThrowBindExceptionWhenTryingToRegisterClassWithMoreThanOneInjectionConstructor() {
        environment.configure((binder) -> {
            binder.bind(ClassWithTwoConstructorInjection.class);
        });
    }

    @Test(expected = UnregisteredComponentException.class)
    public void shouldThrowUnregisteredComponentExceptionWhenTryingToGetUnregisteredComponent() {
        Container container = environment.configure((binder) -> {});
        container.getComponent(Van.class);
    }

    @Test(expected = UnregisteredComponentException.class)
    public void shouldThrowUnregisteredComponentExceptionWhenTryingToGetComponentWhichDependenciesNotRegistered() {
        Container container = environment.configure((binder) -> {
            binder.bind(VanGarage.class);
        });
        container.getComponent(VanGarage.class);
    }

    @Test(expected = CircularInjectException.class)
    public void shouldThrowCircularInjectExceptionWhenTryingToRegisterComponentWithCircularInjectDependency() {
        environment.configure((binder) -> {
            binder.bind(A.class);
            binder.bind(B.class);
            binder.bind(C.class);
        });
    }

    @Test
    public void shouldResolveSingletonWithInjection() {
        Container container = environment.configure((binder) -> {
            binder.bind(Van.class);
            binder.bind(VanGarage.class);
        });
        /* @Singleton AppleSharer */
        VanGarage vanGarage1 = container.getComponent(VanGarage.class);
        VanGarage vanGarage2 = container.getComponent(VanGarage.class);
        assertSame(vanGarage1, vanGarage2);
        assertSame(vanGarage1.getVan(), vanGarage2.getVan());
    }

    @Test
    public void shouldResolveNestedInjectDependency() {
        Container container = environment.configure((binder) -> {
            binder.bind(ClassWithNestedInjection.class);
            binder.bind(Van.class);
            binder.bind(VanGarage.class);
        });
        ClassWithNestedInjection c = container.getComponent(ClassWithNestedInjection.class);
        assertSame(c.getVanGarage(), container.getComponent(VanGarage.class));
    }

}
