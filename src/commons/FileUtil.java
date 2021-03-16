package commons;

import models.House;
import models.Room;
import models.Services;
import models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static void writeCSV(String PATH,Object services,boolean writeMode){
        File file = new File(PATH);
        FileWriter fileWriter ;
        BufferedWriter buffWrite = null;
        try {

            fileWriter = new FileWriter(file, writeMode);

            buffWrite = new BufferedWriter(fileWriter);

            buffWrite.write(services.toString()+"\n");
            buffWrite.flush();

        } catch ( IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(buffWrite != null){
                    buffWrite.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Services> readCSV(String PATH){
        List<Services> servicesList = new ArrayList<>();
        BufferedReader buffRead = null;
        File file = new File(PATH);
        try {
            FileReader fileReader = new FileReader(file);
            buffRead = new BufferedReader(fileReader);

            String line;
            String[] temp;
            Services services;
            while ((line = buffRead.readLine()) !=null){
                temp = line.split(",");
                if (temp.length == 10) {
                    services = new Villa(temp[0],temp[1],Double.parseDouble(temp[2]),Double.parseDouble(temp[3]),Integer.parseInt(temp[4]),temp[5],temp[6],temp[7],Double.parseDouble(temp[8]),Integer.parseInt(temp[9]));
                    servicesList.add(services);
                }

                if (temp.length == 9) {
                    services = new House(temp[0],temp[1],Double.parseDouble(temp[2]),Double.parseDouble(temp[3]),Integer.parseInt(temp[4]),temp[5],temp[6],temp[7],Integer.parseInt(temp[8]));
                    servicesList.add(services);
                }

                if (temp.length == 7) {
                    services = new Room(temp[0],temp[1],Double.parseDouble(temp[2]),Double.parseDouble(temp[3]),Integer.parseInt(temp[4]),temp[5],temp[6]);
                    servicesList.add(services);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("co loi ban oi.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return servicesList;
    }


}
