import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Artur on 04/06/18.
 * Simple test for use JUnit 5 and new features
 */
public class EnunTest {

    enum Pet {
        CAT,
        DOG,
        WOLF;
    }

    @DisplayName("Should pass only the specified enum value as a method parameter")
    @ParameterizedTest(name = "{index} => pet=''{0}''")
    @EnumSource(value = Pet.class, names = {"CAT"})
    void shouldPassNonNullEnumValueAsMethodParameter(Pet pet) {
        assertNotNull(pet);
    }
}
