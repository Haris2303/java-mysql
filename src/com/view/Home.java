package com.view;

import javax.xml.crypto.Data;

import com.config.Config;
import com.controller.MahasiswaController;
import com.core.Database;

public class Home {

    private Home() {
    }

    public static void display() {
        Config.clearScreen();

        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Tampilkan Data Siswa");
        System.out.println("2. Tambah Data Siswa");
        System.out.println("3. Ubah Data Siswa");
        System.out.println("4. Hapus Data Siswa");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN : ");

        try {
            int pilihan = Integer.parseInt(Config.input.readLine()); // mengambil input user (pilihan menu)

            switch (pilihan) {
                case 0: // jika pilihan 0
                    System.exit(0); // program dihentikan
                    Database.disconnect();
                    break;
                case 1: // jika pilihan 1
                    MahasiswaController.listData(); // memanggil method tambahDataSiswa
                    break;
                case 2: // jika pilihan 2
                    MahasiswaController.createData();
                    break;
                case 3: // jika pilihan 3
                    MahasiswaController.updateData();
                    break;
                case 4: // jika pilihan 4
                    MahasiswaController.deleteData();
                    break;
                default: // jika pilihan selain diatas
                    System.out.println("Pilihan tidak ada !");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
