class ParkingSystem {
    private static final int CAR_TYPES = 3;
    private int[] parking;
    private int[] limits;
    
    public ParkingSystem(int big, int medium, int small) {
        parking = new int[CAR_TYPES + 1];
        parking[1] = big;
        parking[2] = medium;
        parking[3] = small;
    }
    
    public boolean addCar(int carType) {
        if(parking[carType] == 0) return false;
        parking[carType]--;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */