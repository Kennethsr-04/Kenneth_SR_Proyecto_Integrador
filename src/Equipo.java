public class Equipo {
	
    private String nombre;
    private int vida;
    private int tesoros;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.vida = 100;
        this.tesoros = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getTesoros() {
        return tesoros;
    }

    public void reducirVida(int cantidad) {
        vida -= cantidad;
        if (vida < 0) {
            vida = 0;
        }
    }

    public void aumentarVida(int cantidad) {
        vida += cantidad;
    }

    public void ganarTesoro() {
        tesoros++;
    }

    public void atacar(Equipo objetivo) {
        int dano = (int)(Math.random() * 20 + 1); 
        objetivo.reducirVida(dano);
        this.aumentarVida(dano); 
        System.out.println(this.nombre + " ataca a " + objetivo.getNombre() +
            " y le quita " + dano + " de vida. Ahora tiene " + this.vida + " de vida.");
    }
}
