package Model;

public abstract class Person {
    private String name;
    private String CPF;

    public String getName() {
        return name;
    }

    public String getCPF() {
        return CPF;
    }

    public Person(String name, String CPF) {
        this.name = name;
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return
                "nome: " + name +
                        ", CPF: " + CPF;
    }
}
