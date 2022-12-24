import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Arayuz extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final JTextArea textArea1;
    private final JTextArea textArea2;
    private final JButton ogrenciGosterButton;
    private final JButton KameraAc;
    private final JButton OgrenciTani;
    private final JButton OgrenciTarat;
    private final JButton gelmeyen;

    public Arayuz() {


        setLayout(new FlowLayout());

        textArea1 = new JTextArea(20, 30);
        textArea1.append("Tam Öğrenci Listesi:\n");
        add(textArea1);

        textArea2 = new JTextArea(20, 30);
        textArea2.append("Gelmeyen Öğrenci Listesi:\n");
        add(textArea2);

        ogrenciGosterButton = new JButton("Öğrencileri Göster");
        ogrenciGosterButton.addActionListener(this);
        add(ogrenciGosterButton);

        gelmeyen = new JButton("Gelmeyen öğrencileri Göster");
        gelmeyen.addActionListener(this);
        add(gelmeyen);

        JButton ogrenciEkleButton;

        KameraAc = new JButton("KameraAÇ");
        KameraAc.addActionListener(this);
        add(KameraAc);


        OgrenciTarat = new JButton("Öğrencileri Tarat");
        OgrenciTarat.addActionListener(this);
        add(OgrenciTarat);


        OgrenciTani = new JButton("Tanı");
        OgrenciTani.addActionListener(this);
        add(OgrenciTani);


        // Önceki kodlar...

        ogrenciEkleButton = new JButton("Öğrenci Ekle");
        ogrenciEkleButton.addActionListener(this);
        add(ogrenciEkleButton);


        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


    public void goster(JTextArea textArea1, JTextArea textArea2) {
        DosyaOku dosyaOku = new DosyaOku();
        ArrayList<Ogrenci> veriler = dosyaOku.getVeriler();
        ArrayList gelenogrenci = dosyaOku.Gelenogr();

        for (Kisi kisi : veriler) {
            if (kisi instanceof Ogrenci) {
                textArea1.append(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + " (öğrenci)\n");
            } else {
                textArea1.append(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + "\n");
            }
        }

        Numara numara = new Numara();
        for (Kisi kisi : veriler) {
            String gelennumara = "" + kisi.getNumara();
            if (numara.NumaraKarsilas(gelennumara)) {
                    textArea2.append(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + " (öğrenci)\n");



            }
        }





    }

    public void actionPerformed (ActionEvent e){
        if (e.getSource() == ogrenciGosterButton) {
            DosyaOku dosyaOku = new DosyaOku();
            ArrayList<Ogrenci> tumsinif = dosyaOku.getVeriler();


            for (Ogrenci kisi : tumsinif) {
                if (kisi instanceof Ogrenci) {
                    textArea1.append(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + " (öğrenci)\n");
                } else {
                    textArea1.append(kisi.getNumara() + " " + kisi.getAd() + " " + kisi.getSoyad() + "\n");
                }
            }

        }

        if (e.getSource() == gelmeyen){
            DosyaOku dosyaOku = new DosyaOku();
            ArrayList<Ogrenci> tumsinif = dosyaOku.getVeriler();
            for (Ogrenci kisi : tumsinif){

            }
        }

        if (e.getSource() == OgrenciTarat) {
            KisiBul kisibul = new KisiBul();
            kisibul.KisiyiBul();
        }
    }
}




