package Model;

public class Nurse extends Person{
    public Nurse(String name, String CPF) {
        super(name, CPF);
    }

    @Override
    public String toString() {
        return "Enfermeira: [ " +
                super.toString() +
                " ]";
    }
}
