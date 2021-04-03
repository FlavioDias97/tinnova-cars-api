package br.com.tinnova.cars.tinnovatestcars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tinnova.cars.tinnovatestcars.model.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long>{

    @Query(value = "SELECT CONCAT(brand, ' <->', COUNT(*)) as carsFilteredByBrand FROM tb_cars cars GROUP BY cars.brand", nativeQuery = true)
    public List<String> findCarsFilteredByBrand();

    @Query(value="SELECT CONCAT(CONCAT(LEFT(YEAR,3),0), ' <-> ', COUNT(*)) as carFilteredByDecade FROM tb_cars cars GROUP BY LEFT(year,3)", nativeQuery = true)
    public List<String> findCarsFilteredByDecade();

    @Query(value = "SELECT * FROM tb_cars cars WHERE DATE(cars.createdAt) BETWEEN (SYSDATE()-INTERVAL 7 DAY) AND SYSDATE() ", nativeQuery = true )
    public List<Car> findAllCarsRegisteredInWeek();

    @Query("SELECT COUNT(car) FROM Car car WHERE car.sold = 0")
    public int findCountAllCarsNotSould();
    
}
