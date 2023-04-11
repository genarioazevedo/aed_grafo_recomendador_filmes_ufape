package classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Grafo {
    private List<Usuario> usuarios;
    private List<Relacao> relacoes;

    public Grafo() {
        this.usuarios = new ArrayList<>();
        this.relacoes = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void adicionarRelacao(Usuario origem, Usuario destino, int peso) {
        Relacao relacao = new Relacao(origem, destino, peso);
        this.relacoes.add(relacao);
    }

    public Map<Filme, Double> obterIndicacoes(Usuario usuario) {
        Map<Filme, Double> indicacoes = new HashMap<>();

        // Obtém os vizinhos de primeiro e segundo grau
        List<Usuario> vizinhosPrimeiroGrau = usuario.getVizinhos(this);
        List<Usuario> vizinhosSegundoGrau = new ArrayList<>();
        for (Usuario vizinho : vizinhosPrimeiroGrau) {
            vizinhosSegundoGrau.addAll(vizinho.getVizinhos(this));
        }

        // Remove os vizinhos que já foram assistidos pelo usuário
        vizinhosPrimeiroGrau.removeAll(usuario.getVizinhos(this));
        vizinhosSegundoGrau.removeAll(usuario.getVizinhos(this));
        vizinhosSegundoGrau.removeAll(vizinhosPrimeiroGrau);
        vizinhosSegundoGrau.remove(usuario);

        // Calcula a média das pontuações para cada filme
        Map<Filme, List<Double>> pontuacoes = new HashMap<>();
        for (Usuario vizinho : vizinhosPrimeiroGrau) {
            for (Map.Entry<Filme, Integer> entry : vizinho.getFilmesAssistidos().entrySet()) {
                Filme filme = entry.getKey();
                int pontuacao = entry.getValue();
                if (!pontuacoes.containsKey(filme)) {
                    pontuacoes.put(filme, new ArrayList<>());
                }
                pontuacoes.get(filme).add((double) pontuacao);
            }
        }
        for (Map.Entry<Filme, List<Double>> entry : pontuacoes.entrySet()) {
            Filme filme = entry.getKey();
            List<Double> listaPontuacoes = entry.getValue();
            double pontuacaoMedia = listaPontuacoes.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            indicacoes.put(filme, pontuacaoMedia);
        }

       // Calcula a média ponderada das pontuações para cada filme com base nos vizinhos de segundo grau
       for (Usuario vizinho : vizinhosSegundoGrau) {
        int peso = getPesoRelacao(usuario, vizinho);
        for (Map.Entry<Filme, Integer> entry : vizinho.getFilmesAssistidos().entrySet()) {
            Filme filme = entry.getKey();
            int pontuacao = entry.getValue();
            if (!pontuacoes.containsKey(filme)) {
                pontuacoes.put(filme, new ArrayList<>());
            }
            pontuacoes.get(filme).add((double) pontuacao * peso);
        }
        }
        for (Map.Entry<Filme, List<Double>> entry : pontuacoes.entrySet()) {
            Filme filme = entry.getKey();
            List<Double> listaPontuacoes = entry.getValue();
            double pontuacaoMedia = listaPontuacoes.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            indicacoes.put(filme, indicacoes.getOrDefault(filme, 0.0) + pontuacaoMedia);
        }

        // Ordena os filmes pela média ponderada das pontuações
        PriorityQueue<Filme> filaFilmes = new PriorityQueue<>(Comparator.comparingDouble(indicacoes::get).reversed());
        filaFilmes.addAll(indicacoes.keySet());

        // Retorna os 5 filmes com a maior média ponderada das pontuações
        Map<Filme, Double> topFilmes = new HashMap<>();
        while (topFilmes.size() < 5 && !filaFilmes.isEmpty()) {
            Filme filme = filaFilmes.poll();
            if (!usuario.getFilmesAssistidos().containsKey(filme)) {
                topFilmes.put(filme, indicacoes.get(filme));
            }
        }
        return topFilmes;
        }

    public int getPesoRelacao(Usuario origem, Usuario destino) {
        for (Relacao relacao : relacoes) {
            if (relacao.getOrigem().equals(origem) && relacao.getDestino().equals(destino) ||
                relacao.getOrigem().equals(destino) && relacao.getDestino().equals(origem)) {
                return relacao.getPeso();
            }
        }
        return 1;
    }

    public List<Relacao> getRelacoes() {
        return this.relacoes;
    }
        
}