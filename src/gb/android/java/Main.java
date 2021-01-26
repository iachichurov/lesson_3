package gb.android.java;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random random = new Random();

//Небольшой лаунчер

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите игру, выбрав число: 1 - \"Угадай номер\", 2 - \"Угадай фрукт\" ");
        int start = scanner.nextInt();
        if (start == 1) gNumber();
        else if (start == 2) gFruit();
        else System.out.println("Такой игры нет");
    }

/*
Написать программу, которая загадывает случайное число
от 0 до 9 и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить, больше ли
указанное пользователем число, чем загаданное, или меньше.
После победы или проигрыша выводится запрос –
«Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */


    public static void gNumber() {
        Scanner scanner = new Scanner(System.in);
        do {
            int cNum = random.nextInt(10);
            System.out.println("Я загадал число от 0 до 9, у Вас 3 попытки, чтобы его отгадать");
            for (int i = 3; i > 0; i--) {
                System.out.println("Введите свой ответ!");
                int qNum = scanner.nextInt();
                if (qNum == cNum) {
                    System.out.println("Вы угадали число!");
                    break;
                }
                System.out.println(qNum > cNum ? "Введенное число больше " : "Введенное число меньше ");
                System.out.println((i - 1) > 0 ? "У Вас осталось " + (i - 1) + " попыток." : "Вы проиграли.");
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет (1 – повторить, 0 – нет)");
        } while (scanner.nextInt() == 1);
    }

/*
Создать массив из слов String[] words =
{"apple", "orange", "lemon", "banana", "apricot", "avocado",
"broccoli", "carrot", "cherry", "garlic", "grape", "melon",
"leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
"peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает
ответ у пользователя, сравнивает его с загаданным словом и
сообщает, правильно ли ответил пользователь.
Если слово не угадано, компьютер показывает буквы, которые
стоят на своих местах. apple – загаданное apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться: String str = "apple";
char a = str.charAt(0); - метод, вернет char, который стоит в слове str на
первой позиции Играем до тех пор, пока игрок не отгадает слово.
Используем только маленькие буквы.
 */

    public static void gFruit() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        for (String s : words) System.out.println(s);
        int iWord = random.nextInt(words.length - 1);
        String word = words[iWord];
        int lWord = word.length();
        System.out.println("Я загадал слово из списка, попробуйте отгадать его");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите свой ответ");
            String answer = scanner.nextLine();
            if (!word.equals(answer)) {
                char[] charAnswer = answer.toCharArray();
                for (int i = 0; i < lWord; i++) {
                    if (i >= charAnswer.length) break;
                    if (word.charAt(i) != charAnswer[i]) charAnswer[i] = '#';
                }
                StringBuilder hint = new StringBuilder(String.valueOf(charAnswer));
                for (int i = hint.length(); i < 15; i++) hint.append("#");
                System.out.println("Подсказка: " +hint);
            } else {
                System.out.println("Вы угадали слово!");
                break;
            }
        }
        while (true);
    }
}
