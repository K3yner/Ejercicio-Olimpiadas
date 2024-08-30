
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner escucha = new Scanner(System.in);
        System.out.println("Bienvenido a este sofware que le permite llevar un conteo de los equipos de las olimpiadas y sus medallas. Primero ingrese el nombre del país:  \n");
        String nombrePais = escucha.nextLine();
        System.out.println("¿Cuántas medallas obtuvo en las olimpiadas de Tokyo 2020?\n");
        int tokyo = escucha.nextInt();
        escucha.nextLine();
        System.out.println("¿Cuántas medallas obtuvo en las olimpiadas de Rio 2016?\n");
        int rio = escucha.nextInt();
        escucha.nextLine();
        System.out.println("¿Cuántas medallas obtuvo en las olimpiadas de Londres 2012\n?");
        int londres = escucha.nextInt();
        escucha.nextLine();
        System.out.println("¿Cuántas medallas obtuvo en las olimpiadas de Beijing 2008?\n");
        int beijing = escucha.nextInt();
        escucha.nextLine();
        System.out.println("¿Cuántas medallas obtuvo en las olimpiadas de Atenas 2004?\n");
        int atenas = escucha.nextInt();
        escucha.nextLine();
        int[] medallasAnteriores = {tokyo, rio, londres, beijing, atenas};
        Pais pais = new Pais(nombrePais, medallasAnteriores);
        boolean n = true;
        while (n) { 
            System.out.println(menu());
            int opcion = escucha.nextInt();
            escucha.nextLine();
            switch (opcion) {
                case 1: // Ingresar deporte
                    System.out.println("Ingrese el nombre del deporte \n");
                    String deporte = escucha.nextLine();
                    boolean n2 = true;
                    boolean colectivo = false;
                    while (n2) { 
                        System.out.println("¿El deporte es colectivo? (ingrese solo el número de la opción)\n1. Sí \n2. No");
                        int op = escucha.nextInt();
                        switch (op) {
                            case 1:
                                colectivo  = true;
                                n2 = false;
                                break;
                            case 2:
                                colectivo = false;
                                n2 = false;
                                break;
                            default:
                                System.out.println("La opción escogida no corresponde a ninguna opción dada.");
                        }
                    }
                    System.err.println("¿Cuántas mujeres participan en el equipo? \n");
                    int mujeres = escucha.nextInt();
                    escucha.nextLine();
                    System.err.println("¿Cuántos hombres participan en el equipo? \n");
                    int hombres = escucha.nextInt();
                    escucha.nextLine();
                    System.err.println("¿Cuántas medallas de oro obtuvo el equipo?");
                    int oro = escucha.nextInt();
                    escucha.nextLine();
                    System.err.println("¿Cuántas medallas de plata obtuvo el equipo?");
                    int plata = escucha.nextInt();
                    escucha.nextLine();
                    System.err.println("¿Cuántas medallas de bronce obtuvo el equipo?");
                    int bronce = escucha.nextInt();
                    escucha.nextLine();
                    pais.AgregarEquipo(deporte, colectivo, hombres, mujeres, oro, plata, bronce);
                    break;
                case 2: // Mostrar la cantidad de medallas del país.
                    System.out.println("EL país obtuvo un total de " +pais.TotalMedallas()+ " medallas");
                    break;
                case 3: // Mostrar la cantidad de medallas de un equipo
                    System.out.println("¿De que equipo quiere ver la cantidad de medallas? (ingrese el nombre del deporte)");
                    String nombreDeporte = escucha.nextLine();
                    int cantidadMedallas = pais.TotalMedallasPorEq(nombreDeporte);
                    if(cantidadMedallas>= 0){
                        System.out.println("El deporte "+ nombreDeporte +" obtuvo "+ cantidadMedallas+" medallas.");
                    }else{
                        System.out.println("El deporte que ha ingresado no está registrado");
                    }
                    break;
                case 4: // Mostrar todos los equipos.
                    String a = "";
                    for (Equipo i : pais.getEquipos()) {
                        a = a+ i.getDeporte() + ": cantidad de deportistas = " + i.TotalDeportistasEq() + ", total de medallas= "+ i.TotalMedallasEq()+ "\n";
                    }
                    System.out.println(a);
                    break;
                case 5: // Mostrar el equipo con más medallas
                    System.out.println(pais.MasMedallasEq());
                    break;
                case 6: // Comparar con años anteriores.
                    System.out.println("Este año se obtuvo "+ pais.TotalMedallas()+" medallas, el promedio de medallas de los últimos 5 juegos olímpicos fue de "+ pais.PromedioAnteriores());
                    if(pais.CompararAnteriores()==1){
                        System.out.println("Por tanto, la cantidad de medallas obtenidas en las olímpiadas de París 2024 fue mayor que el promedio de últimos 5 juegos");
                    }else{
                        if(pais.CompararAnteriores() == -1){
                            System.out.println("Por tanto, la cantidad de medallas obtenidas en las olímpiadas de París 2024 fue menor que el promedio de últimos 5 juegos");
                        }else{
                            System.out.println("Por tanto, la cantidad de medallas obtenidas en las olímpiadas de París 2024 fue iguala que el promedio de últimos 5 juegos");
                        }
                    }
                    break;
                case 7: // total deportistas
                    System.out.println("El país tuvo "+ pais.TotalDeportistas() + " deportistas");
                    break;
                default:
                    throw new AssertionError();
            }

        }

    }

    public static String menu(){
        return "¿Qué desea hacer? (ingrese el número de la opción): \n1. Ingresar deporte \n2. Mostrar la cantidad de medallas que el país obtuvo \n3. Mostrar la cantidad de medallas que obtuvo un equipo \n4. Mostrar todos los equipos \n5. Mostrar el equipo con más medallas \n6. Comparar la cantidad de medallas con años anteriores \n7. Mostrar total deportistas \n";
    }
}