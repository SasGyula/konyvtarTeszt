package hu.szamalk.modell;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class CimComporator implements Comparator<Konyv> {
    @Override
    public int compare(Konyv o1, Konyv o2) {
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        return collator.compare(o1.getCim(), o2.getCim());
    }
}
