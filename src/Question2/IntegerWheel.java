package Question2;

import Question1.Rollable;

public class IntegerWheel extends Wheel<Integer> implements Rollable {

    // define variables
    private int minValue;
    private int maxValue;

    // constructor with one parameter sets min value to 0 and max value to max
    public IntegerWheel(int max) {
        minValue = 0;
        maxValue = max;
        super.setValue(max);
    }

    // constructor with two parameters, sets min and max value to min & max parameter, respectively
    public IntegerWheel(int min, int max) {
        minValue = min;
        maxValue = max;
        super.setValue(min);

    }

    // returns minimum value of the wheel
    public int getMin() {
        return minValue;
    }

    // returns maximum value of the wheel
    public int getMax() {
        return maxValue;
    }

    // sets the wheel value to minimum value
    public void reset() {
        super.setValue(minValue);
    }

    // returns true if the wheel has exceeded its maximum or minimum
    @Override
    public Boolean isRolledOver() {
        return getValue() > getMax() || getValue() < getMin();
    }

    // checks that the next value of the wheel is below the maximum bound
    // increments wheel value
    @Override
    public void rollUp() {
        int next = getValue() + 1;

        if (next > getMax()) {
            super.setValue(getMin());
        } else {
            super.setValue(next);
        }
    }

    // checks that the value of the wheel is above the minimum bound
    @Override
    public void rollDown() {
        int prev = getValue() - 1;

        if (prev < getMin()) {
            super.setValue(getMax());
        } else {
            super.setValue(prev);
        }
    }


}
