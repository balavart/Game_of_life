import static java.lang.Thread.sleep;

import service.ThreadService;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/20/2019
 */
public class Main {

  public static void main(String[] args) {
    ThreadService threadService = new ThreadService();
    threadService.startThreads();
  }

}
