import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class App {

    static ArrayList<Animal> animais = new ArrayList<Animal>();

    public static void main(String[] args) {
        // CADASTRO DE ANIMAIS EXEMPLO
        animais.add(new Animal("Doguinho", 3, 5.5, 0)); // instanciando um objeto da classe Animal
        animais.add(new Animal("JacaréVaiPraCasa", 4, 3.5, 0));
        animais.add(new Peixe("Nemo", 2, 0.2, 0, 0));
        animais.add(new Ave("Águia", 2, 0.5, 0));
        // FIM CADASTRO DE ANIMAIS EXEMPLO

        menuPrincipal();
    }

    // MÉTODO MENU PRINCIPAL ----
    public static void menuPrincipal() {
        boolean sairMenu = false;
        int escolha = 0;

        do {
            try {
                escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "------ MENU ------\r\n" +
                                "1. Cadastrar animal\r\n" +
                                "2. Listar animal\r\n" +
                                "3. Mover animal\r\n" +
                                "4. Editar animal\r\n" +
                                "0. Sair"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato de número não aceito!", "Exceção",
                        JOptionPane.ERROR_MESSAGE);
            }

            switch (escolha) {
                case 1:
                    cadastrarAnimal();
                    break;
                case 2:
                    listarAnimais();
                    break;
                case 3:
                    moverAnimal();
                    break;
                case 4:
                    editarAnimal();
                    break;
                case 0:
                    sairMenu = true;
                    break;
            }
        } while (!sairMenu || (escolha < 0 || escolha > 4));
    }
    // FIM MÉTODO MENU PRINCIPAL ----

    // MÉTODO CADASTRAR ANIMAL ----
    public static void cadastrarAnimal() {
        int escolhaTipoAnimal = 0;

        JOptionPane.showMessageDialog(null, "--- CADASTRAR ANIMAL ---");
        do {
            try {
                escolhaTipoAnimal = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de animal\n" +
                        "1. Peixe\n" +
                        "2. Ave"));
            } catch (NumberFormatException e) {
                e.getMessage();
            }
        } while (escolhaTipoAnimal < 1 || escolhaTipoAnimal > 2);

        String nome = JOptionPane.showInputDialog("Digite o nome");
        int patas = Integer.parseInt(JOptionPane.showInputDialog("Digite as patas"));
        double velocidade = (double) Integer.parseInt(JOptionPane.showInputDialog("Digite a velocidade"));

        int tamanhoArray = animais.size();

        if (escolhaTipoAnimal == 1) {
            int tipoAgua = -1;
            do {
                try {
                    tipoAgua = Integer.parseInt(
                            JOptionPane.showInputDialog("Digite o tipo de água(0 doce / 1 salgada)"));
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            } while (tipoAgua < 0 || tipoAgua > 1);

            animais.add(new Peixe(nome, patas, velocidade, 0, tipoAgua));

        } else if (escolhaTipoAnimal == 2) {
            animais.add(new Ave(nome, patas, velocidade, 0));
        }

        if (tamanhoArray < animais.size()) {
            JOptionPane.showMessageDialog(null,
                    animais.get(animais.size() - 1).getNome() + " cadastrado(a) com sucesso!");
        }
    }
    // FIM MÉTODO CADASTRAR ANIMAL ----

    // MÉTODO LISTAR ANIMAIS ----
    public static void listarAnimais() {
        String listaAnimais = "----- ANIMAIS -----\n";
        for (Animal a : animais) {
            listaAnimais += a.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, listaAnimais);
    }
    // FIM MÉTODO LISTAR ANIMAIS ----

    // MÉTODO MOVER ANIMAL
    public static void moverAnimal() {
        JOptionPane.showMessageDialog(null, "---- MOVER ANIMAL ----");
        String listaAnimaisMover = "Escolha o animal para mover:\n";

        for (int i = 0; i < animais.size(); i++) {
            listaAnimaisMover += (i + 1) + ". " + animais.get(i).getNome() + "\n";
        }

        int escolhaAnimalMover = Integer.parseInt(JOptionPane.showInputDialog(null, listaAnimaisMover));
        if (escolhaAnimalMover < 1 || escolhaAnimalMover > animais.size()) {
            JOptionPane.showMessageDialog(null, "Opção inválida!");
        } else {
            Animal animalMover = animais.get(escolhaAnimalMover - 1);
            animalMover.mover();
        }
    }
    // FIM MÉTODO MOVER ANIMAL

    // MÉTODO EDITAR ANIMAL
    public static void editarAnimal() {
        JOptionPane.showMessageDialog(null, "---- EDITAR ANIMAL ----");
        int escolhaAnimalEditar = -1;
        String animaisEditar = "Escolha um animal para editar:\n";

        for (int i = 0; i < animais.size(); i++) {
            animaisEditar += (i + 1) + ". " + animais.get(i).getNome() + "\n";
        }

        do {
            try {
                escolhaAnimalEditar = Integer
                        .parseInt(JOptionPane.showInputDialog(animaisEditar));

                if (escolhaAnimalEditar < 1 || escolhaAnimalEditar > animais.size()) {
                    JOptionPane.showMessageDialog(null, "\nOpção inválida!", "Erro de Index",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Index fora dos limites!\nErro: " + e.getMessage(),
                        "Exceção", JOptionPane.ERROR_MESSAGE);
                escolhaAnimalEditar = -1;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato de número não aceito!\nErro: " + e.getMessage(),
                        "Exceção", JOptionPane.ERROR_MESSAGE);
                escolhaAnimalEditar = -1;
            }
        } while (escolhaAnimalEditar < 1 || escolhaAnimalEditar > animais.size());

        boolean sairEditar = false;

        do {
            int escolhaAtributoEditar = -1;

            try {
                do {
                    escolhaAtributoEditar = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Dados atuais: " +
                                    animais.get(escolhaAnimalEditar - 1).toString() +
                                    "\n---------------------\n" +
                                    "O que deseja editar?\n" +
                                    "1. nome\n" +
                                    "2. patas\n" +
                                    "3. velocidade\n" +
                                    "4. localização\n" +
                                    "(0. menu principal)"));
                } while (escolhaAtributoEditar < 1 || escolhaAnimalEditar > animais.size());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato de número não aceito!\nErro: " + e.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }

            do {
                try {
                    escolhaAtributoEditar = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Dados atuais: " +
                                    animais.get(escolhaAnimalEditar - 1).toString() +
                                    "\n---------------------\n" +
                                    "O que deseja editar?\n" +
                                    "1. nome\n" +
                                    "2. patas\n" +
                                    "3. velocidade\n" +
                                    "4. localização\n" +
                                    "(0. menu principal)"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Formato de número não aceito!\nErro: " + e.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

                try {
                    switch (escolhaAtributoEditar) {
                        case 1:
                            String novoNome = JOptionPane.showInputDialog("Digite o novo nome:");
                            animais.get(escolhaAnimalEditar - 1).setNome(novoNome);
                            break;
                        case 2:
                            int novasPatas = Integer.parseInt(
                                    JOptionPane.showInputDialog("Digite a nova quantidade de patas:"));
                            animais.get(escolhaAnimalEditar - 1).setPatas(novasPatas);
                            break;
                        case 3:
                            double novaVelocidade = Double.parseDouble(
                                    JOptionPane.showInputDialog("Digite a nova velocidade:"));
                            animais.get(escolhaAnimalEditar - 1).setVelocidade(novaVelocidade);
                            break;
                        case 4:
                            int novaLocalizacao = Integer.parseInt(
                                    JOptionPane.showInputDialog("Digite a nova localizacao:"));
                            animais.get(escolhaAnimalEditar - 1).setlocalizacao(novaLocalizacao);
                            break;
                        case 0:
                            menuPrincipal();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Escolha invalida, tente novamente!", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Formato de número não aceito!\nErro: " + e.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            } while (escolhaAtributoEditar < 1 || escolhaAnimalEditar > animais.size());
        } while (!sairEditar);
    }
    // FIM MÉTODO EDITAR ANIMAL
}
