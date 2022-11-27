package Test;

import Model.Citizen;

import java.io.IOException;
import java.time.LocalDate;

import static Model.Citizen.addCitizenList;
import static Model.Citizen.printCitizenList;
import static Service.CitizenService.checkVaccinationDates;
import static Utils.GeneralUtils.formatDates;
import static Utils.GeneralUtils.showProgressBar;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
//        checkVaccinationDates(formatDates("22/06/2022"), LocalDate.now());
        Citizen citizen = new Citizen("Felipe", "392.800.538-33", formatDates("22/06/2022"), formatDates("22/06/2022"), formatDates("22/06/2022"), formatDates("22/06/2022"));
        System.out.println(citizen);
        addCitizenList(citizen);
        printCitizenList();
        showProgressBar();
    }
}
