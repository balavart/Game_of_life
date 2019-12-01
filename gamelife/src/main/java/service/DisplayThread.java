package service;

import gui.Canvas;
import java.awt.Graphics;
import java.util.concurrent.Callable;

/**
 * The rendering Thread starts the canvas rendering method.
 *
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
  public Boolean call() {
    canvas.paint(g);
    return true;
  }
}
