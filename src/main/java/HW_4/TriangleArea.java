package HW_4;

import static java.lang.Math.sqrt;

public class TriangleArea {

    public int triangle() {

        int a = 6;
        int b = 5;
        int c = 4;



        int p = (a + b + c) / 2;

        int area = (int) sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println("Площадь треугольника равна: " + area);


        return area;
    }
}



