import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Animal> animais = new ArrayList<Animal>();
        // Animal animais[] = new Animal[10];
        boolean sair = false;

        animais.add(new Animal("Doguinho", 3, 5.5, 0)); // instanciando um objeto da classe Animal
        animais.add(new Animal("JacaréVaiPraCasa", 4, 3.5, 0));
        animais.add(new Peixe("Nemo", 2, 0.2, 0, 0));
        animais.add(new Ave("Águia", 2, 0.5, 0));

        do {
            limparConsole();
            System.out.print("""
                    ------ MENU ------
                    1. Cadastrar animal
                    2. Listar animal
                    3. Mover animal
                    4. Editar animal
                    0. Sair
                    >>>  """);
            int escolha = sc.nextInt();
            limparConsole();

            switch (escolha) {
                // CADASTRAR ANIMAL
                case 1:
                    System.out.println("--- Cadastrar animal ---");
                    do {
                        System.out.print("""
                                Escolha o tipo de animal:
                                1. Peixe
                                2. Ave
                                >>> """);
                        escolha = sc.nextInt();
                    } while (escolha < 1 || escolha > 2);

                    System.out.print("Digite o nome: ");
                    String nome = sc.next();
                    System.out.print("Digite as patas: ");
                    int patas = sc.nextInt();
                    System.out.print("Digite a velocidade: ");
                    double velocidade = sc.nextDouble();

                    if (escolha == 1) {
                        int tipoAgua = 2; // começa com um valor diferente de 0 e 1
                        do {
                            System.out.print("Digite o tipo de água(0 doce / 1 salgada): ");
                            tipoAgua = sc.nextInt();
                        } while (tipoAgua < 0 || tipoAgua > 1);
                        animais.add(new Peixe(nome, patas, velocidade, 0, tipoAgua));
                    } else if (escolha == 2) {
                        animais.add(new Ave(nome, patas, velocidade, 0));
                    }
                    break;
                // FIM CADASTRAR ANIMAL
                // LISTAR ANIMAIS
                case 2:
                    System.out.println("\n---- LISTAR ANIMAIS ----");
                    for (Animal a : animais) {
                        System.out.println(a.toString());
                    }
                    System.out.print("\nEnter para voltar ao menu.");
                    sc.nextLine(); // limpar o buffer
                    sc.nextLine();
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

                    limparConsole();
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
                default:
                    System.out.println("Opção inválida!!!");
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

    public static void limparConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (Exception e) {
        }
    }
}