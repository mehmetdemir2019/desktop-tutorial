import javax.swing.*;

public class OgrenciEkle {
    public void ekle(JTextArea textArea2) {
        String ad = JOptionPane.showInputDialog("Eklenecek öğrencinin adını girin:");
        textArea2.append(ad + "\n");
    }
}