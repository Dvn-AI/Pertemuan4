/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_pertemuan4;

/**
 *
 * @author DAGH
 */
public class TestLiburanException {
    public static void main(String[] args) {
        try {
            int tahun = 2024;
            int jumlahHariLibur = hitungHariLibur(tahun);
            System.out.println("Jumlah hari libur pada tahun " + tahun + " adalah " + jumlahHariLibur);
        } catch (LiburanException e) {
            System.out.println(e);
        }
    }

    public static int hitungHariLibur(int tahun) throws LiburanException {
        if (tahun < 2000 || tahun > 2030) {
            throw new LiburanException("Tahun tidak valid");
        }

        // Kode untuk menghitung hari libur
        int jumlahHariLibur = 10; // Misalnya, 10 hari libur dalam setahun
        return jumlahHariLibur;
    }
}
