package org.example;

import java.lang.annotation.*;

@Repeatable(TimePriorities.class)
@Target(ElementType.METHOD)
public @interface TimePriority {
   int hour();
   int priority();
   String description();
}