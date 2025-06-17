public class Objeto {
    private String nombre;
    private int valor;
    private int peso;

    public Objeto(String nombre , int valor, int peso){
        this.nombre = nombre;
        this.valor = valor;
        this.peso = peso;

    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public int getPeso() {
        return peso;
    }
}
