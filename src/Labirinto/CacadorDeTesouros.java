package Labirinto;

import java.util.ArrayList;
import java.util.List;

/*
 Estratégia gulosa: o herói sempre vai até o tesouro mais próximo
 Quando não tem mais tesouro, vai para a saída
 */
public class CacadorDeTesouros {
    private Labirinto labirinto;
    private BuscaRecursiva busca;

    public CacadorDeTesouros(Labirinto labirinto) {
        this.labirinto = labirinto;
        this.busca = new BuscaRecursiva(labirinto);
    }

    public void acharCaminho() {
        Posicao inicio = labirinto.encontrar('S');
        Posicao saida = labirinto.encontrar('E');

        // Verifica se existe saída
        if (inicio == null || saida == null || busca.menorCaminho(inicio, saida) == null) {
            System.out.println("Não há saída possível!");
            return;
        }

        List<Posicao> tesouros = labirinto.encontrarTodos('T');
        List<String> percurso = new ArrayList<>();
        percurso.add("S");
        int coletados = 0;
        Posicao atual = inicio;

        // Enquanto tiver tesouro, vai no mais perto
        while (true) {
            List<Posicao> maisPerto = null;
            Posicao tesouroEscolhido = null;

            for (Posicao t : tesouros) {
                List<Posicao> caminho = busca.menorCaminho(atual, t);
                if (caminho != null && (maisPerto == null || caminho.size() < maisPerto.size())) {
                    maisPerto = caminho;
                    tesouroEscolhido = t;
                }
            }

            // Não tem mais tesouro
            if (tesouroEscolhido == null) break;

            andar(maisPerto, percurso);
            percurso.add("T");
            coletados++;
            tesouros.remove(tesouroEscolhido);
            atual = tesouroEscolhido;
        }

        // Vai para a saída
        andar(busca.menorCaminho(atual, saida), percurso);
        percurso.set(percurso.size() - 1, "E");

        System.out.println("Caminho percorrido: " + String.join(" → ", percurso));
        System.out.println("Tesouros coletados: " + coletados);
    }

    // Adiciona os passos no percurso (pula o primeiro porque o herói já está nele)
    private void andar(List<Posicao> caminho, List<String> percurso) {
        for (int i = 1; i < caminho.size(); i++) {
            percurso.add(caminho.get(i).toString());
        }
    }
}
