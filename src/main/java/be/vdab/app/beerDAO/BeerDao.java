package be.vdab.app.beerDAO;

import be.vdab.app.exceptions.BeerException;
import be.vdab.app.model.Beer;

public interface BeerDao {
    Beer getBeerById(int id) throws BeerException;
    void updateBeer (Beer beer) throws BeerException;
}
