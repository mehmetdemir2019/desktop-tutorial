import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;


public class Main {
    public static void main(String[] args) {
        Arayuz arayuz = new Arayuz();
        DosyaOku dosyaOku = new DosyaOku();
        ArrayList<Kisi> veriler = dosyaOku.getVeriler();
        ArrayList<Kisi2> veriler2 = dosyaOku.getVeriler2();

        for (Kisi kisi : veriler) {
            if (kisi instanceof Ogrenci) {
                System.out.println(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + " (öğrenci)");
            } else {
                System.out.println(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad());
            }
        }

        for (Kisi kisi : veriler) {
            boolean varMi = false;
            for (Kisi2 kisi2 : veriler2) {
                if (kisi.getNumara() == kisi2.getNumara()) {
                    varMi = true;
                    break;
                }
            }
            if (!varMi) {
                if (kisi instanceof Ogrenci) {
                    System.out.println(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + " (öğrenci)");
                } else {
                    System.out.println(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad());
                }
            }
        }
    }
}
