import java.util.concurrent.atomic.AtomicInteger;


public class Counter2 {
  private AtomicInteger value = new AtomicInteger();

  public int getValue() {
    return value.get();
  }

  public int increment() {
    int oldValue = value.get();
    while (!value.compareAndSet(oldValue, oldValue + 1)) {
      oldValue = value.get();
    }
    return oldValue + 1;
  }
}
