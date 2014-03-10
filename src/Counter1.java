public class Counter1 {
  private volatile int value;

  public int getValue() {
    return value;
  }

  public int increment() {
    return ++value;
  }
}
