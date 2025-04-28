public class Principal {
    public static void main(String[] args) {
        Filmes meuFilme = new Filmes();
        meuFilme.setNome("O poderoso Chefão");
        meuFilme.setAnoDeLancemanto(1970);
        meuFilme.setDuracao(180);
        
        meuFilme.setIncluidoNoPlano(true);
        meuFilme.setNotaTecnica(10);
        meuFilme.setNotaTecnica(5);
        meuFilme.setNotaTecnica(4);
        meuFilme.setNotaTecnica(9);
        meuFilme.setNotaTecnica(6);
        meuFilme.infoFilme();
    }
}