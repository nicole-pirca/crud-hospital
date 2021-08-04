package ui;

import modelos.Doctor;
import modelos.Patient;

import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;

public class UIMenu {
    public static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogeado;
    public static Patient patientLogeado;

    public static void showMenu() throws ParseException {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    static void showPatientMenu() throws ParseException {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i + ". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);

    }

    private static void authUser(int userType) throws ParseException {
        //usrType = 1 Doctor
        //usrType = 2 Paciente

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Nicole", "nicole@email.com"));
        doctors.add(new Doctor("Thais", "thais@email.com"));
        doctors.add(new Doctor("Rocio", "rocio@email.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Esperanza Escobar", "esperanza@email.com"));
        patients.add(new Patient("Roberto Perez", "roberto@email.com"));
        patients.add(new Patient("Lilly Aviles", "lilly@email.com"));

        //identificacion si el email es corecto
        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [a@email.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1) {
                for (Doctor d : doctors) {
                    if (d.getEmail().equals(email)) {
                        emailCorrect = true;
                        //obtener los datos del usuario logueado
                        doctorLogeado = d;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (userType == 2) {
                for (Patient p : patients) {
                    if (p.getEmail().equals(email)) {
                        emailCorrect = true;
                        //obtener los datos del usuario logueado
                        patientLogeado = p;
                        UIPatieneMenu.showPatientMenu();
                    }
                }
            }
        } while (!emailCorrect);
    }
}