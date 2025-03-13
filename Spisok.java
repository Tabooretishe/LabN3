package spiski;

import java.util.*;

public class Spisok{

    private final Map<String, Page> pages = new HashMap<>();


    public Spisok() {
    }

    public void addPage(String pagename, List<String> pageassoc){
        Page p = pages.putIfAbsent(pagename, new Page(pagename));
        if(p==null){
            p=pages.get(pagename);
            for(String association : pageassoc){
                p.addassoc(association);
            }
        }
    }

    public void addassoc(String gassoc){
        for (Page page : pages.values()) {
            page.addassoc(gassoc);
        }
    }

    public void vyvodSpiska(){
        for(Page page2 : pages.values()){
            page2.vyvodSpiska();
        }
    }

    public void vyvodAssoc(String hname){
        pages.get(hname).vyvodAssoc();
    }

    public void vyvodNeAssoc(){
        for(Page page1 : pages.values()){
            page1.vyvodNeAssoc();
        }
    }

    public void vyvodMaxAssoc(){
        Page page3 = new Page("barankin");
        page3.addassoc("yeawo");
        page3.addassoc("yeawo");
        page3.addassoc("yeawo");
        page3.addassoc("yeawo");
        page3.addassoc("yeawo");
        page3.addassoc("yeawo");
        System.out.println(page3.vychislsize());
        int maxpower = -1;
        int yer=1;
    }

    public void sovpcChyot(){
        for(Page page4 : pages.values()){
            page4.sovpChyot();
        }
    }

    public void maxDlina(){
        int mmax = -2147483648;
        String s1="GERAALD";
        Set<String> key=pages.keySet();
        String s2="";
        Map<String, Page> pages1 = new HashMap<>();
        if(pages.size()>1){
            for(Page page5 : pages.values()){
                if(mmax<page5.maxDlina().length()){
                    mmax=page5.maxDlina().length();
                    s1=page5.maxDlina();
                }
            }
        }
        Page page7 = new Page("");
        for(Page page6 : pages.values()){
            pages1.put(s2, page6);
            if (pages1.containsValue(page6.assocContains(s1)) && !(pages1.containsValue(null))){
                page7=page6;
                break;
            }
        }
        System.out.println(page7.assocContains(s1)+" "+s1);
    }

    public void threePopular(){
        int mmax1=-2147483648;
        int mmax2=-2147483648;
        int mmax3=-2147483648;
        Page page7 = new Page("");
        Page page8 = new Page("");
        Page page9 = new Page("");
        for(Page page10 : pages.values()){
            if(mmax1<page10.countret()){
                mmax1=page10.countret();
                page7 = page10;
            }
            if(mmax2<page10.countret() && mmax2<mmax1){
                mmax2=page10.countret();
                page8 = page10;
            }
            if(mmax3<page10.countret() && mmax3<mmax2 && mmax3 <mmax1){
                mmax3=page10.countret();
                page9 = page10;
            }
        }
    }
}
