package com.controller;

import com.model.Mahasiswa;
import com.view.Footer;
import com.view.Home;

public class MahasiswaController {

    private static Mahasiswa mahasiswa = new Mahasiswa("mahasiswa");

    private MahasiswaController() {
    }

    public static void display() {
        Home.display();
    }

    public static void listData() {
        try {
            System.out.println("            DATA MAHASISWA                ");
            System.out.println("+------------------------------------+");
            mahasiswa.getAll();
            System.out.println("+------------------------------------+");
            Footer.display();
        } catch (Exception e) {
            e.printStackTrace();
        }

        display();
    }

    public static void createData() {
        try {
            if (Boolean.TRUE.equals(mahasiswa.create())) {
                System.out.println("Data berhasil disimpan!!");
            }

            Footer.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateData() {
        mahasiswa.getAll();
        try {

            if (Boolean.TRUE.equals(mahasiswa.update())) {
                System.out.println("Data berhasil diubah!!");
            }

            Footer.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteData() {
        mahasiswa.getAll();
        try {
            if (Boolean.TRUE.equals(mahasiswa.delete())) {
                System.out.println("Data berhasil dihapus!!");
            }

            Footer.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
