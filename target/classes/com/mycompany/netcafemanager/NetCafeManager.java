/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.netcafemanager;

<<<<<<< HEAD
<<<<<<< HEAD
import dao.ComputerDAO;
import entity.Computer;
import io.IOServer;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Admin
 */
public class NetCafeManager {

    public static void main(String[] args) throws IOException {
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar: " + calendar);
        System.out.println("DateNow: " + new Date());
        
        if(2 == 2){
            System.out.println(calendar);
        }
        IOServer server = new IOServer(1);
        server.start();
        
        IOServer.ClientHandler clientHandler = IOServer.loggedInClientsMap.get(3);
        int computerID = clientHandler.getComputerID();
        ComputerDAO cdao = new ComputerDAO();
        
        try {
            Computer com = cdao.selectByID(computerID);
            String stt = com.getStatus();
            switch(stt){
            case "Đang chờ":{
                    System.out.println("1");
                break;
            }
           default: System.out.println("2");
        }
        } catch (Exception ex) {
            Logger.getLogger(NetCafeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
=======
import java.io.IOException;




/**
 *
 * @author Admin
 */
public class NetCafeManager {

    public static void main(String[] args) throws IOException {
    }     
>>>>>>> origin/master
=======
import java.io.IOException;




/**
 *
 * @author Admin
 */
public class NetCafeManager {

    public static void main(String[] args) throws IOException {
    }     
>>>>>>> origin/master
}
