package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Usuario {
    private String nome;
    private int idade;
    private Map<Filme, Integer> filmesAssistidos;

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.filmesAssistidos = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Map<Filme, Integer> getFilmesAssistidos() {
        return filmesAssistidos;
    }

    public void setFilmesAssistidos(Map<Filme, Integer> filmesAssistidos) {
        this.filmesAssistidos = filmesAssistidos;
    }

    public void assistirFilme(Filme filme, int pontuacao) {
        this.filmesAssistidos.put(filme, pontuacao);
    }

    public List<Usuario> obterCaminhoMaisCurto(Usuario destino, Grafo grafo) {
        List<Usuario> caminhoMaisCurto = new ArrayList<>();
        Map<Usuario, Usuario> antecessores = new HashMap<>();
        Map<Usuario, Integer> distancias = new HashMap<>();

        Queue<Usuario> fila = new LinkedList<>();
        fila.add(this);
        distancias.put(this, 0);

        while (!fila.isEmpty()) {
            Usuario atual = fila.poll();
            int distanciaAtual = distancias.get(atual);

            for (Usuario vizinho : atual.getVizinhos(grafo)) {
                if (!distancias.containsKey(vizinho)) {
                    fila.add(vizinho);
                    distancias.put(vizinho, distanciaAtual + 1);
                    antecessores.put(vizinho, atual);
                }
            }
        }

        if (!antecessores.containsKey(destino)) {
            return caminhoMaisCurto;
        }

        caminhoMaisCurto.add(destino);
        Usuario atual = antecessores.get(destino);
        while (atual != null) {
            caminhoMaisCurto.add(0, atual);
            atual = antecessores.get(atual);
        }

        return caminhoMaisCurto;
    }

    public List<Usuario> getVizinhos(Grafo grafo) {
        List<Usuario> vizinhos = new ArrayList<>();

        for (Relacao relacao : grafo.getRelacoes()) {
            if (relacao.getOrigem().equals(this)) {
                vizinhos.add(relacao.getDestino());
            } else if (relacao.getDestino().equals(this)) {
                vizinhos.add(relacao.getOrigem());
            }
        }

        return vizinhos;
    }

}
