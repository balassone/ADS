public class Box {
    
    private int lunghezza;
    private int larghezza;
    private int altezza;

    public Box (int lung, int larg, int h){
        this.altezza=h;
        this.larghezza=larg;
        this.lunghezza=lung;
    }

    public int getLunghezza() {
        return lunghezza;
    }
    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }
    public int getLarghezza() {
        return larghezza;
    }
    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }
    public int getAltezza() {
        return altezza;
    }
    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public boolean isSmaller(Box box2){
    
        if(this.lunghezza<box2.getLunghezza()){
            return true;
        }else if(this.lunghezza==box2.getLunghezza() && this.larghezza <= box2.getLarghezza()){
            return true;
        }

        return false;

    }
    

}
