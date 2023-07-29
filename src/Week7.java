import java.util.Scanner;
import java.util.Stack;

public class Week7 {
    public static void main(String[] args) {
        Stack<Character> stack1 = new Stack<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите скобочную последовательность");
        String input = in.nextLine();
        boolean flag = true;

        for (int i=0; i<input.length(); i++) {
            char sym = input.charAt(i);
            // если символ строки - открывающая скобка, добавляем в стек
            if (sym == '(' || sym == '[' || sym == '{') {
                stack1.push(sym);
            }
            // если символ строки закрывающая скобка или любой другой символ
            else {
                // если символ строки - закрывающая скобка
                if (sym == ')' || sym == ']' || sym == '}') {
                    // если стек пустой, т.е. мы в самом начале или до этого места последовательность была правильная
                    // то закрывающая скобка делает последовательность неправильной
                    if (stack1.empty()) {
                        System.out.println("Скобочная последовательность НЕПРАВИЛЬНАЯ");
                        flag = false;
                        break;
                    }
                    // если последний символ из стека - парный к закрывающей скобке из строки, то удаляем элемент из стека
                    else {
                        char stsym = stack1.peek();
                        boolean c1 = (stsym == '(' && sym == ')');
                        boolean c2 = (stsym == '[' && sym == ']');
                        boolean c3 = (stsym == '{' && sym == '}');
                        if (c1 || c2 || c3) {
                            stack1.pop();
                        }
                        // символ из стека и символ из строки оказались непарными, вроде (}
                        else {
                            System.out.println("Скобочная последовательность НЕПРАВИЛЬНАЯ");
                            flag = false;
                            break;
                        }
                    }
                }
                // если символ строки - не закрывающая скобка, т.е. вообще никакая из скобок
                else {
                    System.out.println("В строке содержатся другие символы кроме скобок");
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            if (stack1.empty()) {
                System.out.println("Урааа, я не зря мучилась, потому что проследовательность ПРАВИЛЬНАЯ");
            }
            else {
                System.out.println("Последовательность НЕПРАВИЛЬНАЯ и содержит лишнюю открывающую скобку");
            }
        }
    }
}