package com.bigbang.myapplication.model;

public class Recipe {

    private String imageLink;

    private String recipe;

    private String recipeTitle;


    public Recipe(String imageLink, String recipe, String recipeTitle) {
        this.imageLink = imageLink;
        this.recipe = recipe;
        this.recipeTitle = recipeTitle;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }
}
