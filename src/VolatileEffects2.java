public class VolatileEffects2 {

  private static class Pair {
    private Object first;
    private Object second;

    public void addFirst(Object o) {
      first = o;
    }

    public void addSecond(Object o) {
      second = o;
    }

    public Object[] toArray() {
      return new Object[]{first, second};
    }
  }

  private static class FutureResult {
    private volatile Pair data = null;

    public Object[] getResult() {
      return (data == null) ? null : data.toArray();
    }

    public boolean isReady() {
      return data != null;
    }

    // only one thread may ever call putResult()
    public void putResult(Object o1, Object o2) {
      Pair tmp = new Pair();
      tmp.addFirst(o1);
      tmp.addSecond(o2);
      data = tmp;
    }
  }
}
