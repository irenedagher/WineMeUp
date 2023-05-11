package com.example.winemeup;

public class Wine {
   private String colour;
   private String country;
   private String description;
  /* private Dish dish;
   private String domain;
   private String image;
   private int price;
   private String region;
   private Variety varieties;
   private int year;*/

   public Wine(String colour, String country, String description/*, Dish dish, String domain, String image, int price, String region, Variety varieties, int year*/) {
      this.colour = colour;
      this.country = country;
      this.description = description;
     /* this.dish = dish;
      this.domain = domain;
      this.image = image;
      this.price = price;
      this.region = region;
      this.varieties = varieties;
      this.year = year;*/
   }

   public Wine() {
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
/*
   public Dish getDish() {
      return dish;
   }

   public void setDish(Dish dish) {
      this.dish = dish;
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

   public Variety getVarieties() {
      return varieties;
   }

   public void setVarieties(Variety varieties) {
      this.varieties = varieties;
   }

   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
   }*/
}
