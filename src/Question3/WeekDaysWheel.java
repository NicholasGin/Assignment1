package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class WeekDaysWheel extends Wheel<Integer> implements Rollable {

    // zellers congruence, finds the day of the week given a date
    // january & february counted as 13 and 14th month of the previous year
    public String zellersCongruence(int day, int month, int year){
        if (month == 1)
        {
            month = 13;
            year--;
        }
        if (month == 2)
        {
            month = 14;
            year--;
        }
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = day + 13*(m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        h = h % 7;
        switch (h)
        {
            case 0 : return("Sat");
            case 1 : return("Sun");
            case 2 : return("Mon");
            case 3 : return("Tue");
            case 4 : return("Wed");
            case 5 : return("Thu");
            case 6 : return("Fri");
        }
        return null;
    }
    @Override
    public void rollUp() {

    }

    @Override
    public void rollDown() {

    }

    @Override
    public void reset() {

    }

    @Override
    public Boolean isRolledOver() {
        return null;
    }
}
