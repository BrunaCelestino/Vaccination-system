package Service;
import Model.Citizen;
import Model.Nurse;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static Menu.CitizenMenu.initialMenu;


public class CitizenService {
    public static Citizen registerCitizen(String name, String CPF, LocalDate firstShot, LocalDate secondShot, LocalDate thirdShot, LocalDate fourthShot) {
        return new Citizen(name, CPF, firstShot, secondShot, thirdShot, fourthShot);
    }

    public static boolean checkVaccinationDates(LocalDate firstDate, LocalDate secondDate) {
        long difference = ChronoUnit.MONTHS.between(firstDate, secondDate);
        if (difference < 4) {
            System.out.println("O cidadão ainda não tem direito a uma nova dose. O prazo para uma nova dose é de 4 meses.");

            return false;

        } else {
            return true;
        }
    }

}
