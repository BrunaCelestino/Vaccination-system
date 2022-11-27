package Menu;
import java.util.Scanner;

import static Menu.SystemMenu.systemMenu;
import static Service.NurseService.registerNurse;
import static Utils.CPFValidation.*;

public class NurseMenu {
    public static Scanner input = new Scanner(System.in);
    public static void initialMenu()  {
        System.out.println("Insira o nome da enfermeira");
        String name = input.nextLine();

        System.out.println("Insira o CPF da enfermeira");
        String CPF = input.nextLine();
        validateCPF(CPF);

        while (!validateCPF(CPF)) {
            System.err.println("CPF Inválido! Insira um CPF válido.");
            System.out.println("Insira o CPF da enfermeira");
            CPF = input.nextLine();
            if(validateCPF(CPF)){
                break;
            };
        }
        registerNurse(name, CPF);
        systemMenu(registerNurse(name, CPF));



    }

}
