package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface TimePriorities {
   TimePriority[] value();
}
