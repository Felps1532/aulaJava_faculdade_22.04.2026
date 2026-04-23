public class Ave extends Animal {

    public Ave(String nome, int patas, double velocidade, int localizacao) {
        super(nome, patas, velocidade, localizacao);
    }

    @Override
    public void mover() {
        System.out.println(super.getNome() + " está voando --------------");
        super.setlocalizacao(getlocalizacao() + 3);
        System.out.println("Localização atual: " + super.getlocalizacao());
    }
}
