package Question2;

import Question1.CounterDisplay;
import Question2.IntegerWheel;
import java.util.Random;

public class IntegerWheelCounter extends IntegerWheel implements CounterDisplay {

    private IntegerWheel[] integerWheel = new IntegerWheel[3];
    private int noOfWheels;
    Random random = new Random();

    public IntegerWheelCounter(IntegerWheel wheelThree, IntegerWheel wheelTwo, IntegerWheel wheelOne){
        super(0);
        integerWheel[0] = wheelThree;
        integerWheel[1] = wheelTwo;
        integerWheel[2] = wheelOne;

        noOfWheels = integerWheel.length;
    }

    public String toString(){
        String hour, min, sec;

        if (integerWheel[0].getValue() < 10) {
            hour = "0" + integerWheel[0].getValue();
        } else {
            hour = integerWheel[0].getValue().toString();
        }

        if (integerWheel[1].getValue() < 10) {
            min = "0" + integerWheel[1].getValue();
        } else {
            min = integerWheel[1].getValue().toString();
        }

        if (integerWheel[2].getValue() < 10) {
            sec = "0" + integerWheel[2].getValue();
        } else {
            sec = integerWheel[2].getValue().toString();
        }

        return hour + ":" + min + ":" + sec;

    }

    @Override
    // resets counter to minimum value
    public void reset() {
        for (IntegerWheel wheel : integerWheel) {
            wheel.setValue(getMin());
        }
    }

    @Override
    // randomize positions of the wheels
    public void shuffle() {
        // generate a random number between the min and max values
        for (int i = 0; i < noOfWheels; i++){
            integerWheel[i].setValue(random.nextInt(integerWheel[i].getMax()));
        }

    }


    @Override
    // increment the counter
    public void increase() {

        if(integerWheel[1].getValue() +1 > integerWheel[1].getMax() && integerWheel[2].getValue() +1 > integerWheel[2].getMax()){
            integerWheel[0].rollUp();

        }
        if (integerWheel[2].getValue() +1 > integerWheel[2].getMax()){
            integerWheel[1].rollUp();

        }
        integerWheel[2].rollUp();

    }

    @Override
    // decrement the counter
    public void decrease() {
        if(integerWheel[1].getValue() -1 < integerWheel[1].getMin() && integerWheel[2].getValue() -1 < integerWheel[2].getMin()){
            integerWheel[0].rollDown();

        }
        if (integerWheel[2].getValue() -1 < integerWheel[2].getMin()){
            integerWheel[1].rollDown();

        }
        integerWheel[2].rollDown();
    }
}
