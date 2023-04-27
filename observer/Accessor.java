public interface Accessor {
    void add(Monitor monitor);

    void remove(Monitor monitor);

    void notifyToAllMonitor();
}
