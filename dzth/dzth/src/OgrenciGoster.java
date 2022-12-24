import javax.swing.*;
import java.util.ArrayList;

public class OgrenciGoster {
    public void goster(JTextArea textArea1, JTextArea textArea2) {
        DosyaOku dosyaOku = new DosyaOku();
        ArrayList<Kisi> veriler = dosyaOku.getVeriler();
        ArrayList<Kisi2> veriler2 = dosyaOku.getVeriler2();

        for (Kisi kisi : veriler) {
            if (kisi instanceof Ogrenci) {
                textArea1.append(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + " (öğrenci)\n");
            } else {
                textArea1.append(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + "\n");
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
                    textArea2.append(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + " (öğrenci)\n");
                } else {
                    textArea2.append(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + "\n");
                }
            }


        }
    }
}