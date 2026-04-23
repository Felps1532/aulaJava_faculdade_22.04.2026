public class App {
    public static void main(String[] args) {
        Animal animais[] = new Animal[10];

        Animal doguinho = new Animal("Doguinho", 3, 5.5, 0); // instanciando um objeto da classe Animal
        Animal jacareVaiPraCasa = new Animal("JacaréVaiPraCasa", 4, 3.5, 0);
        Animal nemo = new Peixe("Nemo", 1, 0.2, 0, 0);

        animais[0] = doguinho;
        animais[1] = jacareVaiPraCasa;
        animais[2] = nemo;

        for (Animal a : animais) {
            if (a != null) {
                a.mover();
            }
        }
    }
}