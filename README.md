Sistema personalizado de recomendação de filmes baseado em uma técnica de filtragem colaborativa e um grafo implementado em Java. O gráfico consiste em uma lista de usuários e uma lista de relações entre eles, sendo que cada usuário possui um nome, idade e uma lista de filmes que assistiu com suas respectivas pontuações. O sistema calcula a pontuação média de cada filme e retorna uma lista de recomendações com base nas pontuações mais altas. A técnica de filtragem colaborativa usada neste sistema identifica padrões de interesse entre os usuários e recomenda itens com base em suas opiniões e comportamentos anteriores, em vez de confiar apenas nas informações sobre os próprios filmes. O sistema também utiliza um grafo para localizar vizinhos de primeiro e segundo grau e sugerir filmes relacionados aos interesses do usuário, mesmo que nunca tenham assistido a esses filmes antes. O código é implementado em quatro classes, incluindo Usuario, Relacao, Grafo e Filme, sendo a classe App responsável pela execução do código. 

## Instruções para uso do Programa:

Para execução do programa, devem instanciar na classe APP os seguintes objetos:

-Objetos da classe Filme, é necessário passar os parâmetros do construtor na seguinte ordem: título do filme (String), gênero do filme (String), ano de lançamento do filme (int), lista de atores do filme (List<String>) e nota do filme (double).

-Objetos da classe Usuario, é necessário passar os parâmetros do construtor na seguinte ordem: nome do usuário (String) e idade do usuário (int). Deve ser chamado o método assistirFilme().

-Objetos da classe Grafo, é necessário apenas chamar o construtor padrão da classe. Devem serem chamados os métodos adicionarUsuario(), adicionarRelacao() e obterIndicacao() para obtenção das indicações de filmes para um determinado usuário.

-Impressão das indicações de filmes

## ---------------------------------------------------------------------------------------------------------------------------------

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
