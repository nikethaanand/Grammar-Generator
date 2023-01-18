import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

  private Main objectMain;

  @BeforeEach
  void setUp() {

    objectMain = new Main();
  }

  @Test
  void testToString() {
    Main testMain = new Main();
    Assertions.assertNotEquals(objectMain, testMain);
    Assertions.assertEquals(testMain.toString(), objectMain.toString());
  }
}
