package it.polimi.other;

import it.polimi.other.Data;

public class Main {
    public static void main(String[] args) {
        Data[] d_array = new Data[10];
        int i;

        // Inizializzatione array di date
        for (i = 0; i < 10; i++) {
            Data d = new Data(i + 1, 12 - i, i + 2000);
            d_array[i] = d;
        }

        // Stampa dell'array elemento per elemento
        for (Data d : d_array)
            d.print();

        Data d1 = new Data(1, 1, 1970), d2;

        d2 = d1;

        d1.print();
        d2.print();

        // Modifica sia d1 sia d2
        // (d2 è un riferimento allo stesso oggetto puntato da d1)
        d2.setAnno(2024);

        if (d1 == d2) System.out.println("Gli oggetti sono uguali.");
        else if (d1.equals(d2)) System.out.println("Gli oggetti sono equivalenti.");
        else System.out.println("Gli oggetti non sono nè uguali nè equivalenti.");

        d1.print();
        d2.print();

        d1 = new Data(1, 1, 1970);
        d2 = new Data();
        d1.copyTo(d2);

        if (d1 == d2) System.out.println("Gli oggetti sono uguali.");
        else if (d1.equals(d2)) System.out.println("Gli oggetti sono equivalenti.");
        else System.out.println("Gli oggetti non sono nè uguali nè equivalenti.");

        // Modifica solo d2
        // (il valore degli attributi di d1 è stato copiato in d2)
        d2.setAnno(2024);

        d1.print();
        d2.print();
    }
}