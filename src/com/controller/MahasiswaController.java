package com.controller;

import com.config.Config;
import com.model.Mahasiswa;
import com.view.Footer;
import com.view.Home;

public class MahasiswaController {

    private static Mahasiswa mahasiswa = new Mahasiswa();

    private MahasiswaController() {
    }

    public static void display() {
        Home.display();
    }

    public static void listData() {
        try {
            System.out.println("            DATA MAHASISWA                ");
            System.out.println("+------------------------------------+");
            getAllData();
            System.out.println("+------------------------------------+");
            Footer.display();
        } catch (Exception e) {
            e.printStackTrace();
        }

        display();
    }

    public static void getAllData() {
        try {
            Config.clearScreen();

            if (Boolean.FALSE.equals(mahasiswa.getAll())) { // jika hasil query kosong / tidak ada data
                System.out.println(" Belum ada data!");
            } else {
                do { // jika tidak kosong, lakukan looping
                    String nim = Config.resultSet.getString("nim");
                    String nama = Config.resultSet.getString("nama");
                    String email = Config.resultSet.getString("email");
                    System.out.println(
                            String.format(" %s (%s) - %s", nama, nim, email));
                } while (Config.resultSet.next());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        getAllData();
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
        getAllData();
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
