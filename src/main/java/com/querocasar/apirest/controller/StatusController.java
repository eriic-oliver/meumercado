package com.querocasar.apirest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.Timer;
import java.util.TimerTask;

@RestController
public class StatusController {
    @GetMapping(path = "/api/status")
    public String status(){
        return "Online";
    }

   /* @GetMapping(path = "/api/ping")
    public void ping(){
        final long time = 1800000; // a cada X ms
        Timer timer = new Timer();
        TimerTask tarefa = new TimerTask() {
            public void run() {
                //método
                try {
                    pingar("https://quero-casar-api.herokuapp.com/api/status");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(tarefa, time, time);
    }

    private static void pingar(String host) {
        try {
            if (InetAddress.getByName(host).isReachable(5000))
                System.out.println("Ping OK: " + host);
            else
                System.out.println("Ping FALHOU: " + host);
        } catch (Exception e) {
            System.err.println("Ping FALHOU: " + host + " - " + e);
        }
    }*/
}
