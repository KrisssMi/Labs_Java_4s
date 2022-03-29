package by.Minevich.Task_3;

public class CallCenter {
    private int amountOfOperators;
    private Client[] operators;

    public CallCenter(int size) {
        this.amountOfOperators = size;
        this.operators = new Client[size];
    }

    public void showLines() {
        System.out.println("Lines: < ");
        for (int i = 0; i < amountOfOperators; i++) {
            if (operators[i] != null) {             // если поток занят
                System.out.println("\t"+ i + ") " + operators[i].getClientName());
            } else {                                // если поток свободен
                System.out.println("\t"+ i + ") empty");
            }
        }
        System.out.println(" >");
    }

    public void connect(Client client) {
        operators[this.FreeOperator()] = client;
    }

    public void disconnect(Client client) {
        for (int i = 0; i < this.amountOfOperators; i++) {
            if (operators[i] == client) {
                operators[i] = null;
            }
        }
    }

    public int FreeOperator() {             // поиск свободного оператора
        for (int i = 0; i < this.amountOfOperators; i++) {
            if (operators[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
