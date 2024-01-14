public class Box {

    private int nBurgers;
    private int timeFilled;

    public Box(int n, int t){
        this.nBurgers=n;
        this.timeFilled=t;
    }

    public void addBurgers(){
        this.nBurgers++;
    }

    public void addTime(int t){
        this.timeFilled += t;
    }

    public int getnBurgers() {
        return nBurgers;
    }
    public void setnBurgers(int nBurgers) {
        this.nBurgers = nBurgers;
    }
    public int getTimeFilled() {
        return timeFilled;
    }
    public void setTimeFilled(int timeFilled) {
        this.timeFilled = timeFilled;
    }

    
    
}
