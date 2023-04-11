import java.util.Arrays;
import java.util.Map;

import classes.Filme;
import classes.Grafo;
import classes.Usuario;

public class App {

    public static void main(String[] args) {
            
        // Criação dos filmes
        Filme filme1 = new Filme("Interestelar", "Ficção Científica", 2014, Arrays.asList("Matthew McConaughey", "Anne Hathaway"), 4.5);
        Filme filme2 = new Filme("O Poderoso Chefão", "Drama", 1972, Arrays.asList("Marlon Brando", "Al Pacino"), 4.8);
        Filme filme3 = new Filme("Matrix", "Ficção Científica", 1999, Arrays.asList("Keanu Reeves", "Carrie-Anne Moss"), 4.2);
        Filme filme4 = new Filme("A Origem", "Ficção Científica", 2010, Arrays.asList("Leonardo DiCaprio", "Ellen Page"), 4.7);
        Filme filme5 = new Filme("Clube da Luta", "Drama", 1999, Arrays.asList("Brad Pitt", "Edward Norton"), 4.3);
        Filme filme6 = new Filme("O Senhor dos Anéis: A Sociedade do Anel", "Fantasia", 2001, Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen", "Sean Astin", "Orlando Bloom"), 0);
        Filme filme7 = new Filme("O Senhor dos Anéis: As Duas Torres", "Fantasia", 2002, Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen", "Sean Astin", "Orlando Bloom"), 0);
        Filme filme8 = new Filme("O Senhor dos Anéis: O Retorno do Rei", "Fantasia", 2003, Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen", "Sean Astin", "Orlando Bloom"), 0);
        Filme filme9 = new Filme("Harry Potter e a Pedra Filosofal", "Fantasia", 2001, Arrays.asList("Daniel Radcliffe", "Emma Watson", "Rupert Grint", "Richard Harris", "Maggie Smith"), 0);
        Filme filme10 = new Filme("Harry Potter e a Câmara Secreta", "Fantasia", 2002, Arrays.asList("Daniel Radcliffe", "Emma Watson", "Rupert Grint", "Richard Harris", "Maggie Smith"), 0);
        Filme filme11 = new Filme("Harry Potter e o Prisioneiro de Azkaban", "Fantasia", 2004, Arrays.asList("Daniel Radcliffe", "Emma Watson", "Rupert Grint", "Gary Oldman", "David Thewlis"), 0);
        Filme filme12 = new Filme("O Poderoso Chefão", "Drama", 1972, Arrays.asList("Marlon Brando", "Al Pacino", "James Caan", "Richard S. Castellano", "Robert Duvall"), 0);
        Filme filme13 = new Filme("O Poderoso Chefão - Parte II", "Drama", 1974, Arrays.asList("Al Pacino", "Robert Duvall", "Diane Keaton", "Robert De Niro", "John Cazale"), 0);
        Filme filme14 = new Filme("Pulp Fiction: Tempo de Violência", "Crime", 1994, Arrays.asList("John Travolta", "Samuel L. Jackson", "Uma Thurman", "Harvey Keitel", "Tim Roth"), 0);


    
        // Criação dos usuários
        Usuario usuario1 = new Usuario("João",22);
        Usuario usuario2 = new Usuario("Genário",19);
        Usuario usuario3 = new Usuario("Luiz",17);
        Usuario usuario4 = new Usuario("Junior",25);
        Usuario usuario5 = new Usuario("João",22);
        Usuario usuario6 = new Usuario("Maria",19);
        Usuario usuario7 = new Usuario("Pedro",17);
        Usuario usuario8 = new Usuario("Lucas",25);
     
        // Adição dos usuários ao grafo
        Grafo grafo = new Grafo();
        grafo.adicionarUsuario(usuario1);
        grafo.adicionarUsuario(usuario2);
        grafo.adicionarUsuario(usuario3);
        grafo.adicionarUsuario(usuario4);
        grafo.adicionarUsuario(usuario5);
        grafo.adicionarUsuario(usuario6);
        grafo.adicionarUsuario(usuario7);
        grafo.adicionarUsuario(usuario8);
    
        // Adição dos filmes assistidos pelos usuários
        usuario1.assistirFilme(filme2, 5);
        usuario1.assistirFilme(filme4, 4);
        usuario1.assistirFilme(filme13,5);
        usuario1.assistirFilme(filme14,4);
        usuario2.assistirFilme(filme5, 4);
        usuario3.assistirFilme(filme1, 5);
        usuario3.assistirFilme(filme2, 4);
        usuario2.assistirFilme(filme6, 3);
        usuario2.assistirFilme(filme7, 4);
        usuario3.assistirFilme(filme8, 5);
        usuario3.assistirFilme(filme2, 4);
        usuario3.assistirFilme(filme3, 3);
        usuario4.assistirFilme(filme2, 5);
        usuario4.assistirFilme(filme5, 3);
        usuario5.assistirFilme(filme2, 5);
        usuario5.assistirFilme(filme4, 4);
        usuario6.assistirFilme(filme3, 3);
        usuario6.assistirFilme(filme5, 4);
        usuario7.assistirFilme(filme1, 5);
        usuario8.assistirFilme(filme1, 4);
        usuario8.assistirFilme(filme3, 3);
        usuario8.assistirFilme(filme2, 5);
        usuario8.assistirFilme(filme5, 3);
        usuario8.assistirFilme(filme9, 4);
        usuario8.assistirFilme(filme10,3);
        usuario8.assistirFilme(filme11,5);
        usuario8.assistirFilme(filme12,3);
        
        // Criação das relações entre os usuários
        grafo.adicionarRelacao(usuario1, usuario2, 2);
        grafo.adicionarRelacao(usuario2, usuario3, 1);
        grafo.adicionarRelacao(usuario6, usuario5, 2);
        grafo.adicionarRelacao(usuario1, usuario5, 1);
        grafo.adicionarRelacao(usuario1, usuario8, 2);
        grafo.adicionarRelacao(usuario7, usuario8, 2);
        grafo.adicionarRelacao(usuario4, usuario7, 2);

        // Obtenção das indicações de filmes para um determinado usuário
        Map<Filme, Double> indicacoes = grafo.obterIndicacoes(usuario2);
  
        // Impressão das indicações de filmes
        System.out.println("Indicações de filmes para " + usuario2.getNome() + ":");
            for (Filme filme : indicacoes.keySet()) {
                double pontuacao = indicacoes.get(filme);
                System.out.println(filme.getTitulo() + " - Pontuação: " + pontuacao + " estrelas");
        }
    }
}
        
        
        