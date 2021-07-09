package com.adrar;

public class Animal {
    public static void main(String[] args){
        Animal unAnimal = new Animal();
        unAnimal.courir();


        Chat leChat = new Chat();
        leChat.nom = "smelly cat";
        leChat.miauler();
        leChat.courir();

        Chien leChien = new Chien();
        leChien.nom = "PeaBody";
        leChien.aboyer();
        leChien.courir();

        System.out.println(unAnimal instanceof Animal);
        System.out.println(leChat instanceof Animal);
        System.out.println(leChat instanceof Chat);
        System.out.println(unAnimal instanceof Chat);
    }
    public String nom;

    public void courir(){
        System.out.println("Tagada tagada tagada");
    }
}



