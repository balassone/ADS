import java.util.ArrayList;

public class ItalicRecognizer {

    private String[] dictionary;
    private ArrayList<Integer[]> cuts=new ArrayList<Integer[]>();

    public void setDictionary(String[] d){
        this.dictionary=d;
    }

    public void findOutIfItalian(String s){
        boolean res=recognize(s, 0);

        //se è italiano faccio il cut e stampo
        if(res){
            for(int i=0;i<cuts.size();i++){
                System.out.print(s.substring(cuts.get(cuts.size()-i-1)[0],cuts.get(cuts.size()-i-1)[1])+" ");
            }
        }else{
            System.out.println("Questo non credo sia Italiano");
        }

    }

    //funzione che controlla se una parola è nel dizionario
    public boolean contains(String s){

        for(int i=0;i<dictionary.length;i++){
            if(dictionary[i].compareTo(s)==0){
                return true;
            }
        }

        return false;
    }

    public boolean recognize(String s, int index){
        boolean res=false;

        if(index==s.length()){
            return true;
        }

        //for(int i=index;i<s.length()+1;i++){
            for(int j=index+1;j<s.length()+1;j++){

                String sub=s.substring(index, j);
                boolean r=contains(sub) && recognize(s, j);

                if(r==true){
                    res=r;
                    Integer[] IJ={index,j};
                    cuts.add(IJ); // ricordarsi che per ricorsione i cuts sono ordinati al contrario
                    return res;
                }

            }
        //}

        return res;
    }

    public static void main(String[] args) throws Exception {
        String s="eraunanottebuiaetempestosa";

        String[] dictionary={"e","era","una","notte","buia","tempestosa"};

        ItalicRecognizer recognizer=new ItalicRecognizer();
        recognizer.setDictionary(dictionary);

        recognizer.findOutIfItalian(s);

    }
}
