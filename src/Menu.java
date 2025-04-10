import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Equipo> equipos = new ArrayList<>();

        System.out.print("¿Cuántos jugadores quieres crear? ");
        int cantidadEquipos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidadEquipos; i++) {
            System.out.print("Nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            equipos.add(new Equipo(nombre));
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ver jugadores");
            System.out.println("2. Atacar");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    for (Equipo e : equipos) {
                        System.out.println("Equipo: " + e.getNombre() + " | Vida: " + e.getVida() + " | Tesoros: " + e.getTesoros());
                    }
                    break;

                case 2:
                    if (equipos.size() < 2) {
                        System.out.println("Debe haber al menos 2 jugadores para atacar.");
                        break;
                    }

                    System.out.println("Elige el jugador atacante:");
                    for (int i = 0; i < equipos.size(); i++) {
                        System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
                    }
                    int atacanteIndex = scanner.nextInt() - 1;

                    System.out.println("Elige el jugador objetivo:");
                    for (int i = 0; i < equipos.size(); i++) {
                        if (i != atacanteIndex) {
                            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
                        }
                    }
                    int objetivoIndex = scanner.nextInt() - 1;

                    if (atacanteIndex == objetivoIndex || atacanteIndex < 0 || objetivoIndex < 0 ||
                            atacanteIndex >= equipos.size() || objetivoIndex >= equipos.size()) {
                        System.out.println("Selección inválida.");
                        break;
                    }

                    Equipo atacante = equipos.get(atacanteIndex);
                    Equipo objetivo = equipos.get(objetivoIndex);

                    atacante.atacar(objetivo);

                    if (objetivo.getVida() == 0) {
                        System.out.println("¡" + objetivo.getNombre() + " ha sido derrotado!");
                        atacante.ganarTesoro();
                        equipos.remove(objetivo);
                    }
                    
                    if (equipos.size() == 1) {
                        System.out.println("\n🏆 ¡" + equipos.get(0).getNombre() + " ha ganado la partida con " +
                            equipos.get(0).getTesoros() + " tesoro(s)! 🏆");
                        salir = true;
                    }


                    break;

                case 3:
                    salir = true;
                    System.out.println("¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
