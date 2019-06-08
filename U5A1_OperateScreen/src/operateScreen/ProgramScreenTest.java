package operateScreen;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgramScreenTest {

    @Ignore
    public void initialize() {
    }

    @Test
    public void changeCurrent() {
        int temp = 74;
        temp++;
        System.out.println(temp);
    }

    @Test
    public void printSettings() {
        System.out.println("Settings are printed.");
    }
}