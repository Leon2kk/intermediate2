package com.gb.data;

import java.util.List;

public interface IService {
    
    public void addToys(String name, Integer count, Integer probability);
    public void raffleToys(String firstName, String lastName, String phone);
    public void getPrize(Long id) throws Exception;
    public List<Toy> getAllPrizeToys();
    public List<WinningToy> getAllWinningToys();
}
