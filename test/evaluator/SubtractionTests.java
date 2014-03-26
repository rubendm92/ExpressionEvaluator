package evaluator;

import datatype.ComplexNumber;
import evaluator.operations.binary.Subtraction;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SubtractionTests {
    
    @Test
    public void testSubstractionNumber() {
        assertEquals(0, new Subtraction(new Constant(2), new Constant(2)).evaluate());
        assertEquals(1.8, (double) new Subtraction(new Constant(3), new Constant(1.2)).evaluate(), 0.01);
        assertEquals(-0.7, new Subtraction(new Constant(0.3), new Constant(1)).evaluate());
        assertEquals(1, (double) new Subtraction(new Constant(1.5), new Constant(0.5)).evaluate(), 0.01);
    }
    
    @Test
    public void testSubtractionComplex() {
        assertEquals(new ComplexNumber(4, -4), new Subtraction(new Constant(new ComplexNumber(3, -1)), new Constant(new ComplexNumber(-1, 3))).evaluate());
    }
    
    @Test
    public void testSubtractionString() {
        assertEquals("Hola", new Subtraction(new Constant("HolaMundo"), new Constant("Mundo")).evaluate());
    }
    
    @Test
    public void testIntegerAdditionList() {
        ArrayList<Integer> result = (ArrayList<Integer>)new Subtraction(new Constant(createOneIntegerArrayList()), new Constant(createAnotherIntegerArrayList())).evaluate();
        assertTrue(-2 == result.get(0));
        assertTrue(-2 == result.get(1));
    }
    
    @Test
    public void testDoubleAdditionList() {
        ArrayList<Double> result = (ArrayList<Double>) new Subtraction(new Constant(createOneDoubleArrayList()), new Constant(createAnotherDoubleArrayList())).evaluate();
        assertEquals(1.7, result.get(0), 0.001);
        assertEquals(-2.0, result.get(1), 0.001);
    }

    private ArrayList<Integer> createOneIntegerArrayList() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        return list1;
    }
    
    private ArrayList<Integer> createAnotherIntegerArrayList() {
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        return list2;
    }
    
    private ArrayList<Double> createOneDoubleArrayList() {
        ArrayList<Double> list1 = new ArrayList<>();
        list1.add(2.2);
        list1.add(1.1);
        return list1;
    }
    
    private ArrayList<Double> createAnotherDoubleArrayList() {
        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(0.5);
        list2.add(3.1);
        return list2;
    }
}
