import java.awt.*;

import javax.swing.*;
import java.lang.Math;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Polygon extends JPanel {
    static int n = randomN(); //кол-во граней
    static int R ; //радиус
    static int X = 250, Y = 250;//координаты центра
    static int x[] = new int [n];//координаты точек
    static int y[] = new int [n];//
    static int x1, y1, x2, y2;
    static int j = n;

    public Polygon(){

        JFrame jf = new JFrame();
        jf.setSize(800, 800);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);

        jf.getContentPane().add(this);

        jf.setVisible(true);
        jf.repaint();

    }

    public static int randomN() {
        int n = (int) (Math.random() * (8 - 3 + 1) + 3);
        return n;
    }

    public int randomR() {
        int r = (int) (Math.random() * (100 - 30 + 1) + 30);
        return r;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        double a, b,  z = 0 ;  int i = 0; double angle = 360.0 / n ;
        //цикл создающий массив из точек
        while(i < n){
            R = randomR();
            a = Math.cos( z/180*Math.PI);
            b = Math.sin( z/180*Math.PI);
            x[i] = X + (int)(Math.round(a) * R);
            y[i] = Y - (int)(Math.round(b) * R);
            z = z + angle;
            i++;
        }
        System.out.println();

        int x1, x2, y1, y2;

        int j = n-1;		//цикл передающий координаты для прорисовки грани
        while(j >= 0){

            if(j > 0){
                x1 = x[j]; x2 = x[j-1];
                y1 = y[j]; y2 = y[j-1];
                g.drawLine(x1, y1, x2, y2);
                j--;
            }
            else{
                x1 = x[j]; x2 = x[n-1];
                y1 = y[j]; y2 = y[n-1];
                g.drawLine(x1, y1, x2, y2);
                j--;

            }
        }

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

        g.drawLine(0,500, 500, 500);

        int[] e = new int[n];
        int[] f = new int[n];
        int Ox = 500;

        i=0;
        while(i  < n){
            int bx = x[i];
            e[i] =  bx;
            System.out.println(x[i]);
            System.out.println(y[i]);

            f[i] = (2*(Ox - y[i]) + y[i]) ;
            i++;
        }

        j = n-1;
        while(j >= 0){

            if(j > 0){
                x1 = e[j]; x2 = e[j-1];
                y1 = f[j]; y2 = f[j-1];
                g.drawLine(x1, y1, x2, y2);
                j--;
            }
            else{
                x1 = e[j]; x2 = e[n-1];
                y1 = f[j]; y2 = f[n-1];
                g.drawLine(x1, y1, x2, y2);
                j--;

            }
        }

        int[] c = new int[n];
        int[] d = new int[n];

        i = 0;
        a = Math.toRadians(-15);
        while(i  < n){
            int bx = x[i];
            c[i] = (int) (bx*Math.cos(a) - y[i]*Math.sin(a));
            System.out.println(x[i]);
            System.out.println(y[i]);

            d[i] = (int) (bx*Math.sin(a) + y[i]*Math.cos(a)) ;
            i++;
        }

        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));

        g.drawString("O", 10,-10);

        j = n-1;

        while(j >= 0) {

            if (j > 0) {
                x1 = c[j];
                x2 = c[j - 1];
                y1 = d[j];
                y2 = d[j - 1];
                g.drawLine(x1, y1, x2, y2);
                g.setColor(Color.BLUE);
                j--;
                System.out.println("I finish");
            } else {
                x1 = c[j];
                x2 = c[n - 1];
                y1 = d[j];
                y2 = d[n - 1];
                g.drawLine(x1, y1, x2, y2);
                g.setColor(Color.BLUE);
                j--;

            }
        }




    }


    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        Polygon NY = new Polygon();
        NY.repaint();
        System.out.println(n);
        System.out.println("Введите угол");
    }

}
