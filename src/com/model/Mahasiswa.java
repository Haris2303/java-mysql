package com.model;

import java.sql.PreparedStatement;

import com.config.Config;
import com.core.BaseModel;

public class Mahasiswa extends BaseModel {

    public Mahasiswa(String table) {
        super(table);
    }

    public void getAll() {
        try {
            Config.clearScreen();

            if (Boolean.FALSE.equals(select("*"))) { // jika hasil query kosong / tidak ada data
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

    public Boolean create() {
        String sql = "";

        try {
            // ambil input dari user
            System.out.print("NIM: ");
            String nim = Config.input.readLine().trim();

            System.out.print("Nama Mahasiswa: ");
            String nama = Config.input.readLine().trim();

            System.out.print("Email: ");
            String email = Config.input.readLine().trim();

            sql = "INSERT INTO mahasiswa (id, nim, nama, email) VALUE(NULL, '%s', '%s','%s')";
            sql = String.format(sql, nim, nama, email); // memformat jadi string

        } catch (Exception e) {
            e.printStackTrace();
        }

        return create(sql);

    }

    public Boolean update() {
        String sql = "";

        try {
            System.out.print("NIM yang mau diedit: ");
            String nim = Config.input.readLine().trim();

            System.out.print("NIM Baru: ");
            String nimbaru = Config.input.readLine().trim();

            System.out.print("Nama Mahasiswa: ");
            String nama = Config.input.readLine().trim();

            System.out.print("Email: ");
            String email = Config.input.readLine().trim();

            sql = "UPDATE mahasiswa SET nim= '%s', nama='%s', email='%s' WHERE nim='%s'";
            sql = String.format(sql, nimbaru, nama, email, nim); // memformat jadi string

        } catch (Exception e) {
            e.printStackTrace();
        }

        return update(sql);

    }

    public Boolean delete() {
        String sql = "";

        try {
            // ambil input dari user
            System.out.print("NIS yang mau dihapus: ");
            String nim = Config.input.readLine().trim();

            // buat query SQL
            sql = String.format("DELETE FROM mahasiswa WHERE nim=%s", nim);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return delete(sql);
    }

}
