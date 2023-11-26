package com.chanel.fsh.peps.nextgen.cms.test.archi;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class PepsCMSArchiTest {

    @Test
    public void some_architecture_rule() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.chanel.fsh.peps.nextgen");

        layeredArchitecture()
                .consideringAllDependencies()
                .layer("REST").definedBy("..rest..")
                .layer("DOMAIN").definedBy("..domain..")
                .layer("DB").definedBy("..db..")
                .layer("CONSUMER").definedBy("..consumer..")

                .whereLayer("REST").mayNotBeAccessedByAnyLayer()
                .whereLayer("DB").mayNotBeAccessedByAnyLayer()
                .whereLayer("CONSUMER").mayNotBeAccessedByAnyLayer()
                .whereLayer("DOMAIN").mayOnlyBeAccessedByLayers("REST", "DB", "CONSUMER")
                .check(importedClasses);
    }
}
