package org.example.stage5;

import java.util.*;

import static java.util.Arrays.asList;

public class ShuntingYardAlgorithm {

    static List<Character> OPERATORS = asList('+', '-', '*', '/', '^');


    /**
     * Алгоритм сортировочной станции
     * без функций
     * @see <a href="https://ru.wikipedia.org/wiki/Алгоритм_сортировочной_станции">https://ru.wikipedia.org/wiki/Алгоритм_сортировочной_станции</a>
     * @param inputString
     * @return
     */
    static String translate(String inputString) {
        String[] input = inputString.split(" ");
        List<String> output = new ArrayList<>();
        Deque<Character> stack = new LinkedList<>();
        for (String cur : input) {
            //Если токен — число, то добавить его в очередь вывода.
            if (isNumber(cur)) {
                output.add(cur);
            }

            if(cur.length() > 1){
                continue;
            }
            char c = cur.charAt(0);
            //Если токен — оператор op1, то:
            if (OPERATORS.contains(c)) {
                //Пока присутствует на вершине стека токен оператор op2, чей приоритет выше или равен приоритету op1,
                // и при равенстве приоритетов op1 является левоассоциативным:
                while (!stack.isEmpty() && stack.peek() != '(' && priority(stack.peek()) >= priority(c)) {
                    //Переложить op2 из стека в выходную очередь;
                    output.add(stack.pop().toString());
                }
                //Положить op1 в стек.
                stack.push(c);
            }
            //Если токен — открывающая скобка, то положить его в стек.
            if (c == '(') {
                stack.push(c);
            }
            //Если токен — закрывающая скобка:
            if (c == ')') {
                //Пока токен на вершине стека не открывающая скобка
                while (!stack.isEmpty() && stack.peek() != '(') {
                    //Переложить оператор из стека в выходную очередь.
                    output.add(stack.pop().toString());
                }
                //Если стек закончился до того, как был встречен токен открывающая скобка, то в выражении пропущена скобка.
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Missing '(' in expression");
                }
                //Выкинуть открывающую скобку из стека, но не добавлять в очередь вывода.
                stack.pop();
            }
        }
        //Если больше не осталось токенов на входе:
        //Пока есть токены операторы в стеке:
        while (!stack.isEmpty()) {
            //Если токен оператор на вершине стека — открывающая скобка, то в выражении пропущена скобка.
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Missing ')' in expression");
            }
            //Переложить оператор из стека в выходную очередь.
            output.add(stack.pop().toString());
        }


        return String.join(" ", output);
    }

    private static boolean isNumber(String number) {
        try{
            Integer.valueOf(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private static int priority(char operator) {
        if(operator == '^'){
            return 3;
        }
        return (operator == '+' || operator == '-') ? 1 : 2;
    }
}
