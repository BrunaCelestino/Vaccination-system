package Service;

import Model.Nurse;

public class NurseService {
    public static void vaccinateCitizen() {

    }

    public static Nurse registerNurse(String name, String CPF) {
        return  new Nurse(name, CPF);
    }
}
