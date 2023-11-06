class SeatManager {
    int seats;
    int nextSmallestSeatCanBeReserved;
    PriorityQueue<Integer> unReservedSeats;
    public SeatManager(int n) {
        this.seats = n;
        this.nextSmallestSeatCanBeReserved = 1;
        unReservedSeats = new PriorityQueue<>();
    }
    
    public int reserve() {
        int possibleSeat = seats + 1;
        if(!unReservedSeats.isEmpty() && unReservedSeats.peek() < nextSmallestSeatCanBeReserved) {
            possibleSeat = unReservedSeats.remove();
        } else {
            possibleSeat = nextSmallestSeatCanBeReserved++;
        }
        return possibleSeat;
    }
    
    public void unreserve(int seatNumber) {
        unReservedSeats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */