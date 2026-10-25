package RPG;

public class Bichinho {

    private String nome;
    private int fome;
    private int energia;
    private int felicidade;

    public Bichinho(String nome) {
        this.nome = nome;
        fome = 50;
        energia = 100;
        felicidade = 50;
    }

    public void alimentar() {
        fome = Math.max(0, fome - 30);
        felicidade = Math.min(100, felicidade + 5);
    }

    public void brincar() {
        if (fome == 100) {
            System.out.println(nome + " esta doente e nao quer brincar");
        } else {
            felicidade = Math.min(100, felicidade + 20);
            energia = Math.max(0, energia - 15);
            fome = Math.min(100, fome + 10);
        }
    }

    public void dormir() {
        energia = 100;
        fome = Math.min(100, fome + 20);
    }

    public boolean estaFeliz() {
        if (felicidade >= 70) {
            return true;
        } else {
            return false;
        }
    }

    public void status() {
        System.out.println("Nome: " + nome);
        System.out.println("Fome: " + fome);
        System.out.println("Energia: " + energia);
        System.out.println("Felicidade: " + felicidade);
        System.out.println();
    }
}
