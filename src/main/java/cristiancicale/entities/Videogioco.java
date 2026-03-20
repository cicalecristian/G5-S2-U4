package cristiancicale.entities;

public class Videogioco extends Collezione {

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

    public int getDurata() {
        return durataInOre;
    }

    public Genere getGenere() {
        return genere;
    }
}

