package cristiancicale.entities;

public class GiocoDaTavolo extends Collezione {

    private int numeroGiocatori;
    private int durataInMin;

    public GiocoDaTavolo(String titolo, int annoPubblicazione, double prezzo, int numeroGiocatori, int durataInMin) {
        super(titolo, annoPubblicazione, prezzo);
        this.durataInMin = durataInMin;

        setNumeroGiocatori(numeroGiocatori);
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        if (numeroGiocatori < 2 || numeroGiocatori > 10) {
            throw new IllegalArgumentException("Numero giocatori deve essere tra 2 e 10");
        }
        this.numeroGiocatori = numeroGiocatori;
    }

    public int getDurataInMin() {
        return durataInMin;
    }
}
