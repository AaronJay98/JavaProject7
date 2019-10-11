package aaronjay;

public class Onetime extends Appointment {
    public Onetime(String inDescription, int year, int month, int day) {
        super(inDescription, year, month, day);
    }

    public boolean occursOn(int year, int month, int day) {
        return (this.date[0] == year && this.date[1] == month && this.date[2] == day);
    }

    protected String whoAmI() {
        return "Onetime";
    }
}
