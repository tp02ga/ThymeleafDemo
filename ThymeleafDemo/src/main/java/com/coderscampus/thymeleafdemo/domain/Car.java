package com.coderscampus.thymeleafdemo.domain;

public class Car
{
  private String brand;
  private Integer year;
  private String fuelType;
  
  public String getBrand()
  {
    return brand;
  }
  public void setBrand(String brand)
  {
    this.brand = brand;
  }
  public Integer getYear()
  {
    return year;
  }
  public void setYear(Integer year)
  {
    this.year = year;
  }
  public String getFuelType()
  {
    return fuelType;
  }
  public void setFuelType(String fuelType)
  {
    this.fuelType = fuelType;
  }
  @Override
  public String toString()
  {
    return "Car [brand=" + brand + ", year=" + year + ", fuelType=" + fuelType
        + "]";
  }
}
