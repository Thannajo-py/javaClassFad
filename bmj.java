import java.util.Scanner;

public class bmj {

        static Cartes[] deck = Cartes.values();
        public static Cartes[] joueur1;
        public static Cartes[] joueur2;
        public static String nomJoueur1;
        public static String nomJoueur2;

        public static Cartes[] initCartes(Cartes[] arrayJoueurs)
        {
            return deck;
        }


        public static int tirerUneCartes(int length)
        {
            return (int) (Math.random() * length);
            //exemple : Cartes jouer1 = joueur1[tirerUneCartes(joueur1.length)];
        }


        public static void quiGagneLeTour(int jouer1, int jouer2)
        {
            Cartes carteJoueur1 = joueur1[jouer1];
            Cartes carteJoueur2 = joueur2[jouer2];

            if(carteJoueur1.compareTo(carteJoueur2) > 0)
            {
                transfererCarte(carteJoueur2, 1, jouer1, jouer2);
                afficherTour(nomJoueur1, nomJoueur2, carteJoueur2, carteJoueur1, joueur2.length);
            }
            else if(carteJoueur1.compareTo(carteJoueur2) < 0)
            {
                transfererCarte(carteJoueur1, -1, jouer1, jouer2);
                afficherTour(nomJoueur2, nomJoueur1 , carteJoueur1, carteJoueur2, joueur1.length);

            }
            else
            {
                transfererCarte(carteJoueur1, 0, jouer1, jouer2);
                afficherTour(nomJoueur1 , nomJoueur2, carteJoueur2, carteJoueur1, -1);

            }

        }


        public static void transfererCarte(Cartes perdante, int vainqueur, int emplacement1, int emplacement2)
        {
            switch (vainqueur)
            {
                case 1:
                    joueur1 = gagnerUneCarte(joueur1, perdante);
                    joueur2 = perdreUneCarte(joueur2, emplacement2);
                    break;
                case -1:
                    joueur2 =  gagnerUneCarte(joueur2, perdante);
                    joueur1 = perdreUneCarte(joueur1, emplacement1);
                    break;
                case 0:
                    joueur2 = perdreUneCarte(joueur2, emplacement2);
                    joueur1 = perdreUneCarte(joueur1, emplacement1);
                    break;
            }
        }


        public static Cartes[] gagnerUneCarte(Cartes[] joueur, Cartes perdante)
        {
            Cartes[] arrayGagnante = new Cartes[joueur.length + 1];
            for(int i = 0; i < joueur.length; i++)
            {
                arrayGagnante[i] = joueur[i];
            }
            arrayGagnante[arrayGagnante.length-1] = perdante;
            return  arrayGagnante;
        }

        public  static Cartes[] perdreUneCarte(Cartes[] joueur, int emplacement)
        {
            Cartes[] arrayPerdante = new Cartes[joueur.length - 1];
            int e = 0;
            int i = 0;
            while(e < arrayPerdante.length)
            {
                if (i == emplacement){
                    i++;
                    continue;
                }
                arrayPerdante[e] = joueur[i];
                i++;
                e++;
            }
            return arrayPerdante;
        }

        public static void afficherTour(String gagnant, String perdant , Cartes perdante, Cartes gagnante, int taillePerdant)
        {
            if(taillePerdant > -1)
            {
                System.out.println(gagnant+" a battu "+ perdante +" du "+ perdant + " grace à son "+ gagnante + ".\n"+perdant+" a encore "+taillePerdant+ (taillePerdant>1? " cartes ":" carte ") /* J'espère que tu es fier de nous :p */+ "en mains");
            }
            else
            {
                System.out.println("Egalité ! "+nomJoueur1+ " et "+ nomJoueur2+" perdent leur carte "+ perdante);
            }
        }

        public static void play()
        {
            Scanner nomJoueurs = new Scanner(System.in);

            System.out.println("Veuillez entrer le nom du joueur 1 :");
            nomJoueur1 = nomJoueurs.nextLine();

            System.out.println("Veuillez entrer le nom du joueur 2 :");
            nomJoueur2 = nomJoueurs.nextLine();


            joueur1 = initCartes(joueur1);
            joueur2 = initCartes(joueur2);
            long temps = System.currentTimeMillis();
            while (joueur1.length != 0 && joueur2.length != 0)
            {
                int emplacementJoueur1 = tirerUneCartes(joueur1.length);
                int emplacementJoueur2 = tirerUneCartes(joueur2.length);


                quiGagneLeTour(emplacementJoueur1,emplacementJoueur2);
            }

            System.out.println((joueur1.length == 0 && joueur2.length == 0? "égalité bande de gros nullos!":(joueur1.length == 0? nomJoueur2+" a gagné ! :)":nomJoueur1+" a gagné ! :)")));
            System.out.println("Temps total de la partie: " + (System.currentTimeMillis() - temps) + " ms.");

        }
        public static void main (String[] args)
        {
            System.out.println("Bienvenue dans le jeux de bataille super cool");
            play();
        }

    }

    enum Cartes{
        as,
        deux,
        trois,
        quatre,
        cinq,
        six,
        sept,
        huit,
        neuf,
        dix,
        valet,
        dame,
        roi
    }

