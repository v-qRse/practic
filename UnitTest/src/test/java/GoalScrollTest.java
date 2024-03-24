import org.example.Goal;
import org.example.GoalScroll;
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

      try {
         goalScroll.getLastGoalScroll();
      } catch (Exception e) {
         System.out.println(e.getMessage());
         assertEquals(e.getMessage(), "Goal scroll is clear");
      }

      try {
         while (true) {
            goalScroll.addGoal(new Goal());
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
         assertEquals(e.getMessage(), "The Goal is full");
      }
   }
}
