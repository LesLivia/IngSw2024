package it.polimi.other;

public class Data {
    private int giorno;
    private int mese;
    private int anno;

    private static String format = "dd/MM/yyyy";

    // Inner class per rappresentare l'ora
    class Time {
        int hour, min, sec;

        public Time(int h, int m, int s) {
            this.hour = h;
            this.min = m;
            this.sec = s;
        }
    }

    private Time t;

    public Data(int g, int m, int a) {
        this.giorno = g;
        this.mese = m;
        this.anno = a;
        this.t = new Time(0, 0, 0);
    }

    public Data() {
        this.giorno = 0;
        this.mese = 0;
        this.anno = 0;
        // Osservare il diverso comportamento di other.Main abilitando la riga 35
        // this.t = new Time(0, 0, 0);
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public int getGiorno() {
        return this.giorno;
    }

    public static String getFormat() {
        return format;
    }

    public static void setFormat(String format) {
        Data.format = format;
    }

    public void print() {
        System.out.println(this.giorno + "/" + this.mese + "/" + this.anno + " "
                + this.t.hour + ":" + this.t.min + ":" + this.t.sec);
    }

    public void copyTo(Data other) {
        other.giorno = this.giorno;
        other.mese = this.mese;
        other.anno = this.anno;
    }

    public boolean equals(Data other) {
        return this.giorno == other.giorno && this.mese == other.mese && this.anno == other.anno;
    }
}
