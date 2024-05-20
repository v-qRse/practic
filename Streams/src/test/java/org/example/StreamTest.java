package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest {
   @Test
   public void sortAndAverageTest () {
      IntStream intStream = IntStream.of(5, 20 , 1, 94, 16, 101, 73, 64, 28, 31);
      OptionalDouble average = intStream.filter(x -> x > 9 && x < 100)
            .sorted()
            .peek(System.out::println)
            .average();

      assertEquals((20+94+16+73+64+28+31)/7.0, average.getAsDouble());
   }

   @Test
   public void conversionAndOutputWithStreamContainerTest () {
      Stream<String> stringStream = Stream.of("ab", "abc");
      Map<Long, String> hashMap = stringStream.map(x -> new StreamContainer(x, (long) (Math.random()*1000)))
            .peek(x -> System.out.println(x.toString()))
            .collect(Collectors.toMap(s -> s.getCount(), s -> s.getName()));
   }

   @Test
   public void flatMapAndCreateListTest () {
      List<StreamContainer> bufList = new ArrayList<>();
      bufList.add(new StreamContainer("x1", (long) (Math.random()*1000)));
      bufList.add(new StreamContainer("x2", (long) (Math.random()*1000)));

      HashMap<String, List<StreamContainer>> stringListHashMap = new HashMap<>();
      stringListHashMap.put("abc", bufList);

      List<StreamContainer> streamContainersList = stringListHashMap.values()
            .stream()
            .flatMap(Collection::stream)
            .toList();
      long streamContainersListLength = streamContainersList.stream().count();

      assertEquals(2,streamContainersListLength);
   }

   @Test
   public void stringStreamTest () {
      String boleanString = "0101010101";
      Boolean result = boleanString.codePoints()
            .mapToObj(x -> x == (int) '1')
            .allMatch(x -> x == true);

      assertEquals(false, result);
   }
}
