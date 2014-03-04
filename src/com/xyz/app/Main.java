package com.xyz.app;

import com.xyz.app.control.Controller;

/**
 * The entry point for the application.
 * On execute Controller is called to do the Job
 */
public class Main {

    public static void main(String[] args) {
        try {
            Controller.doTheJob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
