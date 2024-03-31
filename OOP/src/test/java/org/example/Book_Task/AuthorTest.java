package org.example.Book_Task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorTest {
   @Test
   public void getNameEqualsСonstructor () {
      Author author = new Author("Name", "gender", "email");

      String name = author.getName();
      String gender = author.getGender();
      String email = author.getEmail();

      assertEquals("Name", name);
      assertEquals("gender", gender);
      assertEquals("email", email);
   }

   @Test
   public void getNameEqualsSet () {
      Author author = new Author("name", null, null);
      String name = author.getName();

      assertEquals("name", name);
   }

   @Test
   public void getGenderEqualsSet () {
      Author author = new Author(null, "gender", null);
      String gender = author.getGender();

      assertEquals("gender", gender);
   }

   @Test
   public void getEmailEqualsSet () {
      Author author = new Author(null, null, "email");
      String email = author.getEmail();

      assertEquals("email", email);
   }
}
