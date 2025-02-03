package hu.szamalk.modell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class KonyvTest {
    @Test
    void ketSzerzo(){
        List<String> szerzok = new ArrayList<>();
        szerzok.add("Valaki");
        szerzok.add("Bárki");
        Konyv konyv = new Konyv(szerzok, "Özvegy tehén bosszúja",  2000, 2025);
        Assertions.assertEquals(2, konyv.getSzerzok().size());
    }

    @Test
    void egySzerzo(){
        Konyv konyv = new Konyv("valaki","Özvegy tehén bosszúja",  2000, 2025);
        Assertions.assertEquals(1, konyv.getSzerzok().size());
    }


    @Test
    void testKstrKiadas(){
        assertThrows(NemLetezoKiadasiEvException.class, () -> new Konyv("a", "c", 1,999));
        assertThrows(NemLetezoKiadasiEvException.class, () -> new Konyv("a", "c", 1,2026));
    }

    @Test
    void testSetKiadas(){
        Konyv konyv = new Konyv("a", "c", 1000,1999);
        assertThrows(NemLetezoKiadasiEvException.class, () -> konyv.setKiadasiEv(999));
        assertThrows(NemLetezoKiadasiEvException.class, () -> konyv.setKiadasiEv(2026));
    }

    @Test
    void testKstrSzerzok(){
        Konyv konyv;
        konyv = new Konyv("sz", "cim1", 1000,1978);
        assertEquals(1, konyv.getSzerzok().size());

        List<String>szerzok = List.of("sz1", "sz1");
        konyv = new Konyv(szerzok, "cim1", 1000, 1978);
        assertEquals(1, konyv.getSzerzok().size());

        szerzok = List.of("sz1", "sz2", "sz3");
        konyv = new Konyv(szerzok, "cim1", 1000,1978);
        assertEquals(konyv.getSzerzok().size(), szerzok.size());
        konyv.setSzerzok("sz4");
        assertTrue(konyv.getSzerzok().size() > szerzok.size());
    }

    @Test
    void testEgyformak(){
        Konyv k1 = new Konyv("sz", "cim1", 1000,1978);
        k1.setAr(2000);
        k1.setKiadasiEv(2000);
        Konyv k2 = new Konyv("sz", "cim1", 1000,1978);
        assertEquals(k1, k2);
    }

    @Test
    void testRendezesCim(){
        Konyv k1 = new Konyv("aaa", "acim1", 1001,2001);
        Konyv k3 = new Konyv("ccc", "ccim3", 1003,2003);
        Konyv k4 = new Konyv("xxx", "xcim4", 1004,2004);
        Konyv k2 = new Konyv("bbb", "bcim2", 1002,2002);
        TreeSet<Konyv> rendezett = new TreeSet<>(Konyv.rendezCim());
        rendezett.add(k1);
        rendezett.add(k2);
        rendezett.add(k3);
        rendezett.add(k4);

        Konyv k;
        k = new Konyv("www", "ac", 1001,2001);
        assertEquals(rendezett.ceiling(k), k1);
        k = new Konyv("www", "bc", 1001,2001);
        assertEquals(rendezett.ceiling(k), k2);
        k = new Konyv("www", "cc", 1001,2001);
        assertEquals(rendezett.ceiling(k), k3);
        k = new Konyv("www", "xc", 1001,2001);
        assertEquals(rendezett.ceiling(k), k4);
    }
//
//    @Test
//    void testRendezesAr(){
//        Konyv k0 = new Konyv("aaa", "acim1", 1000,2001);
//        Konyv k1 = new Konyv("aaa", "acim1", 1001,2001);
//        Konyv k4 = new Konyv("ccc", "ccim3", 1003,2003);
//        Konyv k3 = new Konyv("xxx", "xcim4", 1004,2004);
//        Konyv k2 = new Konyv("bbb", "bcim2", 1002,2002);
//        List<Konyv> konyvek = Arrays.asList(k0, k1, k2, k3, k4);
//        Collections.shuffle(konyvek);
//
//        konyvek.sort(Konyv.rendezAr());
//        assertEquals(1000, konyvek.get(0).getAr());
//        assertEquals(1001, konyvek.get(1).getAr());
//        assertEquals(1002, konyvek.get(2).getAr());
//        assertEquals(1003, konyvek.get(3).getAr());
//        assertEquals(1004, konyvek.get(4).getAr());
//    }
//
//    @Test
//    void testRendezesAlapErtElsoSzerzore(){
//        List<String>szerzok;
//
//        szerzok = List.of("aaa", "xxx");
//        Konyv k0 = new Konyv(szerzok, "cim0", 1000,1978);
//
//        szerzok = List.of("bbb", "ccc");
//        Konyv k1 = new Konyv(szerzok, "cim1", 1000,1978);
//
//        List<Konyv> konyvek = Arrays.asList(k0,k1);
//        Collections.shuffle(konyvek);
//
//        Collections.sort(konyvek);
//
//        assertEquals(k0, konyvek.get(0));
//        assertEquals(k1, konyvek.get(1));
//    }
}