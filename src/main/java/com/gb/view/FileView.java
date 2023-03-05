package com.gb.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gb.data.Toy;
import com.gb.data.WinningToy;

public class FileView { 

    public List<Toy> readFileToyCSV() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/gb/files/AllPrizeToys.csv"));
            List<Toy> toyList = new ArrayList<>();
            String str;
            while ((str = br.readLine()) != null) {
                List<String> promt = new ArrayList<>(Arrays.asList(str.split(";")));
                Toy toy = new Toy(Long.parseLong(promt.get(0)), promt.get(1), 
                Integer.parseInt(promt.get(2)), Integer.parseInt(promt.get(3))) { };
                toyList.add(toy);
            }
            br.close();
            return toyList;
        } catch (FileNotFoundException e) {
            new FileNotFoundException("Файл не найден!");
        } catch (IOException e){
            new IOException("Что-то пошло не так!");
        }
        return null;
    }

    public List<WinningToy> readFileWinningToysCSV() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/gb/files/WinningListToys.csv"));
            List<WinningToy> winningToyList = new ArrayList<>();
            String str;
            while ((str = br.readLine()) != null) {
                List<String> promt = new ArrayList<>(Arrays.asList(str.split(";")));
                WinningToy toy = new WinningToy(Long.parseLong(promt.get(0)), promt.get(1), 
                Integer.parseInt(promt.get(2)), Integer.parseInt(promt.get(3)), 
                promt.get(4), promt.get(5), promt.get(6));
                winningToyList.add(toy);
            }
            br.close();
            return winningToyList;
        } catch (FileNotFoundException e) {
            new FileNotFoundException("Файл не найден!");
        } catch (IOException e) {
            new IOException("Что-то пошло не так!");
        }
        return null;
    }

    public void writeFileToyCSV(List<Toy> listToys) {
        try (FileWriter fw = new FileWriter("src/main/java/com/gb/files/AllPrizeToys.csv", false)) {
            for (Toy toy: listToys) {
                fw.append(String.format("%s;", toy.getId()));
                fw.append(String.format("%s;", toy.getName()));
                fw.append(String.format("%s;", toy.getCount()));
                fw.append(String.format("%s;\n", toy.getProbability()));
            }
            fw.close();
        } catch (IOException e) {
            new IOException("Что-то пошло не так!");
        }
    }

    public void writeFileWinningToyCSV(List<WinningToy> listWinningToys) {
        try (FileWriter fw = new FileWriter("src/main/java/com/gb/files/WinningListToys.csv", false)) {
            for (WinningToy toy: listWinningToys) {
                fw.append(toy.getId() + ";");
                fw.append(toy.getName() + ";");
                fw.append(toy.getCount() + ";");
                fw.append(toy.getProbability() + ";");
                fw.append(toy.getFirstname() + ";");
                fw.append(toy.getLastname() + ";");
                fw.append(toy.getPhone() + ";" + "\n");
            }
            fw.close();
        } catch (IOException e) {
            new IOException("Что-то пошло не так!");
        }
    }
}
