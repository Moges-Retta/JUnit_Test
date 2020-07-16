import java.util.ArrayList;

public class Persoon {
    private final ArrayList<String> voornamen = new ArrayList<>();

    public Persoon() {
    }

    public void setVoornaam(String voornaam) {
        if (voornaam.equals(" ") || voornaam.matches(".*\\W+.*")
                || voornaam.matches(".*\\d.*") || voornamen.contains(voornaam)) {
            throw new VoornaamException();
        } else if (voornaam.isEmpty()) {
            throw new NullPointerException();
        } else {
            voornamen.add(voornaam);
        }
    }

    @Override
    public String toString() {
        StringBuilder voornaam = new StringBuilder();
        var teller = 0;
        for (var item : voornamen) {
            teller++;
            voornaam.append(item);
            if (teller != voornamen.size()) {
                voornaam.append(" ");
            }
        }
        return voornaam.toString();
    }
}
