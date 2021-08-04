package ui;

import modelos.Doctor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatieneMenu {
    public static void showPatientMenu() throws ParseException {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: " +UIMenu.patientLogeado.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppoinment();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while(response !=0);
    }
    private static void showBookAppointmentMenu() throws ParseException {
        int response = 0;
        do {
            System.out.println("::Book an appoinment");
            System.out.println(":: Select date : ");
            // Aplicacion de map
            // numeracion de fechas de la lista
            // tendra el indice de la fecha seleccionada
            //[doctors]
            // 1.-doctor1   fecha1 // fecha2
            // 2.-doctor2   fecha2
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i< UIDoctorMenu.doctorsAvailableAppoiments.size(); i++){
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppoiments.get(i).getAvailableAppointments();
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size() ; j++) {
                    k++;
                    System.out.println(k+ "."+availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j),UIDoctorMenu.doctorsAvailableAppoiments.get(i));
                    doctors.put(Integer.valueOf(k),doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
           int  responseDateSelected = Integer.valueOf(sc.nextLine());
           Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
           Integer indexDate = 0;
           Doctor doctorSelected = new Doctor("", "");
           for (Map.Entry<Integer, Doctor> doc:doctorAvailableSelected.entrySet()) {
               indexDate = doc.getKey();
               doctorSelected = doc.getValue();
           }
            System.out.println(doctorSelected.getName()+
                    "Fecha" + doctorSelected.getAvailableAppointments().get(indexDate).getDate()+
                    ".Time" + doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            System.out.println("Confirm your appointment :\n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());
            if(response == 1){
                UIMenu.patientLogeado.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }
        }while (response !=0);
    }
    private static  void showPatientMyAppoinment (){
        int response = 0;
        do {
            System.out.println(":: My Appointment");
            if(UIMenu.patientLogeado.getAppointmentDoctors().size() == 0)
            {
                System.out.println("Dont have appoinment");
            }
            for (int i = 0; i < UIMenu.patientLogeado.getAppointmentDoctors().size(); i++) {
                int j = i+1;
                System.out.println(j+ ". "+
                        "Date" +UIMenu.patientLogeado.getAppointmentDoctors().get(i).getDate()+
                        "Time: "+UIMenu.patientLogeado.getAppointmentDoctors().get(i).getTime()+
                        "\n Doctor: "+UIMenu.patientLogeado.getAppointmentDoctors().get(i).getDoctor().getName());
            }
            System.out.println("0. Return");
        }while (response!=0);
    }
}
