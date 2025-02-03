package hu.szamalk.modell;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class ArComporator implements Comparator<Konyv> {
    @Override
    public int compare(Konyv o1, Konyv o2) {
        return Integer.compare(o1.getAr(), o2.getAr());
    }
}