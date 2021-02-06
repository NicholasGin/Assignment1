package Question2;

import Question1.Rollable;

public abstract class Wheel<T> implements Rollable {

    //defines a generic type
    private T value;

    // sets the value
    public void setValue(T value){
        this.value = value;
    }

    // returns value
    public T getValue(){
        return value;
    }

    // sets the value field to minimum value of the wheel
    public abstract void reset();

    // return whether the last wheel step caused a rollover
    public abstract Boolean isRolledOver();

}
