package Question3;

import Question1.CounterDisplay;

public class CalendarCounter extends YearWheel implements CounterDisplay {
    YearWheel yearWheel = new YearWheel();
    MonthWheel monthWheel = new MonthWheel();
    DayWheel dayWheel = new DayWheel();
    WeekDaysWheel weekDaysWheel = new WeekDaysWheel();

    public CalendarCounter(int initialMonth, int initialDay, int initialYear){

    }

    public String toString(){
        return "";
    }




    @Override
    public void reset() {

    }

    @Override
    public void shuffle() {

    }

    @Override
    public void increase() {

    }

    @Override
    public void decrease() {

    }
}
