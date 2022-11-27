package Utils;

import java.util.Arrays;

public class CPFValidation {
    public static boolean validateCPF(String CPF) {
        int sum = 0;
        int rest;


        if (!CPF.matches("^[0-9]{3}(.)[0-9]{3}(.)[0-9]{3}(-)[0-9]{2}$")) {

            return false;
        } else {

            String strCPF = CPF.replace(".", "");
            strCPF = strCPF.replace("-", "");


            String cpfChanged = strCPF;

            if (cpfChanged.length() != 11) {

                return false;

            } else {

                String[] numbers =
                        {" 00000000000",
                                "11111111111",
                                "22222222222",
                                "33333333333",
                                "44444444444",
                                " 55555555555",
                                "66666666666",
                                "77777777777",
                                "88888888888",
                                "99999999999"};

                if (Arrays.asList(numbers).contains(cpfChanged)) {

                    return false;
                } else {

                    for (int i = 1; i <= 9; i += 1)
                        sum += Integer.parseInt(cpfChanged.substring(i - 1, i), 10) * (11 - i);

                    rest = (sum * 10) % 11;

                    if (rest == 10) rest = 0;
                    if (rest != Integer.parseInt(strCPF.substring(9, 10), 10)) {

                        return false;

                    } else {

                        sum = 0;

                        for (int i = 1; i <= 10; i += 1)
                            sum += Integer.parseInt(strCPF.substring(i - 1, i), 10) * (12 - i);
                        rest = (sum * 10) % 11;
                        if (rest == 10) rest = 0;
                        if (rest != Integer.parseInt(strCPF.substring(10, 11), 10)) {

                            return false;
                        } else {


                            return true;
                        }
                    }
                }
            }
        }
    }
}
