package com.gb.view;

import java.util.List;
import java.util.logging.Logger;

import com.gb.data.Toy;
import com.gb.data.WinningToy;

public class ToyView {

    Logger log = Logger.getAnonymousLogger();
    
    public void sendOnControllerT(List<Toy> listAllToys) {
        log.info("Список игрушек в наличии: ");
        for (Toy toy: listAllToys) {
            log.info(toy.toString());
        }
    }

    public void sendOnControllerWTs(List<WinningToy> lWinningToys) {
        log.info("Список всех выигранных игрушек: ");
        for (WinningToy toy: lWinningToys) {
            log.info(toy.toString());
        }
    }

    public void sendOnControllerW(WinningToy toy) {
        log.info("Выиграна новая игрушка: " + toy.toString());
    }
}
