package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class YearWheel extends Wheel<Integer> implements Rollable{
    private int year;


    public boolean isLeapYear(){
        return year % 4 == 0;
    }
    @Override
    public void rollUp() {
        super.setValue(getValue()+1);
    }

    @Override
    public void rollDown() {
        super.setValue(getValue()-1);
    }

    @Override
    public void reset() {
        super.setValue(0);
    }

    @Override
    public Boolean isRolledOver() {
        return null;
    }

}
