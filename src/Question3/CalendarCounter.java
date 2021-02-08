package Question3;

import Question1.CounterDisplay;

public class CalendarCounter implements CounterDisplay {
    YearWheel yearWheel;
    MonthWheel monthWheel;
    DayWheel dayWheel;
    WeekDaysWheel weekDaysWheel;

    public CalendarCounter(int initialMonth, int initialDay, int initialYear){
         yearWheel = new YearWheel(initialYear);
         monthWheel = new MonthWheel(initialMonth);
         dayWheel = new DayWheel(initialDay);
         weekDaysWheel = new WeekDaysWheel();

    }

    public String toString(){
        return weekDaysWheel.zellersCongruence(dayWheel.getValue(), monthWheel.getValue(), yearWheel.getValue()) + " " +
                dayWheel.getValue() + " " + monthWheel.getMonthName(monthWheel.getValue()) + ", " + yearWheel.getValue();
    }


    @Override
    public void reset() {
        yearWheel.reset();
        monthWheel.reset();
        dayWheel.reset();

    }

    @Override
    public void shuffle() {

    }

    @Override
    public void increase() {
        //if leap year and feb, feb 29
        if(monthWheel.getMonthName(monthWheel.getValue()).equals("Feb")){
            if(yearWheel.isLeapYear())
                dayWheel.setMax(29);
            else
                dayWheel.setMax(28);
        }
        if (monthWheel.getValue() +1 > monthWheel.getMax())
            yearWheel.rollUp();

        if (dayWheel.getValue() +1 > dayWheel.getMax()){
            monthWheel.rollUp();
        }
        dayWheel.rollUp();

    }

    @Override
    public void decrease() {
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

        if (monthWheel.getValue() -1 < monthWheel.getMin() && dayWheel.getValue()-1 < dayWheel.getMin())
            yearWheel.rollDown();

        if(dayWheel.getValue() -1 < dayWheel.getMin()){
            monthWheel.rollDown();
        }


        dayWheel.rollDown();
    }
}
