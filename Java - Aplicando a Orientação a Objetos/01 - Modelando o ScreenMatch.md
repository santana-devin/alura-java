# 01 **Apresentação**

**Paulo:** Olá! Eu sou Paulo Silveira, CEO da Alura, e estamos no curso de Orientação a Objetos com Java. É um curso muito importante para quem vai trabalhar com Java, e vai permear tudo que envolve esse paradigma, como encapsulamento, classes, herança e interfaces, além de como essas coisas se conectam.

Após o curso, você vai perceber como a orientação a objetos está em todo lugar e em todas as bibliotecas.

Eu sou um homem branco de cabelo curto preto, barba e bigode. Uso um par de óculos de armação preta e uma camiseta preta da Alura. Hoje eu estou auxiliando a Jacqueline, a instrutora principal desse curso.

**Jacqueline:** Obrigada, Paulo. É um prazer estar aqui novamente para darmos mais esse passo, falar de orientação a objetos, que é um paradigma de programação muito importante que quem vai mergulhar no Java precisa entender e dominar.

Eu sou uma mulher branca de cabelos loiros longos e estou usando uma camiseta azul-marinho da Alura. É um prazer acompanhar você mais uma vez nessa jornada.

**Paulo:** Preste atenção, pois nesse momento da orientação a objetos as coisas começam a se conectar. Toda vez que você for trabalhar com bibliotecas, seja para se conectar a *webservices* , consumir JSON ou XML e assim por diante, os princípios de interface e encapsulamento estarão presentes para trabalhar melhor. Foco nos estudos!

# 02 **Um modelo para representar filmes**

**Jacqueline:** No curso anterior, estávamos falando sobre regras e condicionais. Na hora de montar o Screen Match, a nossa plataforma de *streaming* , começamos a implementar algumas regras - por exemplo, emitindo uma mensagem se um filme foi lançado a partir de determinada data, ou se está ou não incluído no plano, tudo isso com condicionais.

Mas isso não está muito adequado. E se precisarmos usar isso em outro momento? Teríamos que copiar e colar esse código? É um tipo de programação meio estruturada ou procedural, o que não é muito adequado para modificação. Ao espalhar regras pelo código, tornamos mais difícil fazer manutenção da aplicação ou mesmo entender o que nossa aplicação faz.

**Paulo:** Por exemplo, em vários lugares da aplicação precisamos saber se um filme está incluso no plano ou se ela precisa pagar algum valor adicional, como no catálogo, quando a pessoa dá "play" (para saber se ela não "hackeou" o sistema e está assistindo sem pagar), na listagem de todos os filmes inclusos no plano e assim por diante.

Nesses casos a gente usaria o que chamamos de "Regra de Negócio", um termo até meio antigo, que consiste na regra que foi decidida para o nosso produto. Por exemplo, se o filme for recente, é necessário pagar, a não ser que o usuário tenha o plano "plus".

Essa regra pode ser alterada, assim como a Netflix e a HBOMax já mudaram suas regras anteriormente, como que filmes estão inclusos, se é necessário pagar valores adicionais o não, compartilhamento de conta, entre outras. Em uma empresa essas regras são vivas, elas mudam.

Atualmente temos essa condicional verificando se o filme está incluso no plano, mas no futuro podem entrar novas regras envolvendo outros planos, se a pessoa é cliente antiga ou não, entre outras. Ou seja, essa condicional vai ser copiada e colada em diversos outros lugares.

Com uma mudança na regra de negócios, pode ser necessário alterá-la, sendo necessário buscar em que lugares da aplicação a condicional aparece - até mesmo com um "Ctrl + F", o que não é um bom sinal, pois indica que não sabemos onde o código está.

Isso mostra que a nossa lógica está espalhada, e não em um único lugar, de uma única cápsula - **encapsulada** . Quando temos uma regra em um único ponto, facilitamos sua manutenção e simplificamos o nosso código.

Esse é até um dos princípios de boas práticas em orientação a objetos, apesar do termo "encapsulamento" não envolver apenas objetos. Várias metodologias de boas práticas em desenvolvimento, como Clean Code, DDD (Domain-driven Design), Design Patters e SOLID, nascem basicamente desses problemas.

> Não se esqueça de que temos formações, cursos e artigos sobre boas práticas aqui na Alura!

Estamos enxergando aqui um problema: se copiarmos essa condicional em outros lugares, vamos nos perder. Como podemos resolver isso? O Java popularizou no mercado a orientação a objetos, que vem resolver esse cenário.

**Jacqueline:** Exatamente, Paulo. Era muito comum esse tipo de problema. Por exemplo, às vezes clicar por um menu funcionava, mas por um botão não, porque existia código espalhado. Além disso, com o tempo as pessoas desenvolvedoras vão mudando, e nem sempre quem criou aquele código fará a manutenção.

Buscar ou copiar e colar código não são boas práticas em aplicações confiáveis e de grande porte. A orientação a objetos vem nos ajudar a centralizar em um único lugar o que a nossa entidade tem de característica, de comportamento, enxergando as coisas como objetos propriamente ditos.

Nesse caso, temos um "filme" com suas características, como nome, tipo de plano, se ele está incluído ou não. Além disso, temos comportamentos, como assistir, alugar ou exibir a ficha técnica.

A ideia é começarmos o projeto do Screen Match orientado a objetos para não precisarmos fazer as regras dessa forma. Vamos criar um método que nos informará se o filme é retrô, se é lançamento, centralizando isso em um único lugar.

## Criando uma classe

**Paulo:** Vamos começar o projeto desse curso, obviamente usando essa temática dos filmes e melhorando essas regras. Como comentamos na introdução do curso, é comum que a pessoa entenda os conceitos, mas não fiquem claros os seus casos de uso. Quando usar uma classe? Quando criar um método? Será que a classe está grande demais, pequena demais ou muito acoplada?

São dúvidas completamente naturais que vamos abordar nas aulas e exercícios, mas é necessário tempo e experiência para internalizar essas boas práticas.

**Jacqueline:** Exatamente. No IntelliJ, acessaremos o menu "File -> New Project" para começar um novo projeto, que chamaremos de "screenmatch". Selecionaremos as mesmas opções do outro curso, "Java" como "Language" e "IntelliJ" como "Build System", e clicaremos em "Create".

Observe que dessa vez eu não pedi o código padrão, não começaremos criando a classe com `main()`, pois queremos pensar na orientação a objetos. A temática do nosso projeto é trabalhar com filmes, portanto queremos criar uma forma de explicar o que é um filme - ou seja, uma classe `Filme`.

Clicaremos com o botão direito na pasta "src" e então em "New -> Java Class". Na janela que se abrirá, adicionaremos o nome "Filme" e pressionaremos "Enter".

**Paulo:** Relembrando que no dia a dia de uma empresa, mesmo no Brasil, costuma-se usar o inglês para escrever código. Aqui estamos usando "Filme" como recurso didático.

**Jacqueline:** Exatamente.

> `Filme.java`

```kotlin
public class Filme {

}
```

Criamos a classe filme, mas o que é uma classe? Uma classe especifica o conteúdo de um objeto, ou seja, o que um filme tem, qual é a nossa abstração ali - inclusive, um dos pilares da orientação a objetos é a abstração. A ideia é pensarmos que características são comuns a todos os filmes. Claro que cada empresa pode ter as suas características principais, mas podemos começar definindo, por exemplo, que um filme tem um "nome".

Sendo assim, vamos definir o atributo `nome` como uma String.

```kotlin
public class Filme {
    String nome;

}
```

**Paulo:** Vale lembrar que anteriormente estávamos declarando variáveis na `main()`, que é um método, algo que já vamos entender. Aqui temos um cenário diferente: tudo que declararmos na classe `Filme` será comum a todos os filmes. Em português, estamos dizendo que "todo filme tem um nome".

Tanto que aqui não podemos executar um `System.out.println()`. Estamos definindo uma classe, tudo o que ela tem e tudo que ela faz.

**Jacqueline:** Exatamente. Vamos incluir mais algumas informações, como o `anoDeLancamento` como int, `incluidoNoPlano` como boolean, seguindo a convenção de código que aprendemos no curso anterior.

```java
public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;

}
```

Lembrando que essa é uma ideia de como achamos que é um filme, não é o filme propriamente dito, assim como a planta de uma casa não é uma casa.

**Paulo:** Isso, é um esqueleto, um protótipo. Existem várias analogias que podemos fazer.

**Jacqueline:** Vamos criar mais algumas características que vão compor o nosso filme: `avaliacao` como double, e `totalDeAvaliacoes` como int.

```java
public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double avaliacao;
    int totalDeAvaliacoes;
}
```

**Paulo:** Tudo que a Jaque está fazendo é o que ela sentiu ser importante para o sistema que está desenvolvendo. Às vezes essas características não são óbvias. Será que devemos guardar o `totalDeAvaliacoes`? Será que precisamos do `anoDeLancamento` ou essa informação não é relevante para nosso sistema?

Esse é um trabalho que envolve entender os usuários da usa plataforma, a chefia do seu trabalho ou, muitas vezes, algo que vai sendo incluído ao longo do tempo, conforme as necessidades vão aparecendo. Aqui nós já temos um projeto definido, mas é bem natural que existam mudanças até criar algo estruturado assim.

**Jacqueline:** Exatamente, e está tudo bem. Trabalhar com código é assim mesmo, nós estamos a todo tempo incluindo coisas novas ou removendo o que não é mais usado. Aqui nós inicialmente idealizamos o que vamos precisar em um filme, mas poderíamos ter também a `duracaoEmMinutos`, por exemplo.

```java
public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double avaliacao;
    int totalDeAvaliacoes;
    int duracaoEmMinutos;
}
```

**Paulo:** Temos até que tomar cuidado, pois essa abstração poderia ser infinita, incluindo atores principais, qual a produtora, quem é diretor ou diretora, se o filme é preto e branco ou colorido... É necessário ter um limite. Essas modelagens de classe também demandam certa experiência para ir melhorando e refinando.

**Jacqueline:** E geralmente é uma coisa que fazemos com base em uma conversa em equipe. Você sabe quais são os requisitos, o que é necessário implementar, e os atributos vão nascer conforme a necessidade. Aqui estamos somente criando um esboço.

Essa é a nossa classe, o modelo de como será um filme. A seguir, conversaremos sobre o conceito de objeto e qual a diferença entre classe e objeto.

Anteriormente, para termos um filme como "Top Gun" em nossa aplicação, criávamos uma variável e passávamos o nome. Mas e agora, como criaremos os filmes?

**Paulo:** Ótimo, porque aqui só criamos o modelo. Com isso aqui não é possível fazer nada, inclusive não conseguiremos rodar esse código - afinal, essa classe não tem um método `main()`. Continuaremos a partir daqui no próximo vídeo.

# 03 **Atribuindo valores ao nosso filme**


**Jacqueline:** Está pronto o nosso modelo de classe e agora vamos de fato começar a utilizá-lo.

Quando criamos o projeto, foi criada uma classe `Main` com o método `main()` que anteriormente dissemos que não iríamos criar. Vamos renomeá-la clicando com o botão direito e em seguida em "Refactor -> Rename" (atalho "Shift + F6"). Chamaremos o arquivo de "Principal".

**Paulo:** Caso não tenha aparecido para você uma classe com esse método, você criar uma classe `Principal` e digitar `psvm` para autocompletar com o esqueleto da classe.

```typescript
public class Principal {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

```

**Jacqueline:** Vamos apagar o `System.out.println()`, que não usaremos agora. A ideia é de fato usarmos a nossa classe `Filme`. Anteriormente, quando queríamos criar uma variável, bastava informar o tipo - por exemplo, `int` - seguido do nome da variável e o valor que ela receberia.

```cpp
int valor = 555;

```

Porém, ao criar uma classe `Filme`, nós também criamos um tipo propriamente nosso. Passaremos esse tipo como qualquer outro, seguido do nome da variável, nesse caso `meuFilme`.

```java
Filme meuFilme = 

```

**Paulo:** Aqui é um nome de variável, pode ser qualquer um, como `filmeLegal`, `filmeUm` e assim por diante. Já a parte da esquerda, onde declaramos o tipo `Filme`, deve ter exatamente o nome da classe. Não poderia ser, por exemplo, `filme` com F minúsculo, pois a classe é chamada de `Filme` com F maiúsculo.

**Jacqueline:** Exatamente. Para criarmos efetivamente um novo objeto do tipo `Filme`, usaremos a instrução `new Filme()`.

```java
Filme meuFilme = new Filme();

```

## Instanciação de objetos

Anteriormente nós estudados os chamados **tipos primitivos** . Aqui temos um **tipo por referência** , em algum lugar da memória da máquina foi criado um espaço reservado para um objeto chamado `Filme`.

**Paulo:** Isto é, um objeto chamado `Filme` que está na memória e possui um "espaço" para o nome, para o ano de lançamento e cada um daqueles itens que chamamos de **atributos** .

**Jacqueline:** E a minha variável `meuFilme` sabe o endereço desse objeto na memória.

**Paulo:** Essa é uma coisa que a gente nem precisa saber, no dia a dia acaba não aparecendo muito.

**Jacqueline:** Isso, não importa. Se a gente fizer um `System.out.println()`, conseguiremos imprimir o endereço, mas não é necessariamente algo que precisamos saber. Nós sabemos que o objeto e o seu espaço na memória existem, e conseguimos manipular esse objeto.

**Paulo:** Sempre aparece aquela dúvida: por que eu preciso repetir `Filme` na esquerda e na direita? Acho que precisamos de mais prática para entender, mas a parte na direita é onde criamos o espaço na memória, e na esquerda estamos informando a necessidade de uma variável que saiba referenciar um objeto do tipo `Filme`. São coisas bem distintas que estão acontecendo.

**Jacqueline:** E como vamos alimentar os atributos que um filme tem? Se chamarmos a variável `meuFilme` seguida de um ponto, serão exibidos os atributos ela: `avaliacao`, `incluidoNoPlano`, `nome` e assim por diante.

Podemos, então, passar valores para esses atributos. Começaremos com `meuFilme.nome`, que receberá o valor "O poderoso chefão".

```java
Filme meuFilme = new Filme();
meuFilme.nome = "O poderoso chefão";

```

Podemos repetir o processo para cada um dos atributos.

```java
Filme meuFilme = new Filme();
meuFilme.nome = "O poderoso chefão";
meuFilme.anoDeLancamento = 1970;
meuFilme.duracaoEmMinutos = 180;

```

**Paulo:** E essa sintaxe do ponto é comum em diversas linguagens quando queremos acessar *algo de alguém* . Já fizemos, por exemplo, o `System.out` e o `leitor.nextLine()` de modo a acessarmos alguns métodos.

**Jacqueline:** E o que acontece se fizermos a impressão do `meuFilme` usando o `System.out.println()`? Vamos testar.

```typescript
public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "O poderoso chefão";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;
    
        System.out.println(meuFilme);
    }
}

```

> Filme@65ab7765

Temos esse resultado estranho, que tem um pouco de relação com aquilo que citamos. Ele está informando a classe principal e qual o endereço dessa referência, o que não é exatamente o que queríamos ver. Futuramente vamos entender com mais profundidade de onde vem esse resultado.

O que importa nesse momento é imprimirmos as informações desejadas - por exemplo, se queremos o nome do filme, usaremos `meuFilme.nome`.

```typescript
public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "O poderoso chefão";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;
    
        System.out.println(meuFilme.nome);
    }
}

```

**Paulo:** Eu acesso o atributo do objeto.

**Jacqueline:** Exatamente. Se quisermos o ano de lançamento, usaremos `meuFilme.anoDeLancamento`, e assim por diante.

```csharp
public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "O poderoso chefão";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;
    
        System.out.println(meuFilme.nome);
        System.out.println(meuFilme.anoDeLancamento);
    }
}

```

> O poderoso chefão
>
> 1970

Ao fazermos a execução, temos como retorno os dados que foram efetivamente cadastrados. Essa é a forma com a qual começamos a **instanciar objetos** , criando uma nova referência a um objeto para trabalhar os seus dados.

Esse é o primeiro passo, criar os atributos, saber instanciar um objeto e passar os valores para seus atributos. No próximo vídeo vamos falar um pouco sobre métodos, como definir o que um objeto pode fazer.

**Paulo:** Posso tirar uma dúvida antes de irmos para a próxima aula? O que aconteceria se fizéssemos `Filme.nome = "Top Gun"`, por exemplo?

```csharp
Filme meuFilme = new Filme();
meuFilme.nome = "O poderoso chefão";
meuFilme.anoDeLancamento = 1970;
meuFilme.duracaoEmMinutos = 180;

System.out.println(meuFilme.nome);
System.out.println(meuFilme.anoDeLancamento);
Filme.nome = "Top Gun"

```

**Jacqueline:** Nessa situação o IntelliJ nos informa um erro:

> Non-static field 'nome' cannot be referenced from a static context

**Paulo:** A gente até vai entender melhor esse erro depois, mas é justamente o que estávamos falando. A classe `Filme` é um modelo, uma especificação. Não podemos atribuir a ela um valor para a propriedade `nome`, afinal ela só especifica que um filme deve ter um nome.

É necessário criar um objeto desse tipo, um filme propriamente dito, e então conseguiremos alterar o seu nome. Acessar o atributo de um objeto pelo nome da classe não faz sentido.

Essa é a diferença entre classe e o modelo. A partir da classe, que é o modelo, podemos criar diversos filmes, o que inclusive faz parte dos exercícios.

**Jacqueline:** Exatamente. No próximo vídeo vamos falar sobre os métodos.



# 04 **Manipulando objetos**

Sua amiga Suellen, que está iniciando os estudos em Java, criou a seguinte classe para representar uma **Venda** :

```cpp
public class Venda {
  
    String produto;
    int quantidade;
    double valorUnitario;
    double valorTotal;

}

```

No entanto, ao criar uma instância dessa classe em um método main, você percebeu que ela escreveu o seguinte código contendo alguns erros:

```typescript
public static void main(String[] args) {
    Venda venda1 = Venda();
    venda1.produto = "Camiseta";
    venda1.quantidade = "2";
    venda1.valorUnitario = 25.50;

    System.out.println("Valor total da venda: " + venda1.quantidade * venda1.valorUnitario);
  
}

```

Escolha TODAS as alternativas que identificam os erros cometidos por ela no código anterior:

[X]O atributo `quantidade` foi preenchido de maneira incorreta.

O atributo `quantidade` foi definido com sendo do tipo **int** na classe `Venda`, não sendo permitido então passar a String “2” ao atribuí-lo no objeto `venda1`.


[ ]O código está correto e não apresenta erros.

[X]Existe um erro ao instanciar o objeto `venda1`.

Faltou a palavra reservada **new** para criar a instância do objeto, causando com isso um erro de compilação.

[ ]Erro no trecho do System.out.println, referente à concatenação dos valores.



# 05 **Definindo ações para o filme**


**Jacqueline:** A gente já viu o que um filme tem. Agora podemos falar o que um filme faz, o que ele tem de comportamentos ou método. Por exemplo, não precisamos imprimir o `nome` ou o `anoDeLancamento` "de fora", podemos pedir que o próprio `Filme` exiba sua ficha técnica.

A ideia é criar um método na classe `Filme` que execute essa função, e que todo filme seja capaz de fazê-la. Quando um método executa algo mas não um retorno, nós o declaramos como `void`.

**Paulo:** No Java você precisa informar que o método não vai devolver nada usando essa palavra-chave, "`void`", que é "vazio".

**Jacqueline:** No Java nós temos alguns padrões de nomenclatura para métodos. Algumas pessoas gostam de nomear com verbos no infinitivo ou no indicativo. Eu costumo ver e utilizar verbos no indicativo, como `exibeFichaTecnica()`, mas é possível que você encontre algo como `exibirFichaTecnica()`, no infinitivo.

```csharp
public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double avaliacao;
    int totalDeAvaliacoes;
    int duracaoEmMinutos; 

        void exibeFichaTecnica(){

        }
}
```

Após criado o nosso método, vamos mover o `System.out.println()` da classe `Principal`, trazendo-o para o `exibeFichaTecnica()`.

```csharp
public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double avaliacao;
    int totalDeAvaliacoes;
    int duracaoEmMinutos; 

        void exibeFichaTecnica(){
            System.out.println(meuFilme.nome);
            System.out.println(meuFilme.anoDeLancamento);
        }
}
```

**Paulo:** Jacque, por que o IntelliJ tá realçando em vermelho esse `meuFilme`?

**Jacqueline:** Porque essa variável não existe na classe `Filme`, ela só existia em `Principal`. Aqui, como temos os próprios atributos, só precisamos dos seus nomes.

```csharp
public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double avaliacao;
    int totalDeAvaliacoes;
    int duracaoEmMinutos;

        void exibeFichaTecnica(){
            System.out.println(nome);
            System.out.println(anoDeLancamento);
        }
}
```

Podemos inclusive concatenar com uma string para gerarmos uma saída mais interessante.

```csharp
public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double avaliacao;
    int totalDeAvaliacoes;
    int duracaoEmMinutos; 

        void exibeFichaTecnica(){
            System.out.println("Nome do filme:" + nome);
            System.out.println("Ano de lançamento:" + anoDeLancamento);
        }
}
```

Não vou colocar de todos os atributos, a gente pode futuramente montar uma ficha mais completa. Mas, basicamente, ao chamar o método `exibeFichaTecnica()`, as impressões que determinados precisam ser exibidas.

E como chamar esse método na classe principal? Da mesma forma que atribuímos valores: a partir de `meuFilme`, executaremos `exibeFichaTecnica()`.

```typescript
public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "O poderoso chefão";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;

        meuFilme.exibeFichaTecnica();
    }
}
```

**Paulo:** A gente usa os parênteses vazios `()` porque não temos argumentos, certo? No Java, mesmo que uma função ou método não receba nenhuma informação, é necessário usar os parênteses tanto na declaração quanto na invocação/chamada.

**Jacqueline:** Ao executar, teremos o resultado do jeito que configuramos:

> Nome do filme: O poderoso chefão
>
> Ano de lançamento: 1970

Esse foi o primeiro método, o primeiro comportamento que criamos para nossa classe. Também podemos criar um método que de fato receba argumentos. Por exemplo, se queremos dar avaliações para um `Filme`, podemos ter um método `avalia()` que registra as notas e o total.

Usaremos novamente a instrução `void`, pois vamos simplesmente registrar as avaliações, e criaremos o método `avalia()` recebendo como parâmetro um `double nota`. No corpo do método, a ideia é pegar o valor que já temos em `avaliacao` e incrementá-lo com aquele que foi recebido por parâmetro, algo que conseguiremos com `+=`.

```cpp
void avalia(double nota) {
    avaliacao += nota;
}
```

**Paulo:** Jaque, se esse atributo `avaliacao` é a soma total das avaliações, talvez isso devesse refletir no nome, algo como `somaDasAvaliacoes`.

**Jacqueline:** Perfeito, vamos alterar. Selecionando o atributo `avaliacao` e usando o atalho "Shift + F6", é possível alterar todas as ocorrências no projeto. Assim, temos:

```csharp
public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double somaDasAvaliacoes;
    int totalDeAvaliacoes;
        int duracaoEmMinutos; 

        void exibeFichaTecnica(){
            System.out.println("Nome do filme:" + nome);
            System.out.println("Ano de lançamento:" + anoDeLancamento);
        }

        void avalia(double nota) {
            somaDasAvaliacoes += nota;
        }
}
```

Esse tipo de alteração é normal, a gente idealiza de uma forma, mas muda no futuro.

**Paulo:** Para quem não decorou o atalho como eu, você pode dar dois cliques no atributo, clicar com o botão direito e usar "Refactor -> Rename" para fazer a mesma operação.

**Jacqueline:** Isso, tem o mesmo resultado.

**Paulo:** E vale lembrar que isso é muito melhor do que um "Ctrl + F", porque a IDE detecta o contexto e sabe que só deve mudar onde faz sentido. Se tivéssemos alguma string "A avaliacao é", por exemplo, ela não seria alterada.

**Jacqueline:** Também podemos fazer com que o `totalDeAvaliacoes` seja incrementado cada vez que uma nova avaliação é adicionada. Para isso, usaremos `totalDeAvaliacoes++`,

```cpp
void avalia(double nota) {
    somaDasAvaliacoes += nota;
    totalDeAvaliacoes++;
}
```

Na classe `Principal`, chamaremos `meuFilme.Avalia()` passando diferentes notas.

```typescript
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
    }
}
```

Ainda não estou fazendo uma média, somente registrando as avaliações. Para conferir se os valores foram registrados corretamente, vamos imprimir os atributos `somaDasAvaliacoes` e `totalDeavaliacoes`.

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
    }
}
```

Por algum motivo, as linhas em que fazemos as avaliações ficaram com uma indentação diferente. Para ajustar isso, selecionaremos todo o código e usaremos o atalho "Ctrl + Alt + I", opção que também pode ser acessada em "Code -> Auto-indent Lines".

Dessa forma, todo o código ficará alinhado. Uma boa indentação também faz parte das boas práticas e é importante para a legibilidade.

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
    }
}
```

Ao executar a classe `Principal`, teremos:

> 23.0
>
> 3

O programa corretamente somou três avaliações e as notas que passamos como parâmetros.

**Paulo:** Perfeito. Eu fiquei confuso na chamada de `meuFilme.avalia()`, pois aparece escrito "nota" ali ao lado do valor.

**Jacqueline:** Isso é uma dica da IDE de qual é o argumento que queremos passar.

**Paulo:** Para quem estiver lendo ter um pouco de facilidade, mas isso não faz parte do Java?

**Jacqueline:** Não faz parte,

**Paulo:** A pessoa não digita esse `nota:`, a própria IDE indica para você que esse `8`, lá na classe filme, é um parâmetro chamado `nota`.

**Jacqueline:** Exatamente, para ajudar na legibilidade. Para finalizar, vamos fazer outro método que retorna algo.

**Paulo:** Já sei, retorna a média das avaliações.

**Jacqueline:** Isso mesmo. Como' eu quero retornar uma média, que será em decimais, não teremos um método do tipo `void`, mas sim `double`. Poderíamos chamar esse método de `obterMediaDasAvaliacoes()`, `retornaMedia()` ou `pegaMedia()`.

**Paulo:** Pode ser, eu gosto das opções. Estamos tentando usar nomes mais longos e expressivos para que sua funcionalidade seja óbvia. Às vezes temos nomes mais curtos, mas em Java é muito raro termos abreviações.

**Jacqueline:** Exatamente. Vamos chamar de `pegaMedia()`. Nesse caso não passaremos nenhum argumento, pois ele já tem o que precisa.

Para retornar um valor, usaremos a instrução `return`. Devolveremos a `somaDasAvaliacoes` dividida pelo `totalDeAvaliacoes`.

```csharp
double pegaMedia(){
    return somaDasAvaliacoes / totalDeAvaliacoes;
}
```

Na classe `Principal`, faremos um novo `System.out.println()` pedindo a impressão de `meuFilme.pegaMedia()` para obtermos a média dessas avaliações.

> `Principal.java`

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

Executando o código, teremos como retorno:

> 7.6666666667

Aqui já conseguimos definir três comportamentos interessantes para o nosso filme, e que não precisamos espalhar pelo nosso código. Sempre que for necessário, basta chamarmos os respectivos métodos e atributos presentes na classe e que definem suas características e comportamentos.

**Paulo:** Jaque, antes de encerrarmos essa aula, podemos dar uma olhada na classe `Filme` desde o começo? Queria fazer uma revisão, pois tem bastante coisa.

Nós criamos uma classe `Filme` que possui diversos atributos, como `nome`, `anoDeLancamento`, `inclusoNoPlano`, ou seja, valores que podem ser guardados dentro de cada objeto toda vez que ele for instanciado.

Depois, começamos a criar coisas que se parecem com funções, mas que estão dentro da classe. Quando uma função está dentro de uma classe, nós a chamamos de "método", afinal, é uma maneira de fazer alguma coisa. A maneira de exibir a ficha técnica de um filme imprime o seu nome e ano de lançamento. A maneira de avaliar um filme recebe e registra uma nota, e não devolve nada. A maneira de pegar a média não recebe nenhuma informação, mas devolve alguma coisa.

Em `pegaMedia()`, se quiséssemos fazer um passo a passo, poderíamos calcular a média e atribuí-la a uma variável do tipo `double` para só então retorná-la.

```csharp
double pegaMedia(){
    double media = somaDasAvaliacoes / totalDeAvaliacoes;
    return media;
}
```

Da maneira que fizemos está completamente razoável, e é assim que escreveríamos no dia a dia trabalhando com Java, mas existem casos em que é possível quebrar uma única linha de código em duas.

Na classe `Principal`, por exemplo, também temos um cenário parecido:

Fizemos assim originalmente:

```csharp
System.out.println(meuFilme.pegaMedia)Copiar código
```

Mas poderíamos ter feito em dois passos:

```csharp
double media = meuFilme.pegaMedia()
System.out.println(media)Copiar código
```

Estou tentando estruturar para que você se sinta confortável com a ideia de que existem várias formas. Nós acabamos de criar uma classe minimamente interessante, com um tipo de código que aparece com frequência no dia a dia de uma pessoa desenvolvedora.

Existem alguns detalhes relacionados a encapsulamento, modificadores de acesso, polimorfismo e herança que abordaremos no futuro. Cada vez mais, a partir de agora, vamos avançar na orientação a objetos, mostrando inclusive classes que não foram criadas por nós.

Esses conhecimentos serão muito úteis quando formos utilizar as bibliotecas principais, tanto da Oracle e do Java, quanto bibliotecas Open Source por aí. Você verá que as pessoas pensaram muito bem em como estruturar e encaixar esses conceitos de maneira elegante, facilitando a legibilidade e a manutenção.

O Java é uma das primeiras grandes linguagens em que os sistemas começaram a envolver grandes grupos de 5, 10 ou 20 pessoas. Até então, antes da década de 90, a maioria absoluta dos sistemas era criada por uma ou duas pessoas desenvolvedoras, e equipes de desenvolvimento eram muito raras.

Quando as equipes começaram a crescer, nasceu a necessidade de escrever código mais legível, com variáveis mais óbvias e de maneira mais elegante, facilitando o trabalho de grandes times em uma mesma base de código. Está aí a importância de boas práticas, nomenclatura e orientação a objetos, e o Java foi a principal linguagem na época a receber esse cuidado. Posteriormente, o .NET e outras linguagens vêm trazer esse propósito de facilitar a complexidade.

**Jacqueline:** Isso aí. E é por isso que amamos o Java. Espero que você esteja curtindo também!



# 06 **Para saber mais: classes e objetos**

Uma classe é uma estrutura que define um tipo de objeto. A classe é como um molde, que define quais são as características (atributos) e comportamentos (métodos) que os objetos desse tipo vão possuir. Por exemplo, podemos definir uma classe chamada `Pessoa` que tenha os atributos `nome` e `idade`, além do método `fazAniversario()`

A sintaxe para definir essa classe em Java é a seguinte:

```csharp
public class Pessoa {

    String nome;
    int idade;
  
    void fazAniversario() {
      idade++;
    }

}

```

Já um objeto, é uma instância de uma classe, sendo por meio dele que conseguimos representar informações na aplicação, pois a classe serve apenas para padronizar os objetos, mas não para representar um objeto em si. Para criar um objeto em Java, precisamos utilizar a palavra reservada **new** seguida do nome da classe e de parênteses vazios. Por exemplo, para criar um objeto do tipo Pessoa, podemos escrever o seguinte código:

```java
Pessoa pessoa1 = new Pessoa();

```

Nesse exemplo, criamos um objeto a partir da classe `Pessoa`, e guardamos na variável `pessoa1` uma referência a ele. Como esse objeto foi criado como sendo do tipo `Pessoa`, ele possui os atributos nome e idade, além do método `fazAniversario()`. É a partir do objeto que podemos de fato representar uma pessoa, ou seja, preencher os atributos e chamar os métodos. Por exemplo:

```csharp
Pessoa pessoa1 = new Pessoa();

pessoa1.nome = "Ana";
pessoa1.idade = 20;

System.out.println(pessoa1.nome + " tem " + pessoa1.idade + " anos");

pessoa1.fazAniversario();

System.out.println("A idade agora é: " +pessoa1.idade);

```

Podemos criar vários objetos do tipo `Pessoa`, sendo que todos eles terão os mesmos atributos e métodos, já que são da mesma classe, mas cada um pode possuir informações distintas. Por exemplo:

```csharp

Pessoa pessoa1 = new Pessoa();

pessoa1.nome = "Ana";
pessoa1.idade = 20;

System.out.println(pessoa1.nome + " tem " + pessoa1.idade + " anos");

pessoa1.fazAniversario();

System.out.println("A idade agora é: " +pessoa1.idade);

Pessoa pessoa2 = new Pessoa();

pessoa2.nome = "Carlos";
pessoa2.idade = 20;

System.out.println(pessoa2.nome + " tem " + pessoa2.idade + " anos");

pessoa2.fazAniversario();

System.out.println("A idade agora é: " +pessoa2.idade);
```


# 07 **Definição de métodos**

Suponha que você esteja trabalhando em uma aplicação Java de uma loja, que tenha a seguinte classe:

```java
public class Produto {

    String nome;
    double preco;
    double descontoParaPix;

    double pegaPrecoFinal(boolean pagamentoViaPix) {
        if (pagamentoViaPix == true) {
            double precoFinal = preco - descontoParaPix;
        } else {
            double precoFinal = preco;
        }
    }

}

```

O método **pegaPrecoFinal** realiza o cálculo do preço final do produto, levando em consideração se o pagamento será realizado via pix. No entanto, esse método foi definido de maneira incorreta.

Qual o problema do método `pegaPrecoFinal`?


[ ]Falta declarar os parâmetros do método.


[ ]O tipo de retorno do método está incorreto.

[X]Falta retornar o valor da variável **precoFinal** .

O método calcula o preço final do produto corretamente, mas não há uma instrução **return** para retornar o valor da variável **precoFinal** , causando assim um erro de compilação, pois o método foi definido como tendo um retorno do tipo `double`.

Alternativa correta
[ ]A estrutura de decisão do método está incorreta.


# 08 **Faça como eu fiz: projeto com orientação a objetos**


Agora é com você! Faça o mesmo procedimento que eu fiz na aula, criando o projeto **ScreenMatch** no IntelliJ, sendo que nele você deve criar a classe `Filme`, contendo os atributos `nome`, `anoDeLancamento`, `duracaoEmMinutos`, `incluidoNoPlano`, `somaDasAvaliacoes` e `totalDeAvaliacoes`, além de também conter os métodos `exibeFichaTecnica`, `avalia` e `pegaMedia`.

Além disso, crie também uma outra classe contendo o método `main`, no qual você deve criar um objeto `Filme`, preencher seus atributos e chamar seus métodos.


# 09 **Desafio: hora da prática**


Na programação orientada a objetos, conceitos fundamentais como classe, métodos, atributos e instanciação desempenham papéis cruciais na organização e estruturação do código.

Compreender esses conceitos é fundamental para a programação orientada a objetos, pois proporciona uma estrutura organizada, modular e reutilizável ao código. Para aprimorar essas habilidades, criamos uma lista de atividades **(não obrigatórias)** focada na prática para melhorar ainda mais sua experiência de aprendizagem. Vamos praticar?

1. Crie uma classe `Pessoa` com um método que exibe "Olá, mundo!" no console.
2. Crie uma classe `Calculadora` com um método que recebe um número como parâmetro e retorna o dobro desse número.
3. Crie uma classe `Musica` com atributos titulo, artista, anoLancamento, avaliacao e numAvaliacoes, e métodos para exibir a ficha técnica, avaliar a música e calcular a média de avaliações.
4. Crie uma classe `Carro` com atributos modelo, ano, cor e métodos para exibir a ficha técnica e calcular a idade do carro.
5. Crie uma classe `Aluno` com atributos nome, idade, e um método para exibir informações. Crie uma instância da classe Aluno, atribua valores aos seus atributos e utilize o método para exibir as informações.

---

Caso precise de ajuda, opções de solução das atividades estarão disponíveis na seção “Ver opinião do Instrutor”.


# 10 **O que aprendemos?**


## Nessa aula, você aprendeu:

* O que é uma classe, sua estrutura, como criar e por que isso é um conceito fundamental na orientação a objetos;
* O que são atributos: as "características" de um objeto, e a definir e visualizar esses valores;
* A instanciar objetos;
* Sobre os métodos (ou comportamentos) de um objeto;
* A pensar nas entidades do mundo real em forma de objetos, que possuem características (atributos) e comportamentos ou ações (métodos).
