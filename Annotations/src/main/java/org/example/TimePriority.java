package org.example;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(TimePriorities.class)
@Target(ElementType.METHOD)
public @interface TimePriority {
   int hour();
   int priority();
   String description();
}