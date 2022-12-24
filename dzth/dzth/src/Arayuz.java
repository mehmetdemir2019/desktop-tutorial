
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;


public class Arayuz extends JFrame implements ActionListener {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton ogrenciGosterButton;

    private JButton kameratiAcButton;


    private Object ogrenciEkleButton;

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

         JButton ogrenciEkleButton;


            // Önceki kodlar...



        kameratiAcButton = new JButton("Kamerayı Aç");
        kameratiAcButton.addActionListener(this);
        add(kameratiAcButton);







        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {
        Object kameratiAcButton = new Object();
        Object OgrenciTarat = new Object();
        if (e.getSource() == ogrenciGosterButton) {
            OgrenciGoster ogrenciGoster = new OgrenciGoster();
            ogrenciGoster.goster(textArea1, textArea2);



        }

                      else if (e.getSource() == ogrenciEkleButton) {
            KisiBul kisibul = new KisiBul();
            kisibul.KameraAc();
                  /* String numara = JOptionPane.showInputDialog("Öğrenci Numarası:");
                  String ad = JOptionPane.showInputDialog("Öğrenci Adı:");
                  String soyad = JOptionPane.showInputDialog("Öğrenci Soyadı:");

               YeniKisi yeniKisi = new YeniKisi(Integer.parseInt(numara), ad, soyad);
                  yeniKisi.dosyayaYaz("veriler2.txt");
                   textArea2.append(numara + " " + ad + " " + soyad + "\n");*/
                }


    /*else if (e.getSource() == kameratiAcButton) {
        // Kamera sınıfını çağırın ve tüz tanıma işlemini yapın
            KisiBul kisibul = new KisiBul();
            kisibul.KameraAc();

    }*/
        if (e.getSource() == kameratiAcButton) {
            KisiBul kisibul = new KisiBul();
            kisibul.KameraAc();
        }






    }
    }







