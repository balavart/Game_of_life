import service.ThreadService;

/**
 * The type Start game.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/20/2019
 */
public class StartGame {

  /** The entry point of application. */
  public static void main(String[] args) {
    ThreadService threadService = new ThreadService();
    threadService.startThreads();
  }
}
