package Logic;

public enum State {
    LOGIN(0),
    REGISTER(1),
    RUNNING(2);

    public final int i;

    State(int i) {
        this.i = i;
    }
}
