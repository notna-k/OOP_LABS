package org.fpm.di;

import java.util.HashMap;
import java.util.Map;

public class BasicEnvironment implements Environment {
    @Override
    public Container configure(Configuration configuration) {
        Map<Class<?>, Class<?>> classesMap = new HashMap<>();
        Map<Class<?>, Object> instancesMap = new HashMap<>();
        Binder binder = new BasicBinder(classesMap, instancesMap);
        Container container = new BasicContainer(classesMap, instancesMap);
        configuration.configure(binder);
        return container;
    }
}
