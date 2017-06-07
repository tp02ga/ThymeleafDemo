package com.coderscampus.thymeleafdemo.domain;

public class Model
{
  private String name;
  private Integer year;
  private String fuelType;
  
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

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return "Model [name=" + name + ", year=" + year + ", fuelType=" + fuelType
        + "]";
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fuelType == null) ? 0 : fuelType.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((year == null) ? 0 : year.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Model other = (Model) obj;
    if (fuelType == null)
    {
      if (other.fuelType != null)
        return false;
    } else if (!fuelType.equals(other.fuelType))
      return false;
    if (name == null)
    {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (year == null)
    {
      if (other.year != null)
        return false;
    } else if (!year.equals(other.year))
      return false;
    return true;
  }
  

}
