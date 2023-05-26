
package com.example.winemeup;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Wine implements  Serializable{
   private String colour;
   private String country;
   private String description;
   private String imageDish;
   private String nameDish;
   private String domain;
   private String image;
   private int price;
   private String region;
   private int year;

   public Wine(String colour, String country, String description, String nameDish, String imageDish, String domain, String image, int price, String region, int year) {
      if (domain.trim().equals("")){
         domain = "Wine NoDomain";
      }

      this.colour = colour;
      this.country = country;
      this.description = description;
      this.imageDish = imageDish;
      this.nameDish = nameDish;
      this.domain = domain;
      this.image = image;
      this.price = price;
      this.region = region;
      this.year = year;
   }

   public Wine() {
       //empty constructor needed
   }

   public String getColour() {
      return colour;
   }

   public void setColour(String colour) {
      this.colour = colour;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getImageDish() {
      return imageDish;
   }

   public void setImageDish(String imageDish) {
      this.imageDish = imageDish;
   }

   public String getNameDish() {
      return nameDish;
   }

   public void setNameDish(String nameDish) {
      this.nameDish = nameDish;
   }

   public String getDomain() {
      return domain;
   }

   public void setDomain(String domain) {
      this.domain = domain;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getRegion() {
      return region;
   }

   public void setRegion(String region) {
      this.region = region;
   }


   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year=year;
}
}