package br.com.tinnova.cars.tinnovatestcars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tinnova.cars.tinnovatestcars.model.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long>{

    @Query(value = "Select CONCAT(brand, ' <->', COUNT(*)) as carsFilteredByBrand FROM tb_cars cars GROUP BY cars.brand", nativeQuery = true)
    public List<String> findCarsFilteredByBrand();

    @Query(value="Select CONCAT(CONCAT(LEFT(YEAR,3),0), ' <-> ', COUNT(*)) as carFilteredByDecade FROM tb_cars cars GROUP BY LEFT(year,3)", nativeQuery = true)
    public List<String> findCarsFilteredByDecade();

    @Query(value = "Select * FROM tb_cars cars WHERE DATE(cars.created_at) BETWEEN (SYSDATE()-INTERVAL 7 DAY) AND SYSDATE() ", nativeQuery = true )
    public List<Car> findAllCarsRegisteredInWeek();

    @Query("Select COUNT(car) FROM Car car WHERE car.isSolded = 0")
    public int findCountAllCarsNotSould();
    
}
