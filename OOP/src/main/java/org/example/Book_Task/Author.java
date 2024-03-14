package org.example.Book_Task;

class Author {
   private String name;
   private String gender;
   private String email;

   Author (String name, String gender, String email) {
      this.name = name;
      this.gender = gender;
      this.email = email;
   }

   void setName (String name) {
      this.name = name;
   }

   void setGender (String gender) {
      this.gender = gender;
   }

   void setEmail(String email) {
      this.email = email;
   }

   String getName () {
      return name;
   }

   String getGender () {
      return gender;
   }

   String getEmail () {
      return email;
   }

   @Override
   public String toString() {
      return "Имя: " + name + ", пол: " + gender + ", почта: " + email;
   }
}