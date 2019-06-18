package unq.tpi.desapp.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = Packages.BASE_PACKAGE)
public class LayeredArchitectureTest {

    @ArchTest
    public static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

            .layer("Webservices").definedBy(Packages.WEBSERVICES)
            .layer("Services").definedBy(Packages.SERVICES)
            .layer("Persistence").definedBy(Packages.PERSISTENCE)
            .layer("Runners").definedBy(Packages.RUNNERS)

            .whereLayer("Webservices").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Webservices", "Runners")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services");
}
