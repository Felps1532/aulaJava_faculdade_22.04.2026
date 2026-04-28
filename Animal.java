public class Animal {
    // nome, patas, velocidade, localização
    private String nome;
    private int patas;
    private double velocidade;
    private int localizacao;

    public Animal() {
    }

    public Animal(String nome, int patas, double velocidade, int localizacao) {
        this.nome = nome;
        this.patas = patas;
        this.velocidade = velocidade;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public int getlocalizacao() {
        return localizacao;
    }

    public void setlocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Animal [nome=" + nome + ", patas=" + patas + ", velocidade=" + velocidade + ", localizacao="
                + localizacao
                + "]";
    }

    public void mover() {
        System.out.println("\n" + this.nome + " se movendo --------------");
        this.localizacao++;
        System.out.println("Posição atual: " + this.localizacao);
    }

}
