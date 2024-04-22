import org.example.Goal;
import org.example.GoalScroll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GoalScrollTest {

   @Test
   public void getGoalMockTest () throws Exception {
      GoalScroll goalScrollMock = mock(GoalScroll.class);

      when(goalScrollMock.getLastGoalScroll()).thenReturn("test");

      String goal = goalScrollMock.getLastGoalScroll();

      assertEquals("test", goal);
   }

   @Test
   public void numberCallTest () throws Exception {
      Goal goalMock = mock(Goal.class);
      when(goalMock.getStatement()).thenReturn("test");

      GoalScroll goalScroll = new GoalScroll();

      goalScroll.addGoal(goalMock);
      verify(goalMock, times(0)).getStatement();

      String buf = goalScroll.getLastGoalScroll();
      assertEquals("test", buf);

      verify(goalMock, times(1)).getStatement();
   }

   @Test
   public void exceptionTest () {
      GoalScroll goalScroll = new GoalScroll();

      Exception getLastGoalScrollException = Assertions.assertThrows(Exception.class, goalScroll::getLastGoalScroll);
      assertEquals(getLastGoalScrollException.getMessage(), "Goal scroll is clear");


      Exception addGoalException = Assertions.assertThrows(Exception.class, () -> {
         while (true) {
            goalScroll.addGoal(new Goal());
         }
      });
      assertEquals(addGoalException.getMessage(), "Goal scroll is full");
   }


   @Test
   void privateMethodAndToStringTest () throws Exception {
      GoalScroll goalScroll = new GoalScroll();

      String stringGoalScroll = goalScroll.toString();
      assertEquals(String.format( "Максимальная длина: %s Текущее количество целей: %s. Цели: %s",
                  3, 0, ""), stringGoalScroll);
   }
}
