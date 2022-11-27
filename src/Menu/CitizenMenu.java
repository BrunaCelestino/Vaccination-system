package Menu;

import Model.Nurse;

import java.time.LocalDate;
import java.util.Scanner;

import static Menu.SystemMenu.systemMenu;
import static Model.Citizen.addCitizenList;
import static Service.CitizenService.checkVaccinationDates;
import static Service.CitizenService.registerCitizen;
import static Utils.CPFValidation.validateCPF;
import static Utils.DateValidation.validateDate;
import static Utils.GeneralUtils.formatDates;

public class CitizenMenu {
    public static Scanner input = new Scanner(System.in);
    public static void initialMenu(Nurse nurse)  {
        System.out.println("Insira o nome do cidadão");
        String name = input.nextLine();

        System.out.println("Insira o CPF do cidadão");
        String CPF = input.nextLine();
        validateCPF(CPF);

        while (!validateCPF(CPF)) {
            System.err.println("CPF Inválido! Insira um CPF válido.");
            System.out.println("Insira o CPF do cidadão");
            CPF = input.nextLine();
            if(validateCPF(CPF)){
                break;
            };
        }

        getVaccinationDates(name, CPF, nurse);

    }

    public static void getVaccinationDates(String name, String CPF, Nurse nurse ) {
        System.out.println("Insira a data da primeira vacina: formato DD/MM/AAAA");
        String firstShot = input.nextLine();

        while (!validateDate(firstShot)) {
            System.err.println("Data Inválida! Insira um data válida.");
            System.out.println("Insira a data da primeira dose");
            firstShot = input.nextLine();

            if (validateDate(firstShot)) {
                break;
            }
        }
        LocalDate firstShotDate = formatDates(firstShot);

        System.out.println("Insira a data da segunda vacina: formato DD/MM/AAAA");
        String secondShot = input.nextLine();


        while (!validateDate(secondShot)) {
            System.err.println("Data Inválida! Insira um data válida.");
            System.out.println("Insira a data da segunda dose");
            secondShot = input.nextLine();

            if (validateDate(secondShot)) {
                break;
            }

        }
        LocalDate secondShotDate = formatDates(secondShot);
        if(!checkVaccinationDates(firstShotDate,secondShotDate)){
            systemMenu(nurse);
        }

        System.out.println("Insira a data da terceira vacina: formato DD/MM/AAAA");
        String thirdShot = input.nextLine();


        while (!validateDate(thirdShot)) {
            System.err.println("Data Inválida! Insira um data válida.");
            System.out.println("Insira a data da terceira dose");
            thirdShot = input.nextLine();

            if (validateDate(thirdShot)) {

                break;
            }

        }

        LocalDate thirdShotDate = formatDates(thirdShot);
        if(!checkVaccinationDates(secondShotDate, thirdShotDate)){
            systemMenu(nurse);
        }


        System.out.println("Insira a data da quarta vacina: formato DD/MM/AAAA");
        String fourthShot = input.nextLine();

        while (!validateDate(fourthShot)) {
            System.err.println("Data Inválida! Insira um data válida.");
            System.out.println("Insira a data da quarta dose");
            fourthShot = input.nextLine();
            if (validateDate(fourthShot)) {
                break;
            }
        }

        LocalDate fourthShotDate = formatDates(fourthShot);

        if(!checkVaccinationDates(thirdShotDate, fourthShotDate)){
            systemMenu(nurse);
        }

        if(checkVaccinationDates(fourthShotDate, LocalDate.now())) {
            addCitizenList(registerCitizen(name, CPF, firstShotDate, secondShotDate, thirdShotDate, fourthShotDate));
            System.out.println("Cidadão vacinado com sucesso!");
            systemMenu(nurse);
        } else {
            systemMenu(nurse);
        }

    }
}

