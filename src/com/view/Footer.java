package com.view;

import com.config.Config;

public class Footer {

    public static void display() {
        try {
            System.out.print("Tekan 'Enter' untuk melanjutkan:");
            Config.input.readLine();
            Config.clearScreen();

            Home.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
