package Question3;

import Question1.CounterDisplay;

public class CalendarCounter implements CounterDisplay {

    // define object wheels
    YearWheel yearWheel;
    MonthWheel monthWheel;
    DayWheel dayWheel;
    WeekDaysWheel weekDaysWheel;

    // Constructor, initialize objects
    public CalendarCounter(int initialMonth, int initialDay, int initialYear){
         yearWheel = new YearWheel(initialYear);
         monthWheel = new MonthWheel(initialMonth);
         dayWheel = new DayWheel(initialDay);
         weekDaysWheel = new WeekDaysWheel();

    }

    // returns date format dayOfWeek date Month, year
    public String toString(){
        return weekDaysWheel.zellersCongruence(dayWheel.getValue(), monthWheel.getValue(), yearWheel.getValue()) + " " +
                dayWheel.getValue() + " " + monthWheel.getMonthName(monthWheel.getValue()) + ", " + yearWheel.getValue();
    }

    // resets all the wheels
    @Override
    public void reset() {
        yearWheel.reset();
        monthWheel.reset();
        dayWheel.reset();

    }

    // increases the day by 1
    @Override
    public void increase() {
        //if leap year and february, sets max day to 29
        // not leap year and february, sets max day to 28
        if(monthWheel.getMonthName(monthWheel.getValue()).equals("Feb")){
            if(yearWheel.isLeapYear())
                dayWheel.setMax(29);
            else
                dayWheel.setMax(28);
        }

        // if month wheel and day wheel reaches max value , then the year increases
        if (monthWheel.getValue() +1 > monthWheel.getMax() && dayWheel.getValue()+1 > dayWheel.getMax())
            yearWheel.rollUp();

        // if day wheel reaches max value, month increases
        if (dayWheel.getValue() +1 > dayWheel.getMax()){
            monthWheel.rollUp();
        }

        // increase day wheel by 1
        dayWheel.rollUp();

    }

    // decreases the day by 1
    @Override
    public void decrease() {
        //if leap year and march, sets max day to 29
        // not leap year and march, sets max day to 28
        // otherwise set the max day to the length of given month
        if(yearWheel.isLeapYear()){
            if(monthWheel.getMonthName(monthWheel.getValue()).equals("Mar"))
                dayWheel.setMax(29);
            else
                dayWheel.setMax(monthWheel.getMonthLength());
        } else if(monthWheel.getMonthName(monthWheel.getValue()).equals("Mar")){

                dayWheel.setMax(28);
        } else {
            dayWheel.setMax(monthWheel.getMonthLength());

        }

        // if month wheel and day wheel reaches min value , then the year decreases
        if (monthWheel.getValue() -1 < monthWheel.getMin() && dayWheel.getValue()-1 < dayWheel.getMin())
            yearWheel.rollDown();

        if(dayWheel.getValue() -1 < dayWheel.getMin()){
            monthWheel.rollDown();
        }

        // decrease day wheel by 1
        dayWheel.rollDown();
    }

    @Override
    public void shuffle() {

    }
}
