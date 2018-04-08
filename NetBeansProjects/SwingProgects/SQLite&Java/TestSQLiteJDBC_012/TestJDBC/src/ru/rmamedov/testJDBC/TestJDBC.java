package ru.rmamedov.testJDBC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.sqlite.SQLiteException;

public class TestJDBC {

    public static void main(String[] args) {
        
        Connection con = null;
        Statement stm = null;
        ResultSet res = null;
        BufferedWriter bfw = null;
        Scanner scanner = null;
        FileInputStream fis = null;
        FileWriter flw = null;
        
        try {
            
            String url = null;
            //Writer to result file.
            bfw = new BufferedWriter(flw = new FileWriter("../../TestSQLiteJDBC_012/result.text"));
            //Read url from file.
            scanner = new Scanner(fis = new FileInputStream("../../TestSQLiteJDBC_012/sql.text"));
            url = scanner.nextLine();
            
//            if (!new File(url).exists()) {
//                System.out.println("File of DB not found");
//                return;
//            }
            
            con = DriverManager.getConnection(url);
            
            String sql = null;
            //Catch ";".
            scanner.useDelimiter(";");
            while(scanner.hasNext()) {
                //
                //Gettin SQL query.
                sql = scanner.next();
                //
                //Writing SQL to console.
                System.out.println(sql);
                //
                stm = con.createStatement();
                res = stm.executeQuery(sql);
                while(res.next()) {
                    System.out.println(res.getString("name_en") + "  -  " + res.getString("name_ru"));
                    bfw.write(res.getString("name_en") + "  -  " + res.getString("name_ru") + "\n");
                    bfw.flush();
                }
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (stm != null) stm.close();
                if (res != null) res.close();
                if (bfw != null) bfw.close();
                if (scanner != null) scanner.close();
                if (fis != null) fis.close();
                if (flw != null) flw.close();
            } catch (Exception e) {
            }
        }
    }
}
