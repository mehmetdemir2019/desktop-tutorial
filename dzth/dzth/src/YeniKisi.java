
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class YeniKisi {


    private int numara;
    private String ad;
    private String soyad;




        public void ekle(JTextArea textArea2) {
            String ad = JOptionPane.showInputDialog("Eklenecek öğrencinin adını girin:");
            textArea2.append(ad + "\n");
        }


    public YeniKisi(int numara, String ad, String soyad) {
        this.numara = numara;
        this.ad = ad;
        this.soyad = soyad;
    }

    public void dosyayaYaz(String dosyaAdi) {
        try {
            FileWriter fw = new FileWriter(dosyaAdi, true);
            fw.append(numara + "," + ad + "," + soyad + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Dosya yazılırken hata oluştu!");
        }
    }
}

