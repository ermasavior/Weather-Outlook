package test.jdepend;

import java.io.*;
import java.util.*;

import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import junit.framework.*;

public class DistanceTest extends TestCase {

    private JDepend jdepend;

    public DistanceTest(String name) {
        super(name);
    }

    protected void setUp() throws IOException {

        jdepend = new JDepend();

        jdepend.addDirectory("..\\Weather-Outlook\\src\\openweathermap");
        jdepend.addDirectory("..\\Weather-Outlook\\src\\application");
    }

    /**
     * Tests the conformance of a single package to a
     * distance from the main sequence (D) within a
     * tolerance.
     */
    public void testOnePackage() {

        double ideal = 0.0;
        double tolerance = 0.125;  // project-dependent

        jdepend.analyze();

        JavaPackage p = jdepend.getPackage("src");

        assertEquals("Distance exceeded: " + p.getName(),
                ideal, p.distance(), tolerance);
    }

    /**
     * Tests the conformance of all analyzed packages to a
     * distance from the main sequence (D) within a tolerance.
     */
    public void testAllPackages() {

        double ideal = 0.0;
        double tolerance = 0.5;  // project-dependent

        Collection packages = jdepend.analyze();

        Iterator iter = packages.iterator();
        while (iter.hasNext()) {
            JavaPackage p = (JavaPackage)iter.next();
            assertEquals("Distance exceeded: " + p.getName(),
                    ideal, p.distance(), tolerance);
        }
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(DistanceTest.class);
    }
}
