package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class DayWheel extends Wheel<Integer> implements Rollable {

    // define local variables
    private int minValue = 1;
    private int maxValue;
    private int initialDay;

    // Constructor
    public DayWheel(int day) {
        initialDay = day;
        super.setValue(day);
    }


    // returns minimum value of the wheel
    public int getMin() {
        return minValue;
    }

    // returns maximum value of the wheel
    public int getMax() {
        return maxValue;
    }

    // sets the maximum value of the wheel
    public void setMax(int max) {
        maxValue = max;
    }

    // checks ifRolledOver, increases day by 1
    @Override
    public void rollUp() {
        int next = getValue() + 1;

        if (isRolledOver()) {
            super.setValue(getMin());
        } else {
            super.setValue(next);
        }
    }

    // checks ifRolledOver, decreases day by 1
    @Override
    public void rollDown() {
        int prev = getValue() -1;

        if (isRolledOver()) {
            super.setValue(getMax());
        } else {
            super.setValue(prev);
        }
    }

    // sets value to initial value
    @Override
    public void reset() {
        super.setValue(initialDay);
    }

    // checks if the next or previous value exceeds the bounds
    @Override
    public Boolean isRolledOver() {
        return getValue() +1> getMax() || getValue()-1 < getMin();
    }
}
