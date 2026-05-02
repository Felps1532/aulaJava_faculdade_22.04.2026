import javax.swing.JOptionPane;

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
                + "Localizacao: " + getlocalizacao() + "\n";
    }

    @Override
    public void mover() {
        super.setlocalizacao(getlocalizacao() + 3);
        JOptionPane.showMessageDialog(null,
                super.getNome() + " voou\n"
                        + "Localizacao atual: " + super.getlocalizacao());
    }
}
