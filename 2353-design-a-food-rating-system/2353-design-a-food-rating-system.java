class FoodRatings {
    private Map<String, String> foodCuisineMap = new HashMap<>();
    private Map<String, Integer> foodRatings = new HashMap<>();
    private Map<String, TreeSet<Pair<Integer, String>>> cuisineFoodItems = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++) {
            foodCuisineMap.put(foods[i], cuisines[i]);
            foodRatings.put(foods[i], ratings[i]);
            cuisineFoodItems.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
                int compareByRating = Integer.compare(a.getKey(), b.getKey());
                    if (compareByRating == 0) {
                        // If ratings are equal, compare by food name (in ascending order).
                        return a.getValue().compareTo(b.getValue());
                    }
                    return compareByRating;
            }));
            cuisineFoodItems.get(cuisines[i]).add(new Pair<>(-1*ratings[i], foods[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisineName = foodCuisineMap.get(food);
        Integer oldRating = foodRatings.get(food);

        TreeSet<Pair<Integer, String>> cuisineSet = cuisineFoodItems.get(cuisineName);
        Pair<Integer, String> oldElement = new Pair<>(-1*oldRating, food);
        cuisineSet.remove(oldElement);
        
        foodRatings.put(food, newRating);
        cuisineSet.add(new Pair<>(-1*newRating, food));
    }
    
    public String highestRated(String cuisine) {
        return cuisineFoodItems.get(cuisine).first().getValue();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */