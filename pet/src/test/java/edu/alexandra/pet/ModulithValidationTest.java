package edu.alexandra.pet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
public class ModulithValidationTest {

    @Test
    void verifyModularStructure() {
        ApplicationModules modules = ApplicationModules.of(PetApplication.class);
        modules.verify();
    }

}
