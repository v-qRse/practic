package org.example;

public class Goal {
   private String statement;

   public Goal () {
      statement = null;
   }

   Goal (String statement) {
      this.statement = statement;
   }

   Goal (Goal goal) {
      this(goal.getStatement());
   }

   public String getStatement() {
      return statement;
   }

   public void setStatement(String statement) {
      this.statement = statement;
   }
}
