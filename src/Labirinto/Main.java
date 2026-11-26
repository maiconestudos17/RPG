package Labirinto;

// Roda os casos de teste
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Caso 1: caminho direto para a saída ===");
        testar(new Labirinto(
                "S . . # # #",
                "# # . # # #",
                "# # . . # #",
                "# # # . # #",
                "# # # . . E",
                "# # # # # #"));

        System.out.println("=== Caso 2: múltiplos tesouros (rota gulosa) ===");
        testar(new Labirinto(
                "S . . # . .",
                "# # . # . #",
                ". . . . T .",
                ". # # # . #",
                ". . T . . #",
                ". # # # # #",
                "E # # # # #"));

        System.out.println("=== Caso 3: labirinto sem saída ===");
        testar(new Labirinto(
                "S . . # . .",
                "# # . # . #",
                ". . . . T .",
                ". # # # # #",
                ". . T . # E",
                "# # # # # #"));

        System.out.println("=== Caso extra: labirinto do enunciado ===");
        testar(new Labirinto(
                "S . . # . .",
                "# # . # . #",
                ". . . . T .",
                ". # # # . #",
                ". . T . . E",
                "# # # # # #"));
    }

    private static void testar(Labirinto labirinto) {
        labirinto.imprimir();
        new CacadorDeTesouros(labirinto).acharCaminho();
        System.out.println();
    }
}
