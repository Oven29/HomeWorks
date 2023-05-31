package HomeWork1;

class Test {
    public static void main(String[] args) {
        // будет ошибка
        // Sword<Plastic> placticSword = new Sword<>();

        Sword<Steel> Sword = new Sword<>();
        if (Sword.proverka(new Steel())) {
            System.out.println("Меч из steel прошёл проверку прочности");
        } else {
            System.out.println("Меч из steel не прошёл проверку прочности");
        }
    }
}
