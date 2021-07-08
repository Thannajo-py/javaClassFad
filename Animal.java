public class Animal {
    private String nom;

    public Animal(){
        this("mon nom est personne.");
    }
    public Animal(String nom){
        this.nom = nom;
    }
    public Animal(Animal nom){
        this(nom.nom);
    }
    public void display(){
        System.out.println(this.nom);
    }
    public static void main(String[] args){
        Animal a = new Animal();
        Animal b = new Animal("médor");
        Animal c = new Animal(b);
        a.display();
        b.display();
        c.display();
        b.display();
        c.display();
    }

}
