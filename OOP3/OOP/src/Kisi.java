abstract class Kisi {
    private long numara;
    private String ad;
    private String soyad;
    private int geldi;

    public Kisi(long numara) {

    }

    void geldsfi(){};






    public Kisi(long numara, String ad, String soyad) {
        this.numara = numara;
        this.ad = ad;
        this.soyad = soyad;
    }

    public int getGeldi() {
        return geldi;
    }

    public long getNumara() {
        return numara;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }
}