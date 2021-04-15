package itacademy.kg.mealrecipes;

import java.util.ArrayList;

public class Meal {

    private int imageResource;
    private String time;
    private String name;
    private String description;
    private int favouriteImage;

    public Meal(int imageResource, String time, String name, String description, int favouriteImage) {
        this.imageResource = imageResource;
        this.time = time;
        this.name = name;
        this.description = description;
        this.favouriteImage = favouriteImage;
    }

    public static ArrayList<Meal> mealArrayList = dataBase.mealArrayList;

    public int getImageResource() {
        return imageResource;
    }

    public void setFavouriteImage(int favouriteImage) {
        this.favouriteImage = favouriteImage;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Meal position(int position) {
        return mealArrayList.get(position);
    }

    public static ArrayList<Meal> meals = new ArrayList<>();

    public static void addMeals(Meal meal){
        meals.add(meal);
    }
    public static void removeMeals(Meal meal){
        meals.remove(meal);
    }


}
