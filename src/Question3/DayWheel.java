package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class DayWheel extends Wheel<Integer> implements Rollable {
    private int minValue = 1;
    private int maxValue;
    private int day;

    public DayWheel(int day) {
        this.day = day;
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

    public void setMax(int max) {
        maxValue = max;
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
        int prev = getValue() -1;

        if (prev < getMin()) {
            super.setValue(getMax());
        } else {
            super.setValue(prev);
        }
    }

    @Override
    public void reset() {
        super.setValue(day);
    }

    @Override
    public Boolean isRolledOver() {
        return getValue() > getMax() || getValue() < getMin();
    }
}
