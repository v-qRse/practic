package org.example;

public class GoalScroll {
   public static final int MAX_GOAL = 3;
   private Goal[] goalScroll;
   private int currentNumberGoal;

   public GoalScroll() {
      goalScroll = new Goal[MAX_GOAL];
      currentNumberGoal = 0;
   }

   public void addGoal(Goal newGoal) throws Exception {
      try {
         goalScroll[currentNumberGoal] = newGoal;
         currentNumberGoal++;
      } catch (Exception e) {
         throw new Exception("The Goal is full");
      }
   }

   public String getLastGoalScroll() throws Exception {
      try {
         return goalScroll[currentNumberGoal - 1].getStatement();
      } catch (Exception e) {
         throw new Exception("Goal scroll is clear");
      }
   }

}
