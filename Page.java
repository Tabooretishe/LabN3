package spiski;

import java.util.*;
import java.util.List;

class Page {
    private final String name;
    private final List<String> assocs = new ArrayList<>();
    private int count=0;


    public Page(String name) {
        this.name = name;
    }

    public void addassoc(String hassoc){
        assocs.add(hassoc);
    }

    public void vyvodSpiska(){
        System.out.print(name+" - "+count);
        System.out.println();
    }

    public void vyvodAssoc(){
        for(int i=0;i<assocs.size();i++){
            System.out.println(assocs.get(i));
        }
        count+=1;
    }

    public void vyvodNeAssoc(){
        if(assocs.isEmpty()){
            System.out.println(name+" ");
        }
        count+=1;
    }

    public int vychislsize(){
        return assocs.size();
    }

    public void sovpChyot(){
        boolean sovp = true;
        for (int i=0; i<assocs.size(); i++){
            if(assocs.size()%2!=0 && assocs.get(i).length()%2==0){
                sovp=false;
            }
            else if(assocs.size()%2==0 && assocs.get(i).length()%2!=0){
                sovp=false;
            }
        }
        if (sovp){
            count+=1;
        }
    }

    public String maxDlina(){
        String s ="";
        int mmax = -1;
        for(int i=0; i<assocs.size(); i++){
            if(mmax<assocs.get(i).length()){
                mmax = assocs.get(i).length();
                s=assocs.get(i);
            }
        }
        return s;
    }

    public List<String> assocContains(String s1){
        List<String> ar = new ArrayList<>();
        if(assocs.contains(s1)){
            ar=assocs;
        }
        return ar;
    }

    public void countplus(){
        count++;
    }

    public int countret(){
        return count;
    }
}

