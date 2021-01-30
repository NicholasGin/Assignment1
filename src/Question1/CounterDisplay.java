package Question1;

public interface CounterDisplay {

    // resets counter to minimum value
    public void reset();

    // randomize positions of the wheels
    public void shuffle();

    // increment the counter
    public void increase();

    // decrement the counter
    public void decrease();
}
