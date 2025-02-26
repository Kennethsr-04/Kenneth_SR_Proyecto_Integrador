import java.util.Scanner;

class Equipo {
    private String nombre;
    private int vida;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.vida = 100; // Vida inicial
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void recibirDanio(int danio) {
        vida -= danio;
        if (vida < 0) {
            vida = 0;
        }
    }

    public void mostrarInfo() {
        System.out.println(nombre + " - Vida: " + vida);
    }
}

public class Menu {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int operacion;
        Equipo[] equipos = new Equipo[5];
        
        System.out.println("\n🏴‍☠️ Creación de Equipos 🏴‍☠️");
        for (int i = 0; i < equipos.length; i++) {
            System.out.print("👉 Ingresa el nombre del equipo " + (i + 1) + ": ");
            String nombre = teclado.nextLine();
            equipos[i] = new Equipo(nombre);
        }
        
        do {
            System.out.println("\n🏴‍☠️  Bienvenido a la Isla del Tesoro  🏴‍☠️");
            System.out.println("--------------------------------------");
            System.out.println("1️⃣  Jugar");
            System.out.println("2️⃣  Reglas del juego");
            System.out.println("3️⃣  Información");
            System.out.println("4️⃣  Ver Equipos");
            System.out.println("0️⃣  Salir");
            System.out.println("--------------------------------------");
            System.out.print("👉 Elige una opción: ");

            while (!teclado.hasNextInt()) {
                System.out.println("⚠️ Por favor, introduce un número válido.");
                teclado.next();
            }
            operacion = teclado.nextInt();
            teclado.nextLine();

            switch (operacion) {
                case 1:
                    System.out.println("\n🎮 Comienza el juego...");
                    System.out.println("¡Prepárate para una gran aventura en la Isla del Tesoro!");
                    System.out.println("Presiona Enter para continuar...");
                    teclado.nextLine();
                    break;
                case 2:
                    System.out.println("\n📜 Reglas del juego:");
                    System.out.println("--------------------------------------");
                    System.out.println("- Puede haber entre 1 y 5 jugadores.");
                    System.out.println("- Cada persona intentará obtener la mayor cantidad de puntos.");
                    System.out.println("- El juego tendrá un número definido de rondas.");
                    System.out.println("\nAcciones disponibles:");
                    System.out.println("  * Cavar: buscar tesoros.");
                    System.out.println("  * Poner trampas: para evitar que otros jugadores roben.");
                    System.out.println("  * Robar a otros jugadores: intenta conseguir más tesoros.");
                    System.out.println("--------------------------------------");
                    System.out.println("Presiona Enter para continuar...");
                    teclado.nextLine();
                    break;
                case 3:
                    System.out.println("\nℹ️ Información:");
                    System.out.println("--------------------------------------");
                    System.out.println("Autores: Kenneth y María");
                    System.out.println("Versión: 1.0");
                    System.out.println("Contacto: mariaperezgoti08@gmail.com");
                    System.out.println("--------------------------------------");
                    System.out.println("Presiona Enter para continuar...");
                    teclado.nextLine();
                    break;
                case 4:
                    System.out.println("\n📋 Equipos en el juego:");
                    System.out.println("--------------------------------------");
                    for (Equipo equipo : equipos) {
                        equipo.mostrarInfo();
                    }
                    System.out.println("--------------------------------------");
                    System.out.println("Presiona Enter para continuar...");
                    teclado.nextLine();
                    break;
                case 0:
                    System.out.print("\n¿Estás seguro de que quieres salir? (s/n): ");
                    String confirmacion = teclado.nextLine().trim().toLowerCase();
                    if (confirmacion.equals("s")) {
                        System.out.println("\n👋 ¡Gracias por jugar! Hasta la próxima, pirata. 🏴‍☠️");
                    } else {
                        operacion = -1; 
                    }
                    break;
                default:
                    System.out.println("⚠️ Opción no válida. Inténtalo de nuevo.");
                    System.out.println("Presiona Enter para continuar...");
                    teclado.nextLine();
            }
        } while (operacion != 0);

        teclado.close();
    }
}
