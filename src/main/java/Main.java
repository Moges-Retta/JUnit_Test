public class Main {
    public static void main(String[] args) {
        Persoon moges = new Persoon();
        try {
            moges.setVoornaam("Moges");
            moges.setVoornaam("Ashagrie");
            moges.setVoornaam("Retta");

            System.out.println(moges);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
