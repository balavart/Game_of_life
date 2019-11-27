package threads;

import gui.Canvas;
import java.awt.Graphics;
import java.util.concurrent.Callable;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/27/2019
 */
public class DisplayThread implements Callable<Boolean> {

  private Canvas canvas;
  private Graphics g;

  public DisplayThread(Canvas canvas) {
    this.canvas = canvas;
  }

  @Override
  public Boolean call() throws Exception {
    canvas.paint(g);
    return true;
  }
}
