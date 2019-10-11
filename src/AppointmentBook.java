import aaronjay.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentBook {
    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        char userInputChar = ' ';
        ArrayList<Appointment> appointmentBook = new ArrayList<Appointment>();

        System.out.println("Welcome to my program that works like an Appointment book!");

        while(userInputChar != 'x') {
            System.out.println("Directions: Type 'a' to add an appointment, Type 'c' to check what appointments occurs on a specific date, Type 'l' to load a date from the Appointments.txt file, Type 'x' to exit");
            userInputChar = userInput.nextLine().charAt(0);

            if(userInputChar == 'a') {
                System.out.println("You are now adding another appointment.");
                while(!(userInputChar == 'o') && !(userInputChar == 'd') && !(userInputChar == 'm') ) {
                    String newDescription;

                    System.out.println("Please enter the type of appointment ('o' for one time, 'd' daily, and 'm' for monthly): ");
                    userInputChar = userInput.nextLine().charAt(0);

                    if(userInputChar == 'o') {
                        String[] inDate;
                        System.out.println("You are adding a one time appointment");
                        System.out.println("Please enter a description: ");
                        newDescription = userInput.nextLine();
                        System.out.println("Please enter the date using this format(yyyy mm dd): ");
                        inDate = userInput.nextLine().split(" ");

                        appointmentBook.add(new Onetime(newDescription, Integer.valueOf(inDate[0]), Integer.valueOf(inDate[1]), Integer.valueOf(inDate[2])));
                    }
                    else if(userInputChar == 'd') {
                        String[] inDate;
                        System.out.println("You are adding a daily appointment");
                        System.out.println("Please enter a description: ");
                        newDescription = userInput.nextLine();
                        System.out.println("Please enter the date using this format(yyyy mm dd): ");
                        inDate = userInput.nextLine().split(" ");

                        appointmentBook.add(new Daily(newDescription, Integer.valueOf(inDate[0]), Integer.valueOf(inDate[1]), Integer.valueOf(inDate[2])));
                    }
                    else if(userInputChar == 'm') {
                        String[] inDate;
                        System.out.println("You are adding a monthly appointment");
                        System.out.println("Please enter a description: ");
                        newDescription = userInput.nextLine();
                        System.out.println("Please enter the date using this format(yyyy mm dd): ");
                        inDate = userInput.nextLine().split(" ");

                        appointmentBook.add(new Monthly(newDescription, Integer.valueOf(inDate[0]), Integer.valueOf(inDate[1]), Integer.valueOf(inDate[2])));
                    }
                    else
                        System.out.println("You have entered an invalid character. Please try again");

                }
                System.out.println("Appointment created! If you want to save this appointment you created type 's' or type 'n' to not save and continue.");
                userInputChar = userInput.nextLine().charAt(0);
                if(userInputChar == 's') {
                    try {
                        appointmentBook.get(appointmentBook.size()-1).save();
                    }
                    catch (IOException except) {
                        System.out.println(except.getMessage());
                    }
                }
            }
            else if(userInputChar == 'c') {
                String[] outDate;
                int numAppointments = 0;

                System.out.println("You are now checking for appointments. Please enter the date using this format(yyyy mm dd): ");
                outDate = userInput.nextLine().split(" ");

                for(int i = 0; i < appointmentBook.size(); i++) {
                    if(appointmentBook.get(i).occursOn(Integer.valueOf(outDate[0]), Integer.valueOf(outDate[1]), Integer.valueOf(outDate[2]))) {
                        numAppointments++;
                        System.out.println("Appointment " + numAppointments + ": " + appointmentBook.get(i).getDescription());
                    }
                }
            }
            else if(userInputChar == 'l') {
                String userDescription;
                Appointment loadAppointment;
                System.out.println("Please enter the description of the appointment you want to load: ");
                userDescription = userInput.nextLine().trim();
                loadAppointment = Appointment.load(userDescription);
                if(loadAppointment.getDescription() == "Error101") {
                    System.out.println("Appointment not found");
                }
                else {
                    appointmentBook.add(loadAppointment);
                }
            }
            else if(userInputChar == 'x')
                System.out.println("You are now exiting the program! Have a nice day!");
            else
                System.out.println("You have entered an invalid character. Please try again");
        }
    }
}
