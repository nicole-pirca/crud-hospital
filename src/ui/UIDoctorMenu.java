package ui;
import modelos.Doctor;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class UIDoctorMenu {
    public static ArrayList<Doctor> doctorsAvailableAppoiments = new ArrayList<>();
    public static void showDoctorMenu() throws ParseException {
        int response = 0;
        do {
            System.out.println("\n");
            System.out.println("Doctor");
            System.out.println("Welcome "+UIMenu.doctorLogeado.getName() );
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled appointments");
            System.out.println("0. Lougt out");


            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response){
                case 1:
                    showAvailableAppointmentMenu();
                    break;
                case 2:
                    showDoctorMyAppoinment();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (response!=0);
    }
    private static void showAvailableAppointmentMenu() throws ParseException {
        int response = 0;
        do {
            System.out.println("\n");
            System.out.println(":: Add Available Appointment");
            System.out.println(":: Select Month ");
            for (int i =0; i<3; i++){
                int j = i+1;
                System.out.println(j +"."+UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            if(response > 0 && response <4){
                int monthSelected = response;
                System.out.println(monthSelected +" . "+UIMenu.MONTHS[monthSelected-1]);
                System.out.println("Insert the date available:  [dd/mm/yyyy]");
                String date = sc.nextLine();
                System.out.println("Your date is: "+ date+ "\n"+ "1:Correct"+"\n"+"2.Change date");

                int responseDate = Integer.valueOf(sc.nextLine());
                if(responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do{
                    System.out.println(" Insert the time available for date: "+date+ "[16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: "+time+"\n1.Correct \n 2.Change time");
                    responseTime = Integer.valueOf(sc.nextLine());
                }while (responseTime ==2);
                UIMenu.doctorLogeado.addAvailableAppointment(date,time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogeado);
            }else if (response ==0){
                showDoctorMenu();
            }

        }while(response !=0);
    }
    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if(doctor.getAvailableAppointments().size() > 0
                && !doctorsAvailableAppoiments.contains((doctor))){
            doctorsAvailableAppoiments.add(doctor);

        }
    }
    private static void showDoctorMyAppoinment(){
        int response = 0;
        do {
            System.out.println(":: My Appointment");
            if(UIMenu.doctorLogeado.getAvailableAppointments().size() ==0){
                System.out.println("Dont have appointment");
            }
            for (int i = 0; i < UIMenu.doctorLogeado.getAvailableAppointments().size(); i++) {
                int j = i+1;
                System.out.println(j+". "+
                        "Date " +UIMenu.doctorLogeado.getAvailableAppointments().get(i).getDate() +
                        "Time " +UIMenu.doctorLogeado.getAvailableAppointments().get(i).getTime()
                );
            }
            System.out.println("0. Return");
        }while (response!=0);
    }
}


