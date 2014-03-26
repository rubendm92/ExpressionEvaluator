package evaluator;

import datatype.ComplexNumber;
import evaluator.operations.binary.Addition;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AdditionTests {
    
    @Test
    public void testAdditionNumber() {
        assertEquals(4, new Addition(new Constant(2), new Constant(2)).evaluate());
        assertEquals(2.4, new Addition(new Constant(2), new Constant(0.4)).evaluate());
        assertEquals(1.3, new Addition(new Constant(0.3), new Constant(1)).evaluate());
        assertEquals(4.1, new Addition(new Constant(1.2), new Constant(2.9)).evaluate());
    }
    
    @Test
    public void testAdditionComplex() {
        assertEquals(new ComplexNumber(2, 2), new Addition(new Constant(new ComplexNumber(3, -1)), new Constant(new ComplexNumber(-1, 3))).evaluate());
    }
    
    @Test
    public void testAdditionString() {
        assertEquals("HolaMundo", new Addition(new Constant("Hola"), new Constant("Mundo")).evaluate());
    }
    
    @Test
    public void testIntegerAdditionList() {
        ArrayList<Integer> result = (ArrayList<Integer>)new Addition(new Constant(createOneIntegerArrayList()), new Constant(createAnotherIntegerArrayList())).evaluate();
        assertTrue(4 == result.get(0));
        assertTrue(6 == result.get(1));
    }
    
    @Test
    public void testDoubleAdditionList() {
        ArrayList<Double> result = (ArrayList<Double>) new Addition(new Constant(createOneDoubleArrayList()), new Constant(createAnotherDoubleArrayList())).evaluate();
        assertEquals(2.7, result.get(0), 0.001);
        assertEquals(4.2, result.get(1), 0.001);
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
