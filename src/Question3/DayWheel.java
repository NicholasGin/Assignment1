package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class DayWheel extends Wheel<Integer> implements Rollable {
    private int minValue = 1;
    private int maxValue;

    // returns minimum value of the wheel
    public int getMin() {
        return minValue;
    }

    // returns maximum value of the wheel
    public int getMax() {
        return maxValue;
    }

    @Override
    public void rollUp() {
        int next = getValue() + 1;

        if (next > getMax()) {
            super.setValue(getMin());
        } else {
            super.setValue(next);
        }
    }

    @Override
    public void rollDown() {
        int prev = getValue() - 1;

        if (prev < getMin()) {
            super.setValue(getMax());
        } else {
            super.setValue(prev);
        }
    }

    @Override
    public void reset() {
        super.setValue(minValue);
    }

    @Override
    public Boolean isRolledOver() {
        return getValue() > getMax() || getValue() < getMin();
    }
}
