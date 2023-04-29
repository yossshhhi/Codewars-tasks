package seven_kyu;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DinglemouseTest {
    @Test
    public void test() {
        Dinglemouse.runRunners();
        assertTrue("Sorry, try again :-(", Dinglemouse.ThreadUtil.checkThreads());
    }
}
