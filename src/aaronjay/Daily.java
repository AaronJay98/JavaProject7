package aaronjay;

public class Daily extends Appointment {
    public Daily(String inDescription, int year, int month, int day) {
        super(inDescription, year, month, day);
    }

    public boolean occursOn(int year, int month, int day) {
        if(year < this.date[0])
            return false;
        else if(year > this.date[0])
            return true;
        else if(month < this.date[1])
            return false;
        else if(month > this.date[1])
            return true;
        else if(day < this.date[2])
            return false;
        else
            return true;
    }

    protected String whoAmI() {
        return "Daily";
    }
}
