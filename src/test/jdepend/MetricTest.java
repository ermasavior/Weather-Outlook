package test.jdepend;

import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import jdepend.framework.PackageFilter;
import junit.framework.TestCase;

import java.io.IOException;
import java.text.NumberFormat;


public class MetricTest extends TestCase {

    private JDepend jdepend;
    private static NumberFormat formatter;

    static {
        formatter = NumberFormat.getInstance();
        formatter.setMaximumFractionDigits(2);
    }

    public MetricTest(String name) {
        super(name);
    }

    protected void setUp() {
        try {
            super.setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PackageFilter filter = new PackageFilter();
        filter.addPackage("application");
        filter.addPackage("openweathermap");

        jdepend = new JDepend(filter);
        jdepend.analyzeInnerClasses(false);
    }

    protected void tearDown() {
        try {
            super.tearDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testAnalyzeClassFiles() throws IOException {
        jdepend.addDirectory("..\\Weather-Outlook\\src");
        assertAnalyzePackages();
    }

    private void assertAnalyzePackages() {

        assertEquals(0, jdepend.countClasses());

        PackageFilter filter = jdepend.getFilter();
        filter.addPackage("application");
        filter.addPackage("openweathermap");

        jdepend.analyze();

        assertAPIPackage();
        assertAppPackage();
    }

    private void assertAPIPackage() {

        JavaPackage p = jdepend.getPackage("openweathermap");
        assertNotNull(p);

        assertEquals(25, p.getConcreteClassCount());
        assertEquals(4, p.getAbstractClassCount());
        assertEquals(3, p.afferentCoupling());
        assertEquals(0, p.efferentCoupling());
        assertEquals(format(0.14f), format(p.abstractness()));
        assertEquals(format(0.0f), format(p.instability()));
        assertEquals(format(0.86f), format(p.distance()));
        assertEquals(1, p.getVolatility());
    }

    private void assertAppPackage() {

        JavaPackage p = jdepend.getPackage("application");
        assertNotNull(p);

        assertEquals(25, p.getConcreteClassCount());
        assertEquals(4, p.getAbstractClassCount());
        assertEquals(3, p.afferentCoupling());
        assertEquals(0, p.efferentCoupling());
        assertEquals(format(0.14f), format(p.abstractness()));
        assertEquals(format(0.0f), format(p.instability()));
        assertEquals(format(0.86f), format(p.distance()));
        assertEquals(1, p.getVolatility());
    }

    public void testConfiguredVolatility() throws IOException {

        jdepend.addDirectory("..\\Weather-Outlook\\src");

        JavaPackage pkg = new JavaPackage("jdepend.swingui");
        pkg.setVolatility(0);

        jdepend.addPackage(pkg);

        jdepend.analyze();

        JavaPackage analyzedPkg = jdepend.getPackage(pkg.getName());
        assertEquals(0, analyzedPkg.getVolatility());
        assertEquals(format(0.0f), format(analyzedPkg.distance()));
        assertEquals(0, analyzedPkg.getConcreteClassCount());
    }

    private String format(float f) {
        return formatter.format(f);
    }
}