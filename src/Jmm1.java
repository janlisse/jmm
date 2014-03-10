public class Jmm1 extends Thread {
  boolean finished = false;

  public void stopMe() {
    finished = true;
  }

  @Override
  public void run() {
    while (!finished) {
      //do dirty work
    }
  }
}
