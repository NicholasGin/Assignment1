package Question2;

import Question1.Rollable;

public class IntegerWheel extends Wheel<Integer> implements Rollable {
    private int minValue;
    private int maxValue;



   public IntegerWheel(int max) {
        minValue = 0;
        maxValue = max;
   }
   public IntegerWheel(int min, int max) {
        minValue = min;
        maxValue = max;
        super.setValue(min);

   }

   public int getMin(){
        return minValue;
   }

   public int getMax(){
        return maxValue;
   }

    public void reset(){
        super.setValue(minValue);
    }

    @Override
    public Boolean isRolledOver(){
        return getValue()  > getMax() || getValue() < getMin();
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
        if(prev < getMin()){
            super.setValue(getMax());
        } else {
            super.setValue(prev);
        }
    }


}
