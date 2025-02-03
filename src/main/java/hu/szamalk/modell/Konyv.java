package hu.szamalk.modell;

import java.util.*;

public class Konyv {
    private String cim;
    private int ar, kiadasiEv;
    private List<String> szerzok;

    public static CimComporator rendezCim() {
        return new CimComporator();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Konyv konyv = (Konyv) obj;
        return Objects.equals(szerzok, konyv.szerzok) &&
                Objects.equals(cim, konyv.cim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cim, ar, kiadasiEv, szerzok);
    }

    public void setSzerzokLista(List<String> szerzok) {
        this.szerzok = new ArrayList<>(new HashSet<>(szerzok));
    }

    @Override
    public String toString() {
        return "Konyv{" +
                "cim='" + cim + '\'' +
                ", ar=" + ar +
                ", kiadasEv=" + kiadasiEv +
                ", szerzok=" + szerzok +
                '}';
    }

    public Konyv(List<String> szerzok, String cim, int ar, int kiadasEv ) {
        setCim(cim);
        setAr(ar);
        setKiadasiEv(kiadasEv);
        setSzerzokLista(szerzok);
    }
    public Konyv(String szerzo, String cim, int ar, int kiadasEv){
        this(new ArrayList<>(), cim, ar, kiadasEv);
        setSzerzok(szerzo);
    }
    public String getCim() {
        return cim;
    }
    public void setCim(String cim) {
        this.cim = cim;
    }
    public int getAr() {
        return ar;
    }
    public void setAr(int ar) {
        this.ar = ar;
    }
    public List<String> getSzerzok() {
        return szerzok;
    }
    public int getKiadasEv() {
        return kiadasiEv;
    }
    public void setKiadasiEv(int kiadasEv) {
        if(kiadasEv<1000 || kiadasEv>2025){
            throw new NemLetezoKiadasiEvException("A kiadási év 1000 és 2025 legyen");
        }else{
            this.kiadasiEv = kiadasEv;
        }

    }
    public void setSzerzok(String szerzo){
        this.szerzok.add(szerzo);
    }
}
