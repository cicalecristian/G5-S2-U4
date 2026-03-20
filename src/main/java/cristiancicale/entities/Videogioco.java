package cristiancicale.entities;

public class Videogioco extends Gioco {

    private Piattaforma piattaforma;
    private int durataInOre;
    private Genere genere;

    public Videogioco(String titolo, int annoPubblicazione, double prezzo, Piattaforma piattaforma, int durataInOre, Genere genere) {
        super(titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataInOre = durataInOre;
        this.genere = genere;
    }

    public Piattaforma getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(Piattaforma piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getDurata() {
        return durataInOre;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public void setDurataInOre(int durataInOre) {
        this.durataInOre = durataInOre;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "ID: " + getId() +
                ", Titolo: '" + getTitolo() + '\'' +
                ", AnnoPubblicazione: " + getAnnoPubblicazione() +
                ", Prezzo: " + getPrezzo() + '€' +
                ", Piattaforma: " + piattaforma +
                ", Durata: " + durataInOre +
                ", Genere: " + genere +
                '}';
    }
}

