package org.example.Book_Task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
   @Test
   public void setBookEqualsConstuction () {
      Book book = new Book(new Author("name", "gender", "email"), "year");

      Author author = book.getAuthor();
      String nameAuthor = author.getName();
      String genderAuthor = author.getGender();
      String emailAuthor = author.getEmail();

      String year = book.getYear();

      assertEquals("name", nameAuthor);
      assertEquals("gender", genderAuthor);
      assertEquals("email", emailAuthor);
      assertEquals("year", year);
   }

   @Test
   public void setAuthorEqualsGet () {
      Book book = new Book(new Author(null, null, null), null);
      book.setAuthor(new Author("name", "gender", "email"));

      Author author = book.getAuthor();
      String nameAuthor = author.getName();
      String genderAuthor = author.getGender();
      String emailAuthor = author.getEmail();

      assertEquals("name", nameAuthor);
      assertEquals("gender", genderAuthor);
      assertEquals("email", emailAuthor);
   }

   @Test
   public void setYearEqualsGet () {
      Book book = new Book(new Author(null, null, null), null);
      book.setYear("year");

      String year = book.getYear();

      assertEquals("year" , year);
   }
}
