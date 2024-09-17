/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_pertemuan4;

/**
 *
 * @author DAGH
 */
public class LiburanException extends Exception {
    String liburan;

    LiburanException(String liburan) {
        this.liburan = liburan;
    }

    public String toString() {
        return ("Liburan = " + liburan);
    }
}
