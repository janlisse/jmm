public class VolatileEffects {
  
  private static class FutureResult {

    private volatile boolean ready = false;
    private Object data = null;

    public Object getResult() {
      isReady();
      return data;
    }

    public boolean isReady() {
      return ready;
    }

    // only one thread may ever call putResult()
    public void putResult(Object o) {
      data = o;
      ready = true;
    }
  }

}
