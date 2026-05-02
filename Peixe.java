import javax.swing.JOptionPane;

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
        String tipoAgua = agua == 0 ? "Doce" : "Salgada";

        return "\n" + getNome() + "\n"
                + "------------------------------\n"
                + "Tipo: Peixe\n"
                + "Patas: " + getPatas() + "\n"
                + "Velocidade: " + getVelocidade() + "\n"
                + "Localizacao: " + getlocalizacao() + "\n"
                + "Agua: " + tipoAgua + "\n";
    }

    @Override
    public void mover() { // para sobrescrever um método, usamos a mesma assinatura
        super.setlocalizacao(super.getlocalizacao() + 2);
        JOptionPane.showMessageDialog(null,
                getNome() + " nadou\n"
                        + "Posicao atual: " + super.getlocalizacao());
    }
}
