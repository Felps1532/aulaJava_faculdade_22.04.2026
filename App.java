import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {

    static ArrayList<Animal> animais = new ArrayList<Animal>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Animal animais[] = new Animal[10];
        boolean sair = false;

        // CADASTRO DE ANIMAIS EXEMPLO
        animais.add(new Animal("Doguinho", 3, 5.5, 0)); // instanciando um objeto da classe Animal
        animais.add(new Animal("JacaréVaiPraCasa", 4, 3.5, 0));
        animais.add(new Peixe("Nemo", 2, 0.2, 0, 0));
        animais.add(new Ave("Águia", 2, 0.5, 0));
        // FIM CADASTRO DE ANIMAIS EXEMPLO

        do {
            int escolha = menuPrincipal();

            switch (escolha) {
                case 1:
                    cadastrarAnimal();
                case 2:
                    listarAnimais();
                    break;
                // FIM LISTAR ANIMAIS
                // MOVER ANIMAL
                case 3:
                    System.out.println("---- MOVER ANIMAL ----");
                    System.out.println("Escolha o animal para mover:");
                    for (int i = 0; i < animais.size(); i++) {
                        System.out.println((i + 1) + ". " + animais.get(i).getNome());
                    }
                    int escolhaAnimalMover = sc.nextInt();
                    if (escolhaAnimalMover < 1 || escolhaAnimalMover > animais.size()) {
                        System.out.println("Opção inválida!");
                        break;
                    }
                    Animal animalMover = animais.get(escolhaAnimalMover - 1);
                    animalMover.mover();

                    System.out.print("Pressione Enter para continuar...");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                // FIM MOVER ANIMAL
                // EDITAR ANIMAL
                case 4:
                    System.out.println("---- EDITAR ANIMAL ----");
                    System.out.println("Escolha o animal para editar:");
                    int escolhaAnimalEditar = 0;

                    // PAREI AQUI, erro no índice

                    do {
                        for (int i = 0; i < animais.size(); i++) {
                            System.out.println((i + 1) + ". " + animais.get(i).getNome());
                        }
                        escolhaAnimalEditar = sc.nextInt();

                        if (escolhaAnimalEditar < 0 || escolhaAnimalEditar > animais.size()) {
                            System.out.println("\nOpção inválida\n");
                        }
                    } while (escolhaAnimalEditar < 0 || escolhaAnimalEditar > animais.size());

                    // mostrar dados do animal escolhido antes de editar
                    System.out.println("Dados atuais:");
                    System.out.println(animais.get(escolhaAnimalEditar + 1).toString());

                    boolean sairEditar = false;
                    int escolhaAtributoEditar;
                    do {
                        System.out.println("""
                                O que deseja editar:
                                1. nome
                                2. patas
                                3. velocidade
                                4. localização
                                0. Sair
                                >>>""");
                        escolhaAtributoEditar = sc.nextInt();

                        if (escolhaAtributoEditar == 1) {
                            System.out.println("Digite o novo nome: ");
                            animais.get(escolhaAnimalEditar - 1).setNome(sc.nextLine());
                        } else if (escolhaAtributoEditar == 2) {
                            System.out.println("Digite a nova quantidade de patas: ");
                            animais.get(escolhaAnimalEditar - 1).setPatas(sc.nextInt());
                        } else if (escolhaAtributoEditar == 3) {
                            System.out.println("Digite a nova velocidade: ");
                            animais.get(escolhaAnimalEditar - 1).setVelocidade(sc.nextDouble());
                        } else if (escolhaAtributoEditar == 3) {
                            System.out.println("Digite a nova localização: ");
                            animais.get(escolhaAnimalEditar - 1).setlocalizacao(sc.nextInt());
                        } else if (escolhaAtributoEditar == 0) {
                            sairEditar = true;
                        } else {
                            System.out.println("Escolha inválida, tente novamente!");
                        }
                    } while (!sairEditar);
                    break;
                // FIM EDITAR ANIMAL
                case 0:
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!!!");
                    break;
            }
        } while (!sair);

        sc.close();
    }

    public int tipoAnimalCadastro() {
        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.print("""
                    1. Peixe
                    2. Ave
                    >>> """);
            escolha = sc.nextInt();
        } while (escolha < 1 || escolha > 2);

        sc.close();
        return escolha;
    }

    // MÉTODO MENU PRINCIPAL ----
    public static int menuPrincipal() {
        int escolha = 0;

        try {
            escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "------ MENU ------\r\n" +
                            "1. Cadastrar animal\r\n" +
                            "2. Listar animal\r\n" +
                            "3. Mover animal\r\n" +
                            "4. Editar animal\r\n" +
                            "0. Sair"));
        } catch (NumberFormatException e) {
            e.getMessage();
        }

        return escolha;
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
                    animais.get(animais.size()).getNome() + " cadastrado(a) com sucesso!");
        }
    }
    // FIM MÉTODO CADASTRAR ANIMAL ----

    // MÉTODO LISTAR ANIMAIS ----
    public void listarAnimais() {
        String listaAnimais = "----- ANIMAIS -----\n";
        for (Animal a : animais) {
            listaAnimais += a.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, listaAnimais);
    }
    // FIM MÉTODO LISTAR ANIMAIS ----
}