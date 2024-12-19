public class Wolf implements Comparable<Wolf> {
    private double size;
    private int rank;
    
    public Wolf(double size, int rank) {
        this.size = size;
        this.rank = rank;
    }
    
    public double getSize() {
        return size;
    }
    
    public int getRank() {
        return rank;
    }
    
    @Override
    public int compareTo(Wolf other) {
        // This assumes you want to sort by size
        // For descending order (largest to smallest)
        return Double.compare(this.size, other.size);
        
        // If you want to sort by rank instead, use:
        // return Integer.compare(this.rank, other.rank);
    }
}