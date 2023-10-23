package com.core;

import java.sql.PreparedStatement;

import com.config.Config;

public class BaseModel {

    protected Database db;
    protected String table;

    protected BaseModel(String table) {
        this.db = new Database();
        this.table = table;
    }

    // select()
    public Boolean select(String field) {
        String sql = "SELECT " + field + "FROM " + this.table;
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

    // create()
    public Boolean create(String sql) {
        Boolean isCreate = false;
        try (PreparedStatement statement = db.connect().prepareStatement(sql)) {
            // menjalankan query SQL
            statement.execute(sql);

            isCreate = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isCreate;
    }

    // update()
    public Boolean update(String sql) {
        Boolean isUpdate = false;
        try (PreparedStatement statement = db.connect().prepareStatement(sql)) {
            // menjalankan query SQL
            statement.execute(sql);

            isUpdate = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUpdate;
    }

    // delete()
    public Boolean delete(String sql) {
        Boolean isDelete = false;

        try (PreparedStatement statement = db.connect().prepareStatement(sql)) {

            // jalankan query SQL
            statement.execute(sql);

            isDelete = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isDelete;
    }

}
