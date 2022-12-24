import java.io.*;
import java.nio.IntBuffer;
import static org.bytedeco.javacpp.opencv_core.CV_32SC1;
import static org.bytedeco.javacpp.opencv_core.CV_8UC1;
import static org.bytedeco.javacpp.opencv_face.createFisherFaceRecognizer;
import static org.bytedeco.javacpp.opencv_face.createEigenFaceRecognizer;
import static org.bytedeco.javacpp.opencv_face.createLBPHFaceRecognizer;

import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.opencv_face.FaceRecognizer;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_video.*;
import org.bytedeco.javacpp.opencv_videoio.CvCapture;

import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;

import static org.bytedeco.javacpp.opencv_highgui.cvShowImage;
import static org.bytedeco.javacpp.opencv_highgui.imshow;

import static org.bytedeco.javacpp.opencv_imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;

public class KisiBul {
    int predictedlabel;
    public void KameraAc(){
        int predictedlabel;
        opencv_videoio.VideoCapture camera = new opencv_videoio.VideoCapture(0);

        // Kamerayı açıp açmadığını kontrol et
        if(!camera.isOpened()){
            System.out.println("Kamera açılamadı");
            return;
        }



        // Görüntüyü almak için kullanılacak değişken
        opencv_core.Mat frame = new opencv_core.Mat();

        // Görüntüyü ekranda göstermek için pencere oluştur
        opencv_highgui.namedWindow("Live Camera Stream", opencv_highgui.WINDOW_AUTOSIZE);
        while(true){
            camera.read(frame);
            opencv_highgui.imshow("Live Camera Stream", frame);
            opencv_highgui.waitKey(300);
        }

    }
    public void DizinleriKaydet(){
        //Eğitim için kullanacağım veri setinin dizini
        String trainingDir = "C:/Users/alios/Desktop/eth/Faces/";
        //Eşleştirme için kullanacağım diğer yüz
        Mat testImage = imread("captured_image.jpg",
                CV_LOAD_IMAGE_GRAYSCALE);
        /*Mat testImage = imread("C:/Users/alios/Desktop/eth/testt/res3.png",
                CV_LOAD_IMAGE_GRAYSCALE);*/

        File root = new File(trainingDir);
        FilenameFilter imgFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                name = name.toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".pgm") ||
                        name.endsWith(".png");
            }
        };
        File[] imageFiles = root.listFiles(imgFilter);
        MatVector images = new MatVector(imageFiles.length);
        Mat labels = new Mat(imageFiles.length, 1, CV_32SC1);
        IntBuffer labelsBuf = labels.createBuffer();
        int counter = 0;
        for (File image : imageFiles) {
            Mat img = imread(image.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
            int label = Integer.parseInt(image.getName().split("\\-")[0]);
            System.out.println("Eğitilen Yüz: "+label);
            images.put(counter, img);
            labelsBuf.put(counter, label);
            counter++;

        }
        //FaceRecognizer faceRecognizer = createEigenFaceRecognizer();
        //FaceRecognizer faceRecognizer = createFisherFaceRecognizer();
        FaceRecognizer faceRecognizer = createLBPHFaceRecognizer();
        faceRecognizer.train(images, labels);
    }
    public void KisiyiBul(){
        opencv_videoio.VideoCapture camera = new opencv_videoio.VideoCapture(0);

        // Kamerayı açıp açmadığını kontrol et
        if(!camera.isOpened()){
            System.out.println("Kamera açılamadı");
            return;
        }



        // Görüntüyü almak için kullanılacak değişken
        opencv_core.Mat frame = new opencv_core.Mat();

        // Görüntüyü ekranda göstermek için pencere oluştur
        opencv_highgui.namedWindow("Live Camera Stream", opencv_highgui.WINDOW_AUTOSIZE);



        // Pencereyi güncellemeyi döngü içinde yap
        while (true) {
            // Görüntüyü al
            camera.read(frame);


            opencv_imgcodecs.imwrite("captured_image.jpg", frame);
            Mat kaydet = imread("captured_image.jpg",
                    CV_LOAD_IMAGE_GRAYSCALE);
            opencv_highgui.imshow("Live Camera Stream", frame);


            //Eğitim için kullanacağım veri setinin dizini
            String trainingDir = "C:\\Users\\alios\\Desktop\\OOP\\Faces";
            //Eşleştirme için kullanacağım diğer yüz
            Mat testImage = imread("captured_image.jpg",
                    CV_LOAD_IMAGE_GRAYSCALE);
        /*Mat testImage = imread("C:/Users/alios/Desktop/eth/testt/res3.png",
                CV_LOAD_IMAGE_GRAYSCALE);*/

            File root = new File(trainingDir);
            FilenameFilter imgFilter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    name = name.toLowerCase();
                    return name.endsWith(".jpg") || name.endsWith(".pgm") ||
                            name.endsWith(".png");
                }
            };
            File[] imageFiles = root.listFiles(imgFilter);
            MatVector images = new MatVector(imageFiles.length);
            Mat labels = new Mat(imageFiles.length, 1, CV_32SC1);
            IntBuffer labelsBuf = labels.createBuffer();
            int counter = 0;
            for (File image : imageFiles) {
                Mat img = imread(image.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
                int label = Integer.parseInt(image.getName().split("\\-")[0]);
                System.out.println("Eğitilen Yüz: "+label);
                images.put(counter, img);
                labelsBuf.put(counter, label);
                counter++;

            }

            FaceRecognizer faceRecognizer = createLBPHFaceRecognizer();
            faceRecognizer.train(images, labels);


            opencv_highgui.waitKey(300);
            long predictedLabel = faceRecognizer.predict(kaydet);
            faceRecognizer.predict(kaydet);
            System.out.println("Bulunan Yüz ID: " + predictedLabel);
            cvWaitKey(0);
            System.out.println("Numaralı ogrenci derse katilmistir : "+predictedLabel);





            try {
                // Dosya adını verin
                File file = new File("myfile.txt");

                // Dosya yoksa oluşturun
                if (!file.exists()) {
                    file.createNewFile();
                }


                // Dosyaya eklemek istediğiniz satırı verin
                String content = " "+predictedLabel;

                // Dosyayı okuma/yazma modunda açın
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);

                // Satır ekleyin
                bw.write(content);
                bw.newLine();

                // Değişiklikleri kaydedin ve dosyayı kapatın
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }




            // Görüntüyü güncelleme hızını belirle (ms cinsinden)
            opencv_highgui.waitKey(300);
            opencv_highgui.destroyWindow("Live Camera Stream");

            camera.release();
            break;
        }
    }

    public long Kim(){

        return predictedlabel;
    }

}
