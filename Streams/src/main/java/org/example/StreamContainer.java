package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(includeFieldNames=true)
@AllArgsConstructor
public class StreamContainer {
   private String name;
   private long count;
}