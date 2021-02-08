package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class MonthWheel extends Wheel<Integer> implements Rollable{
    private int minValue = 1;
    private int maxValue = 12;

    public int getMin() {
        return minValue;
    }

    public int getMax() {
        return maxValue;
    }

    public String getMonthName(int month){

        switch (month) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sept";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
        }
        return null;
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
        return getValue() > getMax();
    }
}
