package be.vdab.app.beerDAO;

import be.vdab.app.exceptions.BeerException;
import be.vdab.app.model.Beer;
import java.sql.*;

/** static import of login credentials */
import static be.vdab.app.login.util.LoginCredentials.*;

public class BeerDoaImpl {

    //@Override
    public Beer getBeerById(int id) throws BeerException {
        try (Connection con = DriverManager.getConnection(
                url,
                user,
                pass);

             PreparedStatement prepstat = con.prepareStatement(
                     "SELECT * FROM Beers Where Id =?"
             );
             ResultSet rs = prepstat.executeQuery()
        ) {

            prepstat.setInt(1, id);
            if (rs.next()) {
                Beer resultingBeer = new Beer();
                resultingBeer.setId(id);
                resultingBeer.setName(rs.getString("Name"));
                resultingBeer.setPrice(rs.getFloat("Price"));
                resultingBeer.setAlcohol(rs.getFloat("Alcohol"));
                resultingBeer.setStock(rs.getInt("Stock"));

                return resultingBeer;

            } else {
                return null;
            }
        } catch (SQLException sqlException) {
            System.out.println("Oops connection failed");
            sqlException.printStackTrace();
            throw new BeerException(sqlException);
        }
    }

    //@Override
    public void updateBeer(Beer beer) throws BeerException {

        try (Connection con = DriverManager.getConnection(
                url,
                user,
                pass);

             PreparedStatement ps = con.prepareStatement(
                     " UPDATE Beers SET Name=?, Price=?, Alcohol=?, Stock=? WHERE Id = ? "
             )

        ) {
            ps.setString(1, beer.getName());
            ps.setFloat(2, beer.getPrice());
            ps.setFloat(3, beer.getAlcohol());
            ps.setInt(4, beer.getStock());
            ps.setInt(5, beer.getId());

        } catch (SQLException sqlException) {
            System.out.println("Oops connection failed");
            sqlException.printStackTrace();
            throw new BeerException(sqlException);
        }
    }
}
