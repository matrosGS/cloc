
import com.alexm.Counter;
import com.alexm.Reader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alexey M. on 20.08.2016.
 */
public class CountTest {

    @Test
    public void count(){
       assertEquals(
           new Counter().count(new Reader().readFile("test.txt")),
           19);
    }
}
