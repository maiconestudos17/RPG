package RPG;

public class Main {
    public static void main(String[] args) {

        Bichinho b = new Bichinho("Tobby");

        System.out.println("Inicio do dia");
        b.status();

        System.out.println("Tobby foi brincar");
        b.brincar();
        b.status();

        System.out.println("Tobby foi comer");
        b.alimentar();
        b.status();

        System.out.println("Tobby foi dormir");
        b.dormir();
        b.status();

        if (b.estaFeliz()) {
            System.out.println("Tobby esta feliz");
        } else {
            System.out.println("Tobby nao esta feliz");
        }
    }
}
