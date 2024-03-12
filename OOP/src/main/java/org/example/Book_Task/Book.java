package org.example.Book_Task;

class Book {
   private Author author;
   private String year;

   Book (Author author, String year) {
      this.author = new Author(author.getName(), author.getGender(), author.getEmail());
      this.year = year;
   }

   void setName (String name) {
      author.setName(name);
   }

   void setAuthor (Author author) {
      this.author = new Author(author.getName(), author.getGender(), author.getEmail());
   }

   String getYear () {
      return year;
   }

   Author getAuthor () {
      return author;
   }

   @Override
   public String toString () {
      return author.toString() + ", год: " + year;
   }
}
