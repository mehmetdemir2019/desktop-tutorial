import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DosyaOku {
    private ArrayList<Kisi> veriler;
    private ArrayList<Kisi2> veriler2;

    public DosyaOku() {
        veriler = new ArrayList<Kisi>();
        veriler2 = new ArrayList<Kisi2>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Mehmet_Demir\\OneDrive\\Masaüstü\\veriler.txt"));
            String satir = br.readLine();
            while (satir != null) {
                String[] parcalar = satir.split(",");
                long numara = Long.parseLong(parcalar[0]);
                String ad = parcalar[1];
                String soyad = parcalar[2];
                Kisi kisi = new Kisi(numara, ad, soyad);
                veriler.add(kisi);
                satir = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Dosya okunurken hata oluştu!");
        }
        try {
            BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Mehmet_Demir\\OneDrive\\Masaüstü\\veriler2.txt"));
            String satir2 = br2.readLine();
            while (satir2 != null) {
                String[] parcalar2 = satir2.split(",");
                Long numara2 = Long.parseLong(parcalar2[0]);

                Kisi2 kisi2 = new Kisi2(numara2);
                veriler2.add(kisi2);
                satir2 = br2.readLine();
            }
            br2.close();
        } catch (Exception e) {
            System.out.println("Dosya okunurken hata oluştu!");
        }
    }

    public ArrayList<Kisi> getVeriler() {
        return veriler;
    }

    public ArrayList<Kisi2> getVeriler2() {
        return veriler2;
    }
}
