/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pbo_pertemuan4;

/**
 *
 * @author DAGH
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Intelligent System
 */
public class PBO_Pertemuan4{

    /**
     * @param args the command line arguments
     */
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/PBO_Pertemuan4";
    String user = "postgres";
    String password = "4736251";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public void tambah() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false); // Nonaktifkan otomatis commit
            int k = 0;

            String sql = "INSERT INTO tabel_siswa VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);

            boolean selesai = false;
            while (!selesai) {
                System.out.println("MASUKKAN DATA SISWA ");
                System.out.print("ID Siswa : ");
                String id = input.readLine().trim();
                System.out.print("Nama : ");
                String nama = input.readLine().trim();
                System.out.print("alamat : ");
                String alamat = input.readLine().trim();
                
                pstmt.setInt(1, Integer.parseInt(id));
                pstmt.setString(2, nama);
                pstmt.setString(3, alamat);
                int n = pstmt.executeUpdate();
                k = k + n;

                System.out.print("Apakah Anda ingin memasukkan data siswa lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true; // Ubah ke true agar loop berhenti jika tidak ingin memasukkan data lagi
                }
            }

            conn.commit(); // Commit transaksi setelah sejumlah operasi-insert berhasil
            pstmt.close();
            conn.close();
            System.out.println("Sukses dalam satu transaksi.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi insert dalam loop.");
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // Batalkan transaksi jika terjadi kesalahan
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
         } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void tampil() {
        try {
            // TODO code application logi
            Class.forName(driver);
            String sql = "SELECT * FROM tabel_siswa";
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {
               ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            System.out.println(rs.getObject(1) + " " + rs.getObject(2) + " " + rs.getObject(3));
        }
                conn.close();
            }

            stmt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PBO_Pertemuan4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PBO_Pertemuan4.class.getName()).log(Level.SEVERE, null, ex);
          } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    

    public void hapus() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);

            String sql = "DELETE FROM tabel_siswa WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            boolean selesai = false;
            int k = 0;

            while (!selesai) {
                System.out.print("Masukkan id siswa yang akan dihapus: ");
                String dogtagToDelete = input.readLine().trim();
                int idToDelete = Integer.parseInt(dogtagToDelete); // Convert to integer

                // Delete the record from the database
                pstmt.setInt(1, idToDelete); // Use setInt() instead of setString()
                int n = pstmt.executeUpdate();
                k = k + n;

                System.out.print("Apakah Anda ingin memasukkan data siswa lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true; // Ubah ke true agar loop berhenti jika tidak ingin memasukkan data lagi
                }
            }

            conn.commit(); // Commit transaksi setelah sejumlah operasi-insert berhasil
            pstmt.close();
            conn.close();
            System.out.println(k + " data siswa berhasil dihapus.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi insert dalam loop.");
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // Batalkan transaksi jika terjadi kesalahan
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }  } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        
    

    public void update() {
        try {
            Class.forName(driver);
            String sql = "UPDATE tabel_siswa SET nama = ?, alamat = ? WHERE id = ?";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            int k = 0;

            boolean selesai = false;
            while (!selesai) {
                System.out.print("Masukkan ID siswa yang akan diupdate: ");
                String id = input.readLine().trim();
                System.out.print("Nama siswa baru: ");
                String namaSiswaBaru = input.readLine().trim();
                System.out.print("Alamat baru: ");
                String alamatBaru = input.readLine().trim();

                try {
                    pstmt.setString(1, namaSiswaBaru);
                    pstmt.setString(2, alamatBaru); 
                    pstmt.setInt(3, Integer.parseInt(id));
                } catch (NumberFormatException e) {
                    System.out.println("Format ID atau alamat salah. Silakan masukkan data yang valid.");
                    continue; // Lanjut ke iterasi berikutnya jika ada kesalahan format angka
                }

                int n = pstmt.executeUpdate();
                k = k + n;

                System.out.print("Apakah Anda ingin meng-update data siswa lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true;
                }
            }
            conn.commit(); // Commit transaksi setelah semua operasi berhasil
            System.out.println(k + " data siswa berhasil diupdate.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi update.");
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // Batalkan transaksi jika terjadi kesalahan
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
        }  finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void menu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Input Data");
        System.out.println("2. Tampil Data");
        System.out.println("3. Hapus Data");
        System.out.println("4. Update Data");
        System.out.println("0. keluar");
        System.out.print("PILIHAN> ");
        
           try {
            int pilihan = Integer.parseInt(input.readLine());
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    tambah();
                    menu();
                    break;
                case 2:
                    tampil();
                     menu();
                    break;
                case 3:
                    hapus();
                     menu();
                    break;
                case 4:
                    update();
                     menu();
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } catch (IOException ex) {
            Logger.getLogger(PBO_Pertemuan4.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    public static void main(String[] args) {
        new PBO_Pertemuan4().menu();
        Scanner scanner = new Scanner(System.in);
    }

}