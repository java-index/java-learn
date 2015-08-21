import lesson10.Bird;
import lesson10.Eagle;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BoxTest {

    Bird bird;

    @Before
    public void init(){
        bird = new Eagle();
    }

    @Test
    public void birdDefaultNameTest(){
        assertNull(bird.getName());
    }

    @Test
    public void birdSetNameTest(){
        String name = "bird";
        bird.setName(name);
        assertEquals("DIFFERENT NAME", bird.getName(), name);
    }

    @Test
    public void birdsSetPriceTest(){
        double price = 12.0;
        bird.setPrice(price);
        assertTrue("Should be = " + price, bird.getPrice() == price);
    }
}
