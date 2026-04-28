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
            System.out.print("""
                    ------ MENU ------
                    1. Cadastrar animal
                    2. Listar animal
                    3. Mover animal
                    4. Editar animal
                    0. Sair
                    >>> """);
            int escolha = sc.nextInt();

            switch (escolha) {
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
                    String nome = sc.nextLine();
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
                case 2:
                    System.out.println("\n---- LISTAR ANIMAIS ----");
                    for (Animal a : animais) {
                        System.out.println(a.toString());
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("---- MOVER ANIMAL ----");
                    System.out.println("Escolha o animal para mover:");
                    for (int i = 0; i < animais.size(); i++) {
                        System.out.println((i + 1) + ". " + animais.get(i).getNome());
                    }
                    int escolhaAnimal = sc.nextInt();
                    if (escolhaAnimal < 1 || escolhaAnimal > animais.size()) {
                        System.out.println("Opção inválida!");
                        break;
                    }
                    Animal animal = animais.get(escolhaAnimal - 1);
                    animal.mover();
                    break;
                default:
                    System.out.println("Opção inválida!!!");
                    break;
            }
        } while (!sair);

        sc.close();
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
}