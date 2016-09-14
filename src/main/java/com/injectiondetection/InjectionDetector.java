package com.injectiondetection;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InjectionDetector {
    public List<String> fieldNames(String packageToScan) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(packageToScan))
                .setScanners(new FieldAnnotationsScanner()));

        Set<Field> fieldsAnnotatedWith = reflections.getFieldsAnnotatedWith(Autowired.class);

        return fieldsAnnotatedWith.stream().map((field)-> field.getDeclaringClass().getSimpleName() + "::" + field.getName()).collect(Collectors.toList());
    }
}
