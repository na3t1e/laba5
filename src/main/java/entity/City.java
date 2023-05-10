package entity;

import org.jetbrains.annotations.NotNull;

import java.time.ZonedDateTime;
import java.util.Objects;

public class City implements Comparable<City>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private static long nextId;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double area; //Значение поля должно быть больше 0
    private Long population; //Значение поля должно быть больше 0, Поле не может быть null
    private Float metersAboveSeaLevel;
    private int telephoneCode; //Значение этого поля должно быть уникальным, Значение поля должно быть больше 0, Максимальное значение поля: 100000
    private Integer carCode; //Значение поля должно быть больше 0, Максимальное значение поля: 1000, Поле может быть null
    private Climate climate; //Поле не может быть null
    private Human governor; //Поле может быть null

    public City(String name, Coordinates coordinates, ZonedDateTime creationDate, double area, Long population, Float metersAboveSeaLevel, int telephoneCode, Integer carCode, Climate climate, Human governor) {
        this.id = incId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.population = population;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.telephoneCode = telephoneCode;
        this.carCode = carCode;
        this.climate = climate;
        this.governor = governor;
    }

    public City() {
    }

    private static long incId(){
       return ++nextId;
    }

    public static void decId(){
        nextId--;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Float getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public void setMetersAboveSeaLevel(Float metersAboveSeaLevel) {
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public int getTelephoneCode() {
        return telephoneCode;
    }

    public void setTelephoneCode(int telephoneCode) {
        this.telephoneCode = telephoneCode;
    }

    public Integer getCarCode() {
        return carCode;
    }

    public void setCarCode(Integer carCode) {
        this.carCode = carCode;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public Human getGovernor() {
        return governor;
    }

    public void setGovernor(Human governor) {
        this.governor = governor;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates: " + coordinates +
                ", creationDate=" + creationDate +
                ", area=" + area +
                ", population=" + population +
                ", metersAboveSeaLevel=" + metersAboveSeaLevel +
                ", telephoneCode=" + telephoneCode +
                ", carCode=" + carCode +
                ", climate=" + climate +
                ", " + governor +
                '}';
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, area, population, metersAboveSeaLevel, telephoneCode, carCode, climate, governor);
    }

    @Override
    public int compareTo(@NotNull City o) {
        return this.getId().compareTo(o.getId());
    }
}

