public class Equipo {
    //Atributos
    private String Deporte;
    private boolean Colectivo;
    private int[] Deportistas = new int[1];
    private int[] Medallas = new int[2];
    
    //Métodos
    public Equipo(String deporte, boolean colectivo, int[] deportistas, int[] medallas) {
        Deporte = deporte;
        Colectivo = colectivo;
        Deportistas = deportistas;
        Medallas = medallas;
    }

    public String getDeporte() {
        return Deporte;
    }

    public void setDeporte(String deporte) {
        Deporte = deporte;
    }

    public boolean isColectivo() {
        return Colectivo;
    }

    public void setColectivo(boolean colectivo) {
        Colectivo = colectivo;
    }

    public int[] getDeportistas() {
        return Deportistas;
    }

    public void setDeportistas(int[] deportistas) {
        Deportistas = deportistas;
    }

    public int[] getMedallas() {
        return Medallas;
    }

    public void setMedallas(int[] medallas) {
        Medallas = medallas;
    }

    public int TotalMedallasEq(){
        int result = 0;
        for (int i : this.Medallas) {
            result += i;
        }
        return result;
    }

    public int TotalDeportistasEq(){
        int result = 0;
        for(int i: this.Deportistas){
            result += i;
        }
        return result;
    }

    
}
