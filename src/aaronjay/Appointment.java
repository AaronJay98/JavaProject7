package aaronjay;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Appointment {
    protected final String description;
    protected final int[] date = new int[3];

    public Appointment(String inDescription, int year, int month, int day) {
        this.description = inDescription;
        this.date[0] = year;
        this.date[1] = month;
        this.date[2] = day;
    }

    public String getDescription() {
        return description;
    }

    public int[] getDate() {
        return date;
    }

    public abstract boolean occursOn(int year, int month, int day);

    protected abstract String whoAmI();

    public void save() throws IOException {
        FileWriter saveAppend = new FileWriter("Appointments.txt", true);
        PrintWriter outputFile = new PrintWriter(saveAppend);
        outputFile.println(description + " " + this.whoAmI() + " " + date[1] + "/" + date[2] + "/" + date[0]);
        outputFile.close();
    }

    public static Appointment load(String inputDescription, String filePathName) throws IOException {
        File inputAppointment = new File(filePathName);
        Scanner fileScan = new Scanner(inputAppointment);
        String[] inputDescDivided = inputDescription.split(" ");
        String loadNext;
        String appointmentType;
        String[] strDate;
        int[]    intDate;

        int wordCounter = 0;
        while(fileScan.hasNext()) {
            loadNext = fileScan.next().trim();
            if(loadNext.equals(inputDescDivided[wordCounter])) {
                wordCounter++;
                if(wordCounter == inputDescDivided.length) {
                    appointmentType = fileScan.next().trim();
                    if(appointmentType.equals("Onetime")) {
                        strDate = fileScan.next().trim().split("/");
                        fileScan.close();
                        return new Onetime(inputDescription, Integer.valueOf(strDate[2]), Integer.valueOf(strDate[0]), Integer.valueOf(strDate[1]));
                    }
                    else if(appointmentType.equals("Monthly")) {
                        strDate = fileScan.next().trim().split("/");
                        fileScan.close();
                        return new Monthly(inputDescription, Integer.valueOf(strDate[2]), Integer.valueOf(strDate[0]), Integer.valueOf(strDate[1]));
                    }
                    else if(appointmentType.equals("Daily")) {
                        strDate = fileScan.next().trim().split("/");
                        fileScan.close();
                        return new Daily(inputDescription, Integer.valueOf(strDate[2]), Integer.valueOf(strDate[0]), Integer.valueOf(strDate[1]));
                    }
                    else
                        System.out.println("Error has occurred");
                }
            }
        }
        fileScan.close();
        return new Onetime("ERROR101", 1111, 11, 11);
    }
}
