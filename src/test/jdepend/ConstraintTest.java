package test.jdepend;

import java.io.*;

import jdepend.framework.DependencyConstraint;
import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import junit.framework.*;

public class ConstraintTest extends TestCase {

    private JDepend jdepend;

    public ConstraintTest(String name) {
        super(name);
    }

    protected void setUp() throws IOException {

        jdepend = new JDepend();

        jdepend.addDirectory("..\\Weather-Outlook\\src\\openweathermap");
        jdepend.addDirectory("..\\Weather-Outlook\\src\\application");
    }

    /**
     * Tests that the package dependency constraint
     * is met for the analyzed packages.
     */
    public void testMatch() {

        DependencyConstraint constraint = new DependencyConstraint();

        JavaPackage api = constraint.addPackage("openweathermap");
        JavaPackage app = constraint.addPackage("application");

        app.dependsUpon(api);

        jdepend.analyze();

        assertEquals("Dependency mismatch",
                true, jdepend.dependencyMatch(constraint));
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(ConstraintTest.class);
    }
}
