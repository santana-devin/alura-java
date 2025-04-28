# 01 **Projeto da aula anterior**

Caso queira começar daqui, você pode acessar o [projeto da aula anterior no GitHub](https://github.com/alura-cursos/2887-java-screenmatch-oo).

# 02 **Configurando o que pode ser visto e modificado**

**Jacqueline:** Na nossa classe `Principal` estamos criando um novo filme, adicionando atributos e avaliando. Ao executar, recebemos também a média das avaliações, cujo resultado é algo próximo de `7.6`.

```csharp
public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "O poderoso chefão";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println(meuFilme.somaDasAvaliacoes);
        System.out.println(meuFilme.totalDeAvaliacoes);
        System.out.println(meuFilme.pegaMedia());
    }
}
```

Mas imagine que eu sou muito fã de "O Poderoso Chefão" e não concordo com essa média. Eu poderia atribuir diretamente uma nota `10` ao atributo `meuFilme.somaDasAvaliacoes`.

```ini
meuFilme.somaDasAvaliacoes = 10;Copiar código
```

**Paulo:** Isso porque, da forma que construímos o código até agora, é possível alterar esse valor tanto a partir de uma atribuição quanto usando o método `avalia()`. A segunda, utilizando métodos, é a maneira mais interessante de se comunicar objetos. Academicamente, inclusive, diz-se que os objetos se comunicam, trocam mensagens entre si. Esse paradigma foi criado no Smalltalk, uma das primeiras linguagens orientadas a objetos.

Fazendo a atribuição diretamente, estamos indo contra esse conceito.

**Jacqueline:** Nós poderíamos até atribuir um valor `1` ao atributo `totalDeAvaliacoes`. Dessa forma, ao pedir a média novamente, teríamos como resultado `10`, burlando o cálculo que fizemos anteriormente.

```csharp
public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "O poderoso chefão";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println(meuFilme.SomaDasAvaliacoes);
        System.out.println(meuFilme.totalDeAvaliacoes);
        System.out.println(meuFilme.pegaMedia());
        meuFilme.somaDasAvaliacoes = 10;
        meuFilme.totalDeAvaliacoes = 1;
        System.out.println(meuFilme.pegaMedia());
    }
}
```

Esse não é o caminho recomendado. A orientação a objetos foi criada com o intuito de aproximar a lógica dos cenários da vida real. Se eu precisasse de 50 reais, eu não pegaria diretamente da sua carteira, eu te pediria.

É exatamente isso que queremos em nosso código: impedir que alguém altere os valores diretamente e fazer com que seja necessário "pedir" ou "perguntar". Esse é o conceito de **encapsulamento** , impedir alterações nos nossos atributos.

**Paulo:** A ideia é que não gostaríamos que as linhas `meuFilme.somaDasAvaliacoes = 10` e `meuFilme.totalDeAvaliacoes = 1`, onde alteramos "manualmente" os atributos, fossem possíveis. Como se tivéssemos um cartaz na empresa dizendo "não alterem a soma das avaliações através do atributo".

Isso é muito comum quando estamos trabalhando em equipe, combinados como "aquela função ninguém altera" ou "precisa conversar com a Jaque antes de mexer nesse código". Esse cenário não é interessante, pois começa a gerar travas e a necessidade de conhecimento além do código.

O código deveria ser suficiente por si só, e não ter combinados do tipo "essa classe não pode fazer isso". As classes, funções e métodos precisam ser tão bem escritos ao ponto de permitirem ou bloquearem determinadas ações.

**Jacqueline:** Para isso teremos que modificar a classe `Filme`, introduzindo um novo conceito: os modificadores de acesso (ou modificadores de visibilidade).

Como não queremos que o atributo `somaDasAvaliacoes` seja alterado diretamente, ao invés de declará-lo somente como `double`, usaremos a palavra-chave `private`.

```java
public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    int totalDeAvaliacoes;
    int duracaoEmMinutos; 

//...

```

Assim que fazemos isso, a IDE nos aponta um problema, já que a classe `Principal` não conseguirá mais atribuir valores diretamente ao atributo.

**Paulo:** Mas a própria classe `Filme` pode, certo?

**Jacqueline:** Exatamente. Nas linhas em que acessamos o atributo `somaDasAvaliacoes` diretamente, o programa para de compilar.

```csharp
    System.out.println(meuFilme.somaDasAvaliacoes);
    meuFilme.somaDasAvaliacoes = 10;Copiar código
```

**Paulo:** Ele não deixa nem ler, nem escrever. Então o atributo privado não é somente leitura, ele está escondido, é necessário encontrar outra forma de acessá-lo.

**Jacqueline:** Exatamente. Os modificadores de acesso são um recurso que temos disponível para fazer esse tipo de controle. Na classe `Filme`, por exemplo, estamos usando o modificador `public`, que entenderemos melhor no futuro.

Vamos usar o modificador `private` também para o `totalDeAvaliacoes`.

```java
public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    int duracaoEmMinutos; 
//...
}
```

Agora a classe `Principal` apresentará quatro linhas com problemas. E como vamos resolver isso?

**Paulo:** Quem está trabalhando com `Filme` não quer saber a soma das avaliações, quer a média. Talvez o total de avaliações seja uma informação útil.

Na minha opinião, a linha `System.out.println(meuFilme.somaDasAvaliacoes)` é desnecessária, assim como as linhas `meuFilme.somaDasAvaliacoes = 10` e `meuFilme.totalDeAvaliacoes = 1`, já que se alguém quer alterar as avaliações, deverá invocar o método `avalia()`.

Já o `totalDeAvaliacoes` talvez seja interessante manter. Poderíamos ter, por exemplo, um filme "Top Gun" com a nota `8.3` de um total de `80000` avaliações. É sinal de que não é um filme heterodoxo, que ninguém conhece e que teria uma nota tão alta por ser pouco conhecido. Acho que precisamos encontrar uma maneira de fornecer esse dado ou uma informação parecida.

**Jacqueline:** Que é o que a gente vai fazer no próximo vídeo, pensar em como resolver esse problema.
