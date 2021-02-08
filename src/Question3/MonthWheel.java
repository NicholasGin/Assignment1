package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class MonthWheel extends Wheel<Integer> implements Rollable{

    // define local variables
    private int minValue = 1;
    private int maxValue = 12;
    private int initialMonth;
    private int monthLength;

    // Constructor sets the initialMonth
    public MonthWheel(int month) {
        initialMonth = month;
        super.setValue(month);
    }

    // getter methods for min, max, month length, and month name
    public int getMin() {
        return minValue;
    }

    public int getMax() {
        return maxValue;
    }

    public int getMonthLength(){
        return monthLength;
    }

    // converts numeric representation of month to String
    public String getMonthName(int month){

        switch (month) {
            case 1:
                monthLength = 31;
                return "Jan";
            case 2:
                monthLength = 28;
                return "Feb";
            case 3:
                monthLength = 31;
                return "Mar";
            case 4:
                monthLength = 30;
                return "Apr";
            case 5:
                monthLength = 31;
                return "May";
            case 6:
                monthLength = 30;
                return "Jun";
            case 7:
                monthLength = 31;
                return "Jul";
            case 8:
                monthLength = 31;
                return "Aug";
            case 9:
                monthLength = 30;
                return "Sept";
            case 10:
                monthLength = 31;
                return "Oct";
            case 11:
                monthLength = 30;
                return "Nov";
            case 12:
                monthLength = 31;
                return "Dec";
        }
        return null;
    }

    // checks ifRolledOver, increases month by 1
    @Override
    public void rollUp() {
        int next = getValue() + 1;

        if (isRolledOver()) {
            super.setValue(getMin());
        } else {
            super.setValue(next);
        }
    }

    // checks ifRolledOver, decreases month by 1
    @Override
    public void rollDown() {
        int prev = getValue() - 1;

        if (isRolledOver()) {
            super.setValue(getMax());
        } else {
            super.setValue(prev);
        }
    }

    // sets value to initial value
    @Override
    public void reset() {
        super.setValue(initialMonth);
    }

    // checks if the next or previous value exceeds the bounds
    @Override
    public Boolean isRolledOver() {
        return (getValue() +1 > getMax() || getValue() -1 < getMin());
    }
}
