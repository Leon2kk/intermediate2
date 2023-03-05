package com.gb.data;

public abstract class Toy {

    private Long id;
    private String name;
    private Integer count;
    private Integer probability;
    
    public Toy(Long id, String name, Integer count, Integer probability) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.probability = probability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "Toy [id=" + id + ", name=" + name + ", count=" + count + ", probability=" + probability + "]";
    }
}
