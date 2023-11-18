package jrath;

import java.io.IOException;

/**
 *
 * @author jrath
 * @version
 */
public interface SLInterface {
    public void speichern(String filename) throws IOException;
    public void laden(String filename) throws IOException;
    public void speichern() throws IOException;
    public void laden() throws IOException;
}
