public class Filmes {
    private String nome;
    private int anoDeLancemanto;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    void infoFilme(){
        System.out.println("Nome: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancemanto);
        System.out.println((incluidoNoPlano == true)? "Incluido no plano.":"Não incluido no plano."); 
        System.out.println("Somas das avaliaçoes: " + somaDasAvaliacoes);
        System.out.println("Total de avaliações: " + totalDeAvaliacoes);
        System.out.println("Média das avaliações: " + mediaDasAvaliacoes());
        System.out.println("Duração do filme:" + duracaoEmMinutos + "min");
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAnoDeLancemanto(int ano){
        this.anoDeLancemanto = ano;
    }

    public void setIncluidoNoPlano(boolean plano){
        this.incluidoNoPlano = plano;
    }

    public void setDuracao(int minutos){
        this.duracaoEmMinutos = minutos;
    }    

    public void setNotaTecnica(double nota){
        this.somaDasAvaliacoes += nota;
        this.totalDeAvaliacoes++;
    }

    private double mediaDasAvaliacoes(){
        return this.somaDasAvaliacoes / this.totalDeAvaliacoes;
    }
}
