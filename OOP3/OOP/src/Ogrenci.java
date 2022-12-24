public class Ogrenci extends Kisi {
    public Ogrenci(long numara) {
        super(numara);
    }


    public Ogrenci(long numara, String ad, String soyad) {
        super(numara, ad, soyad);
    }

    public void Geldi(){
        KisiBul kisibul =new KisiBul();
        System.out.println(kisibul.Kim()+"geldi");
    }
}