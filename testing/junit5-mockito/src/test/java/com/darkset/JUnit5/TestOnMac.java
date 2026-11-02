package com.darkset.JUnit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Test
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@EnabledOnOs(OS.MAC)
public @interface TestOnMac {
}
