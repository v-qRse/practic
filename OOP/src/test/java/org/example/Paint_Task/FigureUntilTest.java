package org.example.Paint_Task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FigureUntilTest {
   private Figure[] arrayFigure;

   @BeforeEach
   void CreateListFigure () {
      arrayFigure = new Figure[]{new Circle(), new Rectangle(), new Cube(), new Triangle()};
   }

   @Test
   void drawTestDraw () {
      for (Figure figure: arrayFigure) {
         FigureUntil.draw(figure);
      }
   }

   @Test
   void drawTestDrawColor () {
      for (Figure figure: arrayFigure) {
         FigureUntil.draw(figure, Color.BLUE);
         FigureUntil.draw(figure, Color.BLACK);
         FigureUntil.draw(figure, Color.RED);
         FigureUntil.draw(figure, Color.WHITE);
         FigureUntil.draw(figure, Color.YELLOW);
      }
   }
}
