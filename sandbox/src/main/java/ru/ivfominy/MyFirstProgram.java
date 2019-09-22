package src.main.java.ru.ivfominy;

public class MyFirstProgram {
    public static void main(String[] args) {
        System.out.println("Hello!");

        double len=5;
        System.out.println("Площадь квадрата со стороной "+len+" = "+area(len));

        double a=4, b=5;
        System.out.println("Площадь прямоугольника со сторонами "+a+" и "+b+" = "+area(a,b));
    }

    public static  double area(double l){
        return  l*l;
    }

    public  static double area(double a, double b){
        return  a*b;
    }
}