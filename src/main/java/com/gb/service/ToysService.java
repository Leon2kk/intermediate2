package com.gb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.gb.data.IService;
import com.gb.data.Toy;
import com.gb.data.WinningToy;

public class ToysService implements IService{

    private final List<Toy> allToys;
    private final List<WinningToy> winningToysList;
    private Integer max_prob = 100;

    public ToysService() {
        this.allToys = new ArrayList<Toy>();
        this.winningToysList = new ArrayList<WinningToy>();
    }

    @Override
    public void addToys(String name, Integer count, Integer probability) {
        Long id = 0L;
        for(Toy item: this.allToys) {
            if(id < ((Toy) item).getId()) {
                id = ((Toy) item).getId();
            }
        }
        Toy toy = new Toy(++id, name, count, probability) { };
        this.allToys.add(toy);
    }

    public void updateToy(Long id, Integer probability) throws Exception {
        String name;
        Integer count;
        Boolean flag = false;
        for (Toy toy: this.allToys) {
            if (toy.getId().equals(id)) {
                name = toy.getName();
                count = toy.getCount();
                Toy updateToy = new Toy(id, name, count, probability) {};
                this.allToys.remove(toy);
                this.allToys.add(updateToy);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            throw new Exception("Игрушка не найдена!");
        }
    }

    @Override
    public void raffleToys(String firstName, String lastName, String phone) {
        Random r = new Random();
        Integer rIntNumber = r.nextInt(this.allToys.size());
        Integer rIntNumberProb = r.nextInt(max_prob);
        if (rIntNumberProb >= 0 && rIntNumberProb <= this.allToys.get(rIntNumber).getProbability()) {
            Long id = 0L;
            for(WinningToy item: this.winningToysList) {
                if(id < ((WinningToy) item).getId()) {
                    id = ((WinningToy) item).getId();
                }
            }
        WinningToy wt = new WinningToy(++id, this.allToys.get(rIntNumber).getName(), 1, 
        this.allToys.get(rIntNumber).getProbability(), firstName, lastName, phone);
        this.winningToysList.add(wt);
        if (this.allToys.get(rIntNumber).getCount() == 1) {
            this.allToys.remove(this.allToys.get(rIntNumber));
        }
        else if (this.allToys.get(rIntNumber).getCount() > 1) {
            this.allToys.get(rIntNumber).setCount(this.allToys.get(rIntNumber).getCount() - 1);
        }
        System.out.println("Ура! Ваш приз - " + wt.getName());
        }
        else {
            System.out.println("Выигрыша нет! Повезет в другой раз!");
        }
    }

    @Override
    public void getPrize(Long id) throws Exception {
        Boolean flag = false;
        for (WinningToy toy: this.winningToysList) {
            if (id == toy.getId()) {
                this.winningToysList.remove(toy);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            throw new Exception("Позиция для выдачи не найдена!");
        }
    }

    @Override
    public List<Toy> getAllPrizeToys() {
        return this.allToys;
    }

    @Override
    public List<WinningToy> getAllWinningToys() {
        return this.winningToysList;
    }

    public WinningToy searchWT(Long id) {
        for (WinningToy toy: this.winningToysList) {
            if (id == toy.getId()) {
                return toy;
            }
        }
        throw new IllegalStateException("Игрушка не найдена!");
    }
}
