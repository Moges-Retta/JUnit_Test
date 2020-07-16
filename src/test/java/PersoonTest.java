import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PersoonTest {
    private Persoon persoon;

    @BeforeEach
    void beforeEach() {
        persoon = new Persoon();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "Moges123", "***", "Moges***", " "})
    void bevatIllegalInputs(String string) {
        assertThatExceptionOfType(VoornaamException.class)
                .isThrownBy(() -> persoon.setVoornaam(string));
    }

    @Test
    @DisplayName("Leeg voornaam is niet geldig")
    void leegVoornaam() {
        assertThatNullPointerException()
                .isThrownBy(() -> persoon.setVoornaam(""));
    }

    @Test
    @DisplayName("null as voornaam is verkeerd")
    void nullVoornaam() {
        assertThatNullPointerException()
                .isThrownBy(() -> persoon.setVoornaam(null));
    }

    @Test
    @DisplayName("double voornaam is niet toegestaan")
    void doubleVoornaam() {
        persoon.setVoornaam("Moges");
        assertThatExceptionOfType(VoornaamException.class)
                .isThrownBy(() -> persoon.setVoornaam("Moges"));
    }

    @Test
    void toStringMoetHetStringTeruggeven() {
        persoon.setVoornaam("Moges");
        persoon.setVoornaam("Retta");
        assertThat(persoon).hasToString("Moges Retta");
    }
}
