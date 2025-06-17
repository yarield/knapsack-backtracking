import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Main {
    public static int peso_mochila_max = 10;
    public static int mejorValor = 0;
    public static List<String> mejorCombinacion = new ArrayList<>();
    public static List<Objeto> ListaObjetos = new ArrayList<>();


    public static void crearPiedra(String nombre, int valor,int peso){
        Objeto o1 = new Objeto(nombre,valor,peso);
        ListaObjetos.add(o1);
    }

    public static  void insercionPiedras(){
        crearPiedra("Oro",10,5);
        crearPiedra("Plata",40,4);
        crearPiedra("Platino",30,6);
        crearPiedra("Diamante",50,3);
    }



    public static void probarCombinaciones(List<String> combinacionActual,int pesoActual, int valorActual){
        if (pesoActual > peso_mochila_max) {
            return;
        }

        if (valorActual> mejorValor){
            mejorValor = valorActual;
            mejorCombinacion = new ArrayList<>(combinacionActual);
        }
        for (Objeto o : ListaObjetos) {
            combinacionActual.add(o.getNombre()); // agregar nombre actual
            probarCombinaciones(combinacionActual, pesoActual + o.getPeso(), valorActual + o.getValor());
            combinacionActual.remove(combinacionActual.size() - 1); // backtrack
        }


    }



    public static void main(String[] args) {

        insercionPiedras();

        probarCombinaciones(new ArrayList<>(), 0, 0);
        System.out.println("Mejor combionacion de piedras:");
        for (String nombre : mejorCombinacion) {
            System.out.print(nombre + " ");
        }
        System.out.println("\nValor total: " + mejorValor);



    }
}