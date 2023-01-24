/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author WRojas
 */
public class Database {

        public static Connection Open(){
            String dbURL="jdbc:mysql://localhost:3306/ecodosruedas";
            String user="root";
            String password="mysql";
            Connection con=null;

            try{
               con=DriverManager.getConnection(dbURL,user,password);
               if(con!=null){
                   System.out.println("Conexión exitosa");
                }
            }catch(SQLException error){

                System.out.println("Error: "+error.getErrorCode()+" "+error.getMessage());

            }
            return con;
        }
}
