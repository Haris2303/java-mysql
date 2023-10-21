package com.model;

import java.sql.PreparedStatement;

import com.config.Config;
import com.core.Database;

public class Mahasiswa {

    private Database db;

    public Mahasiswa() {
        db = new Database();
    }

    public Boolean getAll() {
        String sql = "SELECT nim, nama, email FROM mahasiswa";
        Boolean next = false;

        try {
            PreparedStatement statement = db.connect().prepareStatement(sql);

            // jalankan query SQL
            Config.resultSet = statement.executeQuery(sql);

            next = Config.resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return next;

    }

    public Boolean create() {
        Boolean isCreate = false;
        Config.clearScreen();
        try {
            // ambil input dari user
            System.out.print("NIM: ");
            String nim = Config.input.readLine().trim();

            System.out.print("Nama Mahasiswa: ");
            String nama = Config.input.readLine().trim();

            System.out.print("Email: ");
            String email = Config.input.readLine().trim();

            String sql = "INSERT INTO mahasiswa (id, nim, nama, email) VALUE(NULL, '%s', '%s','%s')";
            sql = String.format(sql, nim, nama, email); // memformat jadi string

            try (PreparedStatement statement = db.connect().prepareStatement(sql)) {
                // menjalankan query SQL
                statement.execute(sql);

                isCreate = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isCreate;

    }

    public Boolean update() {
        Boolean isUpdate = false;

        try {
            System.out.print("NIM yang mau diedit: ");
            String nim = Config.input.readLine().trim();

            System.out.print("NIM Baru: ");
            String nimbaru = Config.input.readLine().trim();

            System.out.print("Nama Mahasiswa: ");
            String nama = Config.input.readLine().trim();

            System.out.print("Email: ");
            String email = Config.input.readLine().trim();

            String sql = "UPDATE mahasiswa SET nim= '%s', nama='%s', email='%s' WHERE nim='%s'";
            sql = String.format(sql, nimbaru, nama, email, nim); // memformat jadi string

            PreparedStatement statement = db.connect().prepareStatement(sql);

            // menjalankan query SQL
            statement.execute(sql);

            isUpdate = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUpdate;

    }

    public Boolean delete() {
        Boolean isDelete = false;

        try {
            // ambil input dari user
            System.out.print("NIS yang mau dihapus: ");
            String nim = Config.input.readLine().trim();

            // buat query SQL
            String sql = String.format("DELETE FROM mahasiswa WHERE nim=%s", nim);

            PreparedStatement statement = db.connect().prepareStatement(sql);

            // jalankan query SQL
            statement.execute(sql);

            isDelete = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isDelete;
    }

}
