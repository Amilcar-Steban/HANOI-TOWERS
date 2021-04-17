package hanoitowers;

import java.util.ArrayList;
import java.util.Scanner;

public class Hanoi {

    /**
     * Parte del codigo fue obtenido de este autor:
     * https://programmerclick.com/article/4693807728/
     */
    private static ArrayList<Integer> start;
    private static ArrayList<Integer> middle;
    private static ArrayList<Integer> end;
    private static String info = "";
    private static Scanner sc;

    //Cambios de posicion de placas
    public static void hanoi(int n, ArrayList<Integer> start, ArrayList<Integer> middle, ArrayList<Integer> end) {
        if (n == 1) {
            move(start, end);
        } else {

            hanoi(n - 1, start, end, middle);

            move(start, end);

            hanoi(n - 1, middle, start, end);

        }
    }

    //Muestra los movimientos de las placas en las torres
    public static void move(ArrayList<Integer> a, ArrayList<Integer> b) {
        info += start.size() + " " + middle.size() + " " + end.size() + "\n";
        b.add(a.get(a.size() - 1));
        a.remove(a.size() - 1);
    }


    //Lee las lineas
    public static void readLines(int n) {
        if (n == 1) {
            int length = sc.nextInt();
            sc.nextLine();
            start.clear();
            middle.clear();
            end.clear();
            addPositions(length);
            hanoi(length, start, middle, end);
            info += start.size() + " " + middle.size() + " " + end.size() + "\n\n";
        } else {
            int length = sc.nextInt();
            sc.nextLine();
            start.clear();
            middle.clear();
            end.clear();
            addPositions(length);
            hanoi(length, start, middle, end);
            info += start.size() + " " + middle.size() + " " + end.size() + "\n\n";
            readLines(n - 1);
        }

    }

    //Añade posiciones a un array para trabajar con su tamaño
    public static void addPositions(int n) {
        if (n == 1) {
            start.add(n);
        } else {
            start.add(n);
            addPositions(n - 1);
        }
    }
    
    //Inicializa variables y comienza el programa
    public static void main(String[] args) {

        start = new ArrayList<>();
        middle = new ArrayList<>();
        end = new ArrayList<>();

        sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        readLines(n);
        System.out.print(info);
    }
}
