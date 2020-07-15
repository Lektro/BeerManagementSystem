package be.vdab.app.model;

import java.io.Serializable;

public class Beer implements Serializable {

    private int id;
    private String name;
    private float price;
    private int stock;
    private float alcohol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof be.vdab.app.model.Beer)) return false;

        be.vdab.app.model.Beer beer = (be.vdab.app.model.Beer) o;

        if (id != beer.id) return false;
        if (Float.compare(beer.price, price) != 0) return false;
        if (Float.compare(beer.alcohol, alcohol) != 0) return false;
        return name != null ? name.equals(beer.name) : beer.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (alcohol != +0.0f ? Float.floatToIntBits(alcohol) : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", alcohol=" + alcohol +
                '}';
    }
}
