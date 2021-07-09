package com.adrar;

class Chat extends Animal{
    public void miauler(){
        System.out.println(this.nom + " dit:Miaouuuuuuuuuu!");
        super.courir();
    }
}