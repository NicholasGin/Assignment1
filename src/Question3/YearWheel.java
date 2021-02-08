package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class YearWheel extends Wheel<Integer> implements Rollable{

    // define local variables
    private int initialYear;

    // Constructor sets the given year to the initial year
    public YearWheel(int year) {
        initialYear = year;
        super.setValue(year);
    }

    // checks if the year is a leap year
    public boolean isLeapYear(){
        return initialYear % 4 == 0;
    }

    // increases year by 1
    @Override
    public void rollUp() {
        super.setValue(getValue()+1);
    }

    // decreases year by 1
    @Override
    public void rollDown() {
        super.setValue(getValue()-1);
    }

    // resets value to initial value
    @Override
    public void reset() {
        super.setValue(initialYear);
    }

    // not required since yearWheel doesn't affect another wheel
    @Override
    public Boolean isRolledOver() {
        return null;
    }

}
