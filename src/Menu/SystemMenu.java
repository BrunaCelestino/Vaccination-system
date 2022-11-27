package Menu;

import Model.Nurse;
import java.util.Scanner;

import static Menu.CitizenMenu.initialMenu;
import static Model.Citizen.printCitizenList;


public class SystemMenu {
    public static Scanner input = new Scanner(System.in);

    public static void systemMenu(Nurse nurse)  {
        System.out.println("Bem-vindo(a) " + nurse.getName());
        System.out.println("O que você gostaria de fazer?");

            System.out.println(" -------------------Menu------------------ ");
            System.out.println("|     1 - Vacinar cidadão                 |");
            System.out.println("|     2 - Listar cidadãos vacinados       |");
            System.out.println("|     3 - Sair                            |");
            System.out.println(" ----------------------------------------- ");

        String option = input.nextLine();



        getMenuOption(option, nurse);
    }

    private static void getMenuOption(String option, Nurse nurse) {
        switch (option) {
            case "1":
                initialMenu(nurse);
                break;
            case "2":
                printCitizenList();
                systemMenu(nurse);
                break;
            case "3":
                System.out.println("Até mais!");
                System.exit(0);
            default:
                System.err.println("Opção inválida. Insira uma opção válida");
                getMenuOption(option, nurse);
        }
    }



}
