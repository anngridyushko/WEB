package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class to demostrate methods of QuadraticEquationComplex and QuadraticEquationFraction classes
 *
 * @author Ann Gridyushko
 * @version 1.0.0
 */
public class Controller {

    /**
     * Method of controller to demonstrate implemented classes uadraticEquationComplex and QuadraticEquationFraction
     */
    public static void Start() {
        Complex z1 = new Complex(5,6);
        Complex z2 = new Complex(1,0);
        Complex z3 = new Complex(0,1);
        Fraction f1 = new Fraction(7);
        Fraction f2 = new Fraction(10);
        Fraction f3 = new Fraction(90);

        QuadraticEquation e1 = new QuadraticEquationFraction(f1,f2,f3);
        System.out.println(e1);
        System.out.println("root 1 = " + e1.getRoot1() +
                "\nroot 2 = " + e1.getRoot2() +
                "\nextremum: " + e1.getExtremum());
        e1.getIntervals();

        QuadraticEquation e2 = new QuadraticEquationComplex(z1,z2,z3);
        System.out.println(e2);
        System.out.println("root 1 = " + e2.getRoot1() +
                "\nroot 2 = " + e2.getRoot2());

        List<QuadraticEquation> equations = new ArrayList<>();

        equations.add(e1);
        equations.add(e2);
        equations.add(new QuadraticEquationFraction(new Fraction(6,8), new Fraction(1,1), new Fraction(4,11)));
        equations.add(new QuadraticEquationComplex(new Complex(6,8), new Complex(1,1), new Complex(4,11)));
        equations.add(new QuadraticEquationFraction(new Fraction(1,8), new Fraction(-1,2), new Fraction(0,11)));
        equations.add(new QuadraticEquationFraction(new Fraction(1,2), new Fraction(11,2), new Fraction(1,1)));
        equations.add(new QuadraticEquationFraction(new Fraction(2,8), new Fraction(1,3), new Fraction(-4,1)));
        equations.add(new QuadraticEquationComplex(new Complex(6,0), new Complex(-1,-111), new Complex(7,1)));

        Complex max = new Complex(0,0);
        Complex min = new Complex(Double.MAX_VALUE, 0);

        for(QuadraticEquation qe: equations){
            System.out.println(qe);
            if(max.mod() < qe.getRoot1().mod()) {
                max = qe.getRoot1();
            } else if(max.mod() < qe.getRoot2().mod()) {
                max = qe.getRoot2();
            }else if(min.mod() > qe.getRoot1().mod()) {
                min = qe.getRoot1();
            }else if(min.mod() > qe.getRoot2().mod()) {
                min = qe.getRoot1();
            }
        }

        System.out.println("min root = " + min + "\nmax root = " + max);

    }

}
