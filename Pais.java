
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Pais{
    //Atributos
    private String Nombre;
    private int[] medallas = new int[4];
    private List<Equipo> Equipos = new ArrayList<Equipo>();
    
    //Métodos
    public Pais(String nombre, int[] medallas) {
        Nombre = nombre;
        this.medallas = medallas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int[] getMedallas() {
        return medallas;
    }

    public void setMedallas(int[] medallas) {
        this.medallas = medallas;
    }
    public List<Equipo> getEquipos() {
        return Equipos;
    }

    public void setEquipos(Equipo equipo) {
        this.Equipos.add(equipo);
    }
    

    public boolean AgregarEquipo(String nombre, boolean colectivo, int hombres, int mujeres, int oro, int plata, int bronce){
        if(this.Equipos.size()<=11){ // comprueba que haya menos de 12 equipos
            int[] deportistas = {mujeres, hombres};
            int[] medallas = {oro, plata, bronce};
            Equipo newEquipo = new Equipo(nombre, colectivo, deportistas, medallas);
            this.Equipos.add(newEquipo);
            return true; // true si se pudo agregar el equipo
        }else{
            return false; // false si no se pudo agregar porque el país ya tiene 12 equipos.
        }

    }
    
    public int TotalDeportistas(){ // función para mostrar la cantidad de deportistas del país
        int result = 0; // variable que almacenará la cantidad de deportistas
        for (Equipo i : this.Equipos) {
            result += i.TotalDeportistasEq();
        }
        return result;
    }

    public int TotalMedallas(){ // función para mostrar la cantidad de medallas totales que el país obtuvo
        int result = 0; // variable que guardará la cantidad de medallas
        for (Equipo i : this.Equipos) {
            result += i.TotalMedallasEq();
        }
        return result;
    }

    public boolean BuscarDeporte(String deporte){
        List<String> lista = new ArrayList<String>();
        for (Equipo i : this.Equipos) {
            lista.add(i.getDeporte());
        }
        boolean a = false;
        for (String ii : lista) {
            if(deporte.equalsIgnoreCase(ii)){
                a = true;
            }else{
                a = false;
            }
        }
        return a;
    }

    public int TotalMedallasPorEq(String deporte){ //función para mostrar la cantidad de medallas que un equipo ha obtenido
        int a = 0;
        for (Equipo i : this.Equipos) {
            if(deporte.equalsIgnoreCase(i.getDeporte())){
                a = i.TotalMedallasEq();
            }else{
                a= -1;
            }
        }
        return a;
    }

    public String MasMedallasEq(){
        int a = 0;
        String nombreEquipo = "";
        for (Equipo i : this.Equipos) {
           if(i.TotalMedallasEq() >= a){
            a = i.TotalMedallasEq();
            nombreEquipo = i.getDeporte();
           }else{
            a = a;
           }
        }
        return "El equipo con más medallas es el equipo de "+ nombreEquipo + " con un total de "+a + " medallas";
    }

    public int PromedioAnteriores(){
        int a = 0;
        for (int i: this.medallas) {
            a+= i;
        }
        int promedio = a/medallas.length;
        return promedio;
    }

    public int CompararAnteriores(){
        if(this.PromedioAnteriores() < this.TotalMedallas()){
            return 1;
        }else{
            if(this.PromedioAnteriores()> this.TotalMedallas()){
                return -1;
            }else{
                return 0;
            }
        }
    }


    
}