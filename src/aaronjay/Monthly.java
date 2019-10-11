package aaronjay;

public class Monthly extends Appointment {
    public Monthly(String inDescription, int year, int month, int day) {
        super(inDescription, year, month, day);
    }

    public boolean occursOn(int year, int month, int day) {
        if(year < this.date[0])
            return false;
        else if(year == this.date[0] && month < this.date[1])
            return false;
        else if(day != this.date[2])
            return false;
        else
            return true;
    }

    protected String whoAmI() {
        return "Monthly";
    }
}
