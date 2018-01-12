import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    /*@Test
    void calculate() {
    }

    @Test
    void getDiscriminant() {
    }*/

    @Test
    public void testIfDiscriminantNeg() {
        QuadraticEquation qe = new QuadraticEquation("1", "1","1");
        ;
    }

    @Test
    public void testIfAnswersEquals() {
        QuadraticEquation qe = new QuadraticEquation("1", "6", "9");
        qe.calculate();
        assertEquals(-3, qe.getX1());
        assertEquals(-3, qe.getX2());
    }

}