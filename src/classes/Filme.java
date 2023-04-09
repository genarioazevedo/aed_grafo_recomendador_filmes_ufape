package classes;

import java.util.List;

public class Filme {
    private String titulo;
    private String genero;
    private int anoLancamento;
    private List<String> atores;
    private double pontuacaoMedia = 0.0;

    public Filme(String titulo, String genero, int anoLancamento, List<String> atores, double pontuacaoMedia) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.atores = atores;
        this.pontuacaoMedia = pontuacaoMedia;
    }
    public Filme(String string, String string2){
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public List<String> getAtores() {
        return atores;
    }

    public void setAtores(List<String> atores) {
        this.atores = atores;
    }

    public double getPontuacaoMedia() {
        return pontuacaoMedia;
    }

    public void setPontuacaoMedia(double pontuacaoMedia) {
        this.pontuacaoMedia = pontuacaoMedia;
    }
}
