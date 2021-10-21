public class Package {
    private int zipcode, weight, volume, id;
    private boolean hazmat;

    public Package() {

    }
    public Package(int nZ, int nW, int nV, int nH, int iD) {
        this.zipcode = nZ;
        this.weight = nW;
        this.volume = nV;
        this.id = iD;
        if (nH == 1)
            this.hazmat = true;
        else
            this.hazmat = false;
    }

    // Getters
    public int getZipcode() {
        return this.zipcode;
    }
    public int getID() {
        return this.id;
    }
    public int getWeight() {
        return this.weight;
    }
    public int getVolume() {
        return this.volume;
    }
    public boolean getHazmat() {
        return this.hazmat;
    }

    public String toString() {
        return " Zipcode: " + zipcode + " Weight: " + weight + " Volume: " +volume+ " Hazmat: " +hazmat;
    }
}
