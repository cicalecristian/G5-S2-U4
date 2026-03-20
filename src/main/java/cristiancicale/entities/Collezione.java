package cristiancicale.entities;

public abstract class Collezione {
    private static int contatore = 0;
    private int id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Collezione(String titolo, int annoPubblicazione, double prezzo) {
        this.id = ++contatore;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }
}
