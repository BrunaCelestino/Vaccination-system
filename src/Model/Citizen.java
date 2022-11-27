package Model;
import java.time.LocalDate;
import java.util.ArrayList;


public class Citizen extends Person{
    private LocalDate firstShot;
    private LocalDate secondShot;
    private LocalDate thirdShot;
    private LocalDate fourthShot;

    private static ArrayList<Citizen> citizenList = new ArrayList<Citizen>();

    public Citizen(String name, String CPF, LocalDate firstShot, LocalDate secondShot, LocalDate thirdShot, LocalDate fourthShot) {
        super(name, CPF);
        this.firstShot = firstShot;
        this.secondShot = secondShot;
        this.thirdShot = thirdShot;
        this.fourthShot = fourthShot;
    }


    public static void printCitizenList(){
        if(citizenList.isEmpty()){
            System.out.println("A lista de cidadãos vacinados está vazia!");
            System.out.println();
        } else {

            System.out.println(citizenList);
            System.out.println();
        }

    }

    public static void addCitizenList(Citizen citizen) {
        Citizen.citizenList.add(citizen);

    }

    @Override
    public String toString() {
        return "Cidadão: [ " +
                super.toString() +
                ", data da primeira dose: " + firstShot +
                ", data da segunda dose: " + secondShot +
                ", data da terceira dose: " + thirdShot +
                ", data da quarta dose: " + fourthShot +
                " ]";
    }
}
