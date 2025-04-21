package Java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBController {
    private static final String URL = "jdbc:mysql://localhost:3306/eclipse_db";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // o "root", según configuración de XAMPP

    private Connection conexion;

    public DBController() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }

    // CREATE
    public void insertarUsuario(String nombre, String email) {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    // READ
    public List<String> obtenerUsuarios() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                lista.add("ID: " + id + ", Nombre: " + nombre + ", Email: " + email);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
        }

        return lista;
    }

    // UPDATE
    public void actualizarUsuario(int id, String nuevoNombre, String nuevoEmail) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevoEmail);
            stmt.setInt(3, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    // CERRAR CONEXIÓN
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}