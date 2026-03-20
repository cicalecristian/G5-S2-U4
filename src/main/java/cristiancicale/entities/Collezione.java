package cristiancicale.entities;

import java.util.*;

public class Collezione {

    private Map<Integer, Gioco> giochi = new HashMap<>();

    public Map<Integer, Gioco> getGiochi() {
        return giochi;
    }

    // Aggiunta gioco
    public boolean aggiungiGioco(Gioco gioco) {
        if (giochi.containsKey(gioco.getId()))
            return false;
        giochi.put(gioco.getId(), gioco);
        return true;
    }

    // Ricerca per ID
    public Optional<Gioco> ricercaPerID(int ID) {
        return Optional.ofNullable(giochi.get(ID));
    }

    // Ricerca per prezzo
    public List<Gioco> ricercaPerPrezzo(double prezzoMax) {
        return giochi.values().stream()
                .filter(gioco -> gioco.getPrezzo() <= prezzoMax)
                .toList();
    }

    // Ricerca per numero giocatori
    public List<GiocoDaTavolo> cercaPerNumeroGiocatori(int numero) {
        return giochi.values().stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g)
                .filter(t -> t.getNumeroGiocatori() == numero)
                .toList();
    }

    // Rimozione per id
    public boolean rimozionePerID(int ID) {
        return giochi.remove(ID) != null;
    }

    // Aggiorna per id
    public boolean aggiornaPerID(int ID, String nuovoTitolo, Integer nuovoAnnoPubblicazione, Double nuovoPrezzo,
                                 Piattaforma piattaforma, Integer durataInOre, Genere genere,
                                 Integer numeroGiocatori, Integer durataInMin) {
        Gioco gioco = giochi.get(ID);
        if (gioco == null) return false;

        if (nuovoTitolo != null) {
            gioco.setTitolo(nuovoTitolo);
        }
        if (nuovoAnnoPubblicazione != null) {
            gioco.setAnnoPubblicazione(nuovoAnnoPubblicazione);
        }
        if (nuovoPrezzo != null) {
            gioco.setPrezzo(nuovoPrezzo);
        }

        if (gioco instanceof Videogioco videogioco) {
            if (piattaforma != null)
                videogioco.setPiattaforma(piattaforma);
            if (durataInOre != null)
                videogioco.setDurataInOre(durataInOre);
            if (genere != null)
                videogioco.setGenere(genere);
        }

        if (gioco instanceof GiocoDaTavolo giocoDaTavolo) {
            if (numeroGiocatori != null) {
                giocoDaTavolo.setNumeroGiocatori(numeroGiocatori);
            }
            if (durataInMin != null) {
                giocoDaTavolo.setDurataInMin(durataInMin);
            }
        }
        return true;
    }

    // Statistiche
    public void statistiche() {
        int totaleVideogiochi = (int)
                giochi.values().stream()
                        .filter(gioco -> gioco instanceof Videogioco)
                        .count();

        int totaleGiochiDaTavolo = (int)
                giochi.values().stream()
                        .filter(gioco -> gioco instanceof GiocoDaTavolo)
                        .count();

        System.out.println("Totale videogiochi: " + totaleVideogiochi);
        System.out.println("Totale giochi da tavolo: " + totaleGiochiDaTavolo);

        Optional<Gioco> giocoPiuCostoso = giochi.values().stream()
                .max(Comparator.comparingDouble(Gioco::getPrezzo));

        giocoPiuCostoso.ifPresent(g -> System.out.println(
                "Gioco più costoso: " + g.getTitolo() + " | Prezzo: " + g.getPrezzo()
        ));

        double prezzoMedio = giochi.values().stream()
                .mapToDouble(Gioco::getPrezzo)
                .average()
                .orElse(0.0);

        System.out.println("Prezzo medio della collezione: " + prezzoMedio);
    }

    @Override
    public String toString() {
        return "Collezione{" +
                "giochi=" + giochi +
                '}';
    }
}
