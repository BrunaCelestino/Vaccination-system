package Utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static Menu.NurseMenu.initialMenu;

public class GeneralUtils {
    public static LocalDate formatDates(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date, formatter);
        } catch(DateTimeParseException e) {
            System.err.println("Data inserida possui formato inválido. Formato aceito: DD/MM/AAAA");
            initialMenu();
        }
        return  null;
    }

    public static void showProgressBar() throws IOException, InterruptedException {
        String anim= "|/-\\";
        for (int x =0 ; x < 100 ; x++) {
            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;


            if(x == 99) {
                System.out.println();
            } else {
                System.out.write(data.getBytes());
            }
            Thread.sleep(100);
        }
    }
}
