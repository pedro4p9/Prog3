package aula3;
import java.util.ArrayList;

public class Animal {
    public class Cachorro{
        public void latir(){
            System.out.println("Au Au");
        }
    }
    public class Gato{
        public void miar(){
            System.out.println("Miau Miau");
        }
    }
    public static void emitirsom(){
        System.out.println("Som de animal");
    }
    public static void main(String[] args){
        ArrayList<Object> animais = new ArrayList<>();
        Animal.Cachorro dog = new Animal().new Cachorro();
        Animal.Gato cat = new Animal().new Gato();
        animais.add(dog);
        animais.add(cat);
        for(Object animal : animais){
            if(animal instanceof Animal.Cachorro){
                ((Animal.Cachorro) animal).latir();
            } else if(animal instanceof Animal.Gato){
                ((Animal.Gato) animal).miar();
            }
        }
    }
}
