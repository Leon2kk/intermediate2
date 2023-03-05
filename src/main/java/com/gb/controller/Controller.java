package com.gb.controller;

import java.util.List;

import com.gb.data.Toy;
import com.gb.data.WinningToy;
import com.gb.service.ToysService;
import com.gb.view.FileView;
import com.gb.view.ToyView;

public class Controller {
    
    private final ToysService ts = new ToysService();
    private final ToyView tv = new ToyView();
    private final FileView fv = new FileView();

    public void createToy(String name, Integer count, Integer probability) {
        ts.addToys(name, count, probability);
        fv.writeFileToyCSV(getAllToysList());
    }

    public void updateToy(Long id, Integer probability) {
        try {
            ts.updateToy(id, probability);
        } catch (Exception e) {
            throw new IllegalStateException("Игрушка не найдена!");
        }
        fv.writeFileToyCSV(getAllToysList());
    }

    public void getRuffle(String firstname, String lastname, String phone) {
        ts.raffleToys(firstname, lastname, phone);
        fv.writeFileToyCSV(getAllToysList());
        fv.writeFileWinningToyCSV(getAllWinningToysList());
    }

    public void getPrize(Long id) {
        try {
            ts.getPrize(id);
        } catch (Exception e) {
            throw new IllegalStateException("Позиция для выдачи не найдена!");
        }
        fv.writeFileWinningToyCSV(getAllWinningToysList());
    }

    public List<Toy> getAllToysList() {
        return ts.getAllPrizeToys();
    }

    public void showAllToysList(List <Toy> toysList) {
        tv.sendOnControllerT(toysList);
    }

    public List<WinningToy> getAllWinningToysList() {
        return ts.getAllWinningToys();
    }

    public void showAllWinningToysList(List <WinningToy> toysList) {
        tv.sendOnControllerWTs(toysList);
    }

    public void showWinningToy(WinningToy toy) {
        tv.sendOnControllerW(toy);
    }

    public WinningToy getWinningToy(Long id) {
        return ts.searchWT(id);
    }
}
