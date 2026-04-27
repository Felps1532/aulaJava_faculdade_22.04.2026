public class Peixe extends Animal {
    private int agua; // 0 doce / 1 salgada

    public Peixe(String nome, int patas, double velocidade, int localizacao, int agua) {
        super(nome, patas, velocidade, localizacao);
        this.agua = agua;
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    @Override
    public String toString() {
        return "Peixe [agua=" + agua + ", getAgua()=" + getAgua() + ", getNome()=" + getNome() + ", getPatas()="
                + getPatas() + ", getVelocidade()=" + getVelocidade() + ", getlocalizacao()=" + getlocalizacao() + "]";
    }

    @Override
    public void mover() { // para sobrescrever um método, usamos a mesma assinatura
        System.out.println(getNome() + " nadando --------------");
        super.setlocalizacao(super.getlocalizacao() + 2);
        System.out.println("Posição atual " + super.getlocalizacao());
    }
}
