package modelos;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    private double weigth;
    private double heigt;
    private String blood;
    private String birthday;

    public Patient(String name, String email) {
        super(name, email);
        System.out.println("El nombre del Paciente registrado es: " + name);
    }

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date,time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private  ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();
    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public double getHeigt() {
        return heigt;
    }

    public void setHeigt(double heigt) {
        this.heigt = heigt;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return super.toString()+"Birthay: "
                + birthday + ", weigth: " + getWeigth()
                + "\nheigt:" + getHeigt() + ".blood: " + blood;
    }

    @Override
    public void showDataUser() {

        System.out.println("Paciente");
        System.out.println("Histroial completo desde el inicio");
    }
}
