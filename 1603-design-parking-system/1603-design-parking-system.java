class ParkingSystem {
    private static final int CAR_TYPES = 3;
    private Map<Integer, Integer> parking;
    private int[] limits;
    
    public ParkingSystem(int big, int medium, int small) {
        parking = new HashMap<>();
        limits = new int[CAR_TYPES + 1];
        limits[1] = big;
        limits[2] = medium;
        limits[3] = small;
    }
    
    public boolean addCar(int carType) {
        if(parking.getOrDefault(carType, 0) == limits[carType]) return false;
        parking.put(carType, parking.getOrDefault(carType, 0) + 1);
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */