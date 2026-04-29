public class Ave extends Animal {

    public Ave(String nome, int patas, double velocidade, int localizacao) {
        super(nome, patas, velocidade, localizacao);
    }

    @Override
    public String toString() {
        return "\n" + getNome() + "\n"
                + "------------------------------\n"
                + "Tipo: Ave\n"
                + "Patas: " + getPatas() + "\n"
                + "Velocidade: " + getVelocidade() + "\n"
                + "Localização: " + getlocalizacao() + "\n";
    }

    @Override
    public void mover() {
        System.out.println("\n" + super.getNome() + " voou --------------");
        super.setlocalizacao(getlocalizacao() + 3);
        System.out.println("Localização atual: " + super.getlocalizacao());
    }
}
