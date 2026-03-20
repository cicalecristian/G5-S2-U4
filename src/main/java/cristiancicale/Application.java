package cristiancicale;

import cristiancicale.entities.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();

        // VIDEOGIOCHI
        Videogioco fifa = new Videogioco("FIFA 23", 2022, 59.99, Piattaforma.PS5, 20, Genere.SPORT);
        Videogioco mario = new Videogioco("Mario Kart", 2018, 49.99, Piattaforma.SWITCH, 15, Genere.SPORT);
        Videogioco zelda = new Videogioco("Zelda: Breath of the Wild", 2017, 69.99, Piattaforma.SWITCH, 50, Genere.AVVENTURA);
        Videogioco cod = new Videogioco("Call of Duty", 2021, 59.99, Piattaforma.PC, 30, Genere.AZIONE);
        Videogioco halo = new Videogioco("Halo Infinite", 2021, 59.99, Piattaforma.XBOX_SERIES_X, 35, Genere.AZIONE);
        Videogioco gta = new Videogioco("GTA V", 2015, 39.99, Piattaforma.PC, 40, Genere.AVVENTURA);
        Videogioco fc24 = new Videogioco("FIFA 24", 2023, 69.99, Piattaforma.PS5, 25, Genere.SPORT);
        Videogioco marioParty = new Videogioco("Mario Party", 2020, 49.99, Piattaforma.SWITCH, 20, Genere.AVVENTURA);
        Videogioco minecraft = new Videogioco("Minecraft", 2019, 26.99, Piattaforma.PC, 100, Genere.AVVENTURA);
        Videogioco cyberpunk = new Videogioco("Cyberpunk 2077", 2020, 59.99, Piattaforma.PC, 60, Genere.AVVENTURA);

        collezione.aggiungiGioco(fifa);
        collezione.aggiungiGioco(mario);
        collezione.aggiungiGioco(zelda);
        collezione.aggiungiGioco(cod);
        collezione.aggiungiGioco(halo);
        collezione.aggiungiGioco(gta);
        collezione.aggiungiGioco(fc24);
        collezione.aggiungiGioco(marioParty);
        collezione.aggiungiGioco(minecraft);
        collezione.aggiungiGioco(cyberpunk);

        // GIOCHI DA TAVOLO
        GiocoDaTavolo monopoly = new GiocoDaTavolo("Monopoly", 4, 29.99, 5, 2021);
        GiocoDaTavolo scacchi = new GiocoDaTavolo("Scacchi", 2, 19.99, 6, 2020);
        GiocoDaTavolo risiko = new GiocoDaTavolo("Risiko", 6, 34.99, 6, 2019);
        GiocoDaTavolo cluedo = new GiocoDaTavolo("Cluedo", 3, 24.99, 4, 2018);
        GiocoDaTavolo scala40 = new GiocoDaTavolo("Scala 40", 4, 14.99, 4, 2017);
        GiocoDaTavolo taboo = new GiocoDaTavolo("Taboo", 5, 19.99, 5, 2020);
        GiocoDaTavolo pictionary = new GiocoDaTavolo("Pictionary", 4, 22.99, 6, 2019);
        GiocoDaTavolo jenga = new GiocoDaTavolo("Jenga", 2, 12.99, 2, 2016);
        GiocoDaTavolo risiko2 = new GiocoDaTavolo("Risiko 2020", 5, 36.99, 5, 2020);
        GiocoDaTavolo scacchiPro = new GiocoDaTavolo("Scacchi Pro", 2, 39.99, 2, 2021);

        collezione.aggiungiGioco(monopoly);
        collezione.aggiungiGioco(scacchi);
        collezione.aggiungiGioco(risiko);
        collezione.aggiungiGioco(cluedo);
        collezione.aggiungiGioco(scala40);
        collezione.aggiungiGioco(taboo);
        collezione.aggiungiGioco(pictionary);
        collezione.aggiungiGioco(jenga);
        collezione.aggiungiGioco(risiko2);
        collezione.aggiungiGioco(scacchiPro);

        boolean continua = true;

        while (continua) {
            System.out.println("\nScegli un'operazione:");
            System.out.println("1 - Aggiungi gioco");
            System.out.println("2 - Cerca per ID");
            System.out.println("3 - Cerca per prezzo (inferiore)");
            System.out.println("4 - Cerca per numero giocatori (solo giochi da tavolo)");
            System.out.println("5 - Aggiorna gioco per ID");
            System.out.println("6 - Rimuovi gioco per ID");
            System.out.println("7 - Statistiche");
            System.out.println("0 - Esci");

            int scelta;

            while (true) {
                System.out.println("Inserisci una scelta numerica: ");
                try {
                    scelta = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Errore: devi inserire un numero intero.");
                }
            }

            switch (scelta) {
                case 1:
                    String tipo;
                    while (true) {
                        System.out.print("Vuoi inserire un Videogioco (v) o GiocoDaTavolo (t)? ");
                        tipo = scanner.nextLine().trim().toLowerCase();

                        if (tipo.equals("v")) {
                            System.out.print("Titolo: ");
                            String titolo = scanner.nextLine();

                            double prezzo;
                            while (true) {
                                try {
                                    System.out.print("Prezzo: ");
                                    prezzo = Double.parseDouble(scanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Inserisci un numero valido per il prezzo!");
                                }
                            }

                            int anno;
                            while (true) {
                                try {
                                    System.out.print("Anno pubblicazione: ");
                                    anno = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Inserisci un numero valido per l'anno!");
                                }
                            }

                            Piattaforma piattaforma;
                            while (true) {
                                try {
                                    System.out.print("Piattaforma (PC, PS5, XBOX_SERIES_X, XBOX_SERIES_S, SWITCH): ");
                                    piattaforma = Piattaforma.valueOf(scanner.nextLine().toUpperCase());
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("inserisci una piattaforma esistente!");
                                }
                            }

                            int durata;
                            while (true) {
                                try {
                                    System.out.print("Durata in ore: ");
                                    durata = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("inserisci un numero valido per la durata");
                                }
                            }

                            Genere genere;
                            while (true) {
                                try {
                                    System.out.print("Genere (AZIONE, AVVENTURA, SPARATUTTO, SPORT, HORROR): ");
                                    genere = Genere.valueOf(scanner.nextLine().toUpperCase());
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("inserisci un genere esistente!");
                                }
                            }

                            Videogioco v = new Videogioco(titolo, anno, prezzo, piattaforma, durata, genere);
                            collezione.aggiungiGioco(v);
                            break;

                        } else if (tipo.equals("t")) {
                            System.out.print("Titolo: ");
                            String titolo = scanner.nextLine();

                            double prezzo;
                            while (true) {
                                try {
                                    System.out.print("Prezzo: ");
                                    prezzo = Double.parseDouble(scanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Inserisci un numero valido per il prezzo!");
                                }
                            }

                            int anno;
                            while (true) {
                                try {
                                    System.out.print("Anno pubblicazione: ");
                                    anno = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Inserisci un numero valido per l'anno!");
                                }
                            }

                            System.out.print("Numero giocatori: ");
                            int numGiocatori = Integer.parseInt(scanner.nextLine());

                            System.out.print("Durata in minuti: ");
                            int durata = Integer.parseInt(scanner.nextLine());

                            GiocoDaTavolo t = new GiocoDaTavolo(titolo, anno, prezzo, numGiocatori, durata);
                            collezione.aggiungiGioco(t);
                            break;

                        } else {
                            System.out.println("Valore inesistente! Devi inserire 'v' o 't'. Riprova.");
                        }
                    }
                    break;

                case 2:
                    int id;

                    while (true) {
                        try {
                            System.out.print("Inserisci ID: ");
                            id = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Errore: inserisci un numero valido!");
                        }
                    }
                    Optional<Gioco> gioco = collezione.ricercaPerID(id);
                    if (gioco.isPresent()) {
                        System.out.println(gioco.get());
                    } else {
                        System.out.println("Gioco non trovato");
                    }
                    break;

                case 3:
                    double maxPrezzo;

                    while (true) {
                        try {
                            System.out.print("Prezzo massimo: ");
                            maxPrezzo = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Errore: inserisci un numero valido!");
                        }
                    }
                    List<Gioco> risultatiPrezzo = collezione.ricercaPerPrezzo(maxPrezzo);
                    risultatiPrezzo.forEach(System.out::println);
                    break;

                case 4:
                    int numero;

                    while (true) {
                        try {
                            System.out.print("Numero giocatori: ");
                            numero = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println();
                        }
                    }
                    List<GiocoDaTavolo> risultatiNum = collezione.cercaPerNumeroGiocatori(numero);
                    risultatiNum.forEach(System.out::println);
                    break;

                case 5:
                    int idAgg;

                    while (true) {
                        try {
                            System.out.print("ID del gioco da aggiornare: ");
                            idAgg = Integer.parseInt(scanner.nextLine());

                            if (collezione.ricercaPerID(idAgg).isEmpty()) {
                                System.out.println("ID non trovato! Riprova.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Inserisci un ID valido!");
                        }
                    }

                    Gioco g = collezione.ricercaPerID(idAgg).get();

                    System.out.print("Nuovo titolo (lascia vuoto per non modificare): ");
                    String nuovoTitolo = scanner.nextLine();
                    nuovoTitolo = nuovoTitolo.isEmpty() ? null : nuovoTitolo;

                    Integer annoAgg;
                    while (true) {
                        try {
                            System.out.print("Nuovo anno (0 per non modificare): ");
                            int nuovoAnno = Integer.parseInt(scanner.nextLine());
                            annoAgg = (nuovoAnno == 0) ? null : nuovoAnno;
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Inserisci un anno valido!");
                        }
                    }

                    Double prezzoAgg;
                    while (true) {
                        try {
                            System.out.print("Nuovo prezzo (0 per non modificare): ");
                            double nuovoPrezzo = Double.parseDouble(scanner.nextLine());
                            prezzoAgg = (nuovoPrezzo == 0) ? null : nuovoPrezzo;
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Inserisci un prezzo valido!");
                        }
                    }

                    Piattaforma piattaformaAgg = null;
                    Integer durataOreAgg = 0;
                    Genere genereAgg = null;

                    if (g instanceof Videogioco) {

                        System.out.print("Nuova piattaforma (vuoto per non modificare): ");
                        while (true) {
                            try {
                                String platInput = scanner.nextLine();
                                if (platInput.isEmpty()) break;
                                piattaformaAgg = Piattaforma.valueOf(platInput.toUpperCase());
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Piattaforma non valida! Riprova:");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("Nuova durata in ore (0 per non modificare): ");
                                int durata = Integer.parseInt(scanner.nextLine());
                                durataOreAgg = (durata == 0) ? null : durata;
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Inserisci un numero valido!");
                            }
                        }

                        System.out.print("Nuovo genere (vuoto per non modificare): ");
                        while (true) {
                            try {
                                String nuovoGenere = scanner.nextLine();
                                if (nuovoGenere.isEmpty()) break;
                                genereAgg = Genere.valueOf(nuovoGenere.toUpperCase());
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Genere non valido! Riprova:");
                            }
                        }
                    }

                    Integer numGiocatoriAgg = 0;
                    Integer durataMinAgg = 0;

                    if (g instanceof GiocoDaTavolo) {

                        while (true) {
                            try {
                                System.out.print("Nuovo numero giocatori (0 per non modificare): ");
                                int num = Integer.parseInt(scanner.nextLine());
                                numGiocatoriAgg = (num == 0) ? null : num;
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Inserisci un numero valido!");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("Nuova durata in minuti (0 per non modificare): ");
                                int durata = Integer.parseInt(scanner.nextLine());
                                durataMinAgg = (durata == 0) ? null : durata;
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Inserisci un numero valido!");
                            }
                        }
                    }

                    boolean aggiornato = collezione.aggiornaPerID(
                            idAgg, nuovoTitolo, annoAgg, prezzoAgg,
                            piattaformaAgg, durataOreAgg, genereAgg,
                            numGiocatoriAgg, durataMinAgg
                    );

                    if (aggiornato) System.out.println("Aggiornamento riuscito");
                    break;

                case 6:
                    System.out.print("ID del gioco da rimuovere: ");
                    int idRimuovi = Integer.parseInt(scanner.nextLine());
                    boolean rimosso = collezione.rimozionePerID(idRimuovi);
                    System.out.println(rimosso ? "Gioco rimosso" : "ID non trovato");
                    break;

                case 7:
                    if (!collezione.getGiochi().isEmpty()) {
                        collezione.statistiche();
                        break;
                    } else {
                        System.out.println("la collezione è vuota!");
                    }

                case 0:
                    continua = false;
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        }
        scanner.close();
    }
}
