package modelos;

public class Nurse extends User{
    private String speciality;
    public Nurse(String name, String email){

        super(name,email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    @Override
    public void showDataUser() {
        System.out.println("Hopital: Cruz Verda");

        System.out.println("Departamento: Pediatra, Nutriniologia");
    }
}
