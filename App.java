import java.nio.channels.Pipe.SourceChannel;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Animal animais[] = new Animal[10];
        boolean sair = false;

        animais[0] = new Animal("Doguinho", 3, 5.5, 0); // instanciando um objeto da classe Animal
        animais[1] = new Animal("JacaréVaiPraCasa", 4, 3.5, 0);
        animais[2] = new Peixe("Nemo", 2, 0.2, 0, 0);
        animais[3] = new Ave("Águia", 2, 0.5, 0);

        while (!sair) {
            System.out.println("\n----MENU ----");
            System.out.println("""
                1. Cadastrar animal
                2. Listar animal
                3. Mover animal
                4. Editar animal
                0. Sair
            """);

            switch () {

            }
        } 
        

        for (Animal a : animais) {
            if (a != null) {
                a.mover();
            }
        }

        sc.close();
    }
}