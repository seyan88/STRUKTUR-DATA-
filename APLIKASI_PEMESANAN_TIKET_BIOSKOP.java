
package aplikasi_pemesanan_tiket_bioskop;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Stack;

public class APLIKASI_PEMESANAN_TIKET_BIOSKOP {

    
    private static String cariKursi(String[][] kursiArray, String nomorKursi) {
    for (int i = 0; i < kursiArray.length; i++) {
        for (int j = 0; j < kursiArray[i].length; j++) {
            if (kursiArray[i][j].equalsIgnoreCase(nomorKursi)) {
                return nomorKursi;
            }
        }
    }
    return null;
}
    
    
    
    static void menampilkankursi (String tampil){
            
            System.out.println("                SILAHKAN PILIH KURSI YANG ANDA INGINKAN   ");
            
            for (int i=0; i<kursikiri.length; i++){
                 System.out.println("        "+kursikiri[i][0]+" "+" "+kursikiri[i][1]+" "+" "+kursikiri[i][2]+" "+" "+kursikiri[i][3]+" "+" "+kursikiri[i][4]+"                   "+
                                    " "+kursikanan[i][0]+" "+" "+kursikanan[i][1]+" "+" "+kursikanan[i][2]+" "+" "+kursikanan[i][3]+" "+" "+kursikanan[i][4]+" ");
                 
          
            }
            System.out.println("   ");
            
        }
        
        private static void tampilkankursikiri(String[][] kursikiri, boolean[][] kursiTerisi) {
        System.out.println("Layout Kursi Bioskop:");
        for (int i = 0; i < kursikiri.length; i++) {
            for (int j = 0; j < kursikiri[i].length; j++) {
                if (kursiTerisi[i][j]) {
                    System.out.print("X ");
                } else {
                    System.out.print(" " + kursikiri[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
        
        
        
        private static void tampilkankursikanan(String[][] kursikanan, boolean[][] kursiterisi2) {
            System.out.println("Layout Kursi Bioskop:");
                for (int i = 0; i < kursikanan.length; i++) {
                for (int j = 0; j < kursikanan[i].length; j++) {
                    if (kursiterisi2[i][j]) {
                        System.out.print("X ");
                    } else {
                        System.out.print(" " +kursikanan[i][j] + " ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

         private static void tampilkanJamTayang(String[] jamTayang) {
        for (int i = 0; i < jamTayang.length; i++) {
            System.out.println("||    "+(i + 1) + ". " + jamTayang[i]+"       ||");
        }
    }

        private static void tandaiKursiDipesan(String[][] kursiArray, String nomorKursi) {
        for (int i = 0; i < kursiArray.length; i++) {
            for (int j = 0; j < kursiArray[i].length; j++) {
                if (kursiArray[i][j].equalsIgnoreCase(nomorKursi)) {
                    // Tandai kursi sebagai sudah dipesan
                    kursiArray[i][j] = "XX";
                    return;
                }
            }
        }
    }

     /*Spesifikasi:

            😒Peserta ( memakai arrayrecord untuk menentukan batasana penonton )

            😒Film ✅ ( memakai record untuk mendeklarasikan film nya )

            😒Kursi dengan memilih kursi yang ada di bioskop 

            😒Transaksi ( linked list record, priority queue,  dan queue )

            😒Riwayat Transaksi ( hanya tampilan dari gabungan semua spesifikasimya)
            */
    //Record deklarasi
    public record Film (String namafilm, String jam1, String jam2, String jam3,String jam4, String jam5, int harga){} //✅
    public record pengunjung(String nama, String tiket, int notiket, double harga){}
    
    
    //bookingan    
    public record pemesanan (String nama, String tiket, String film, String jam , double harga, int bayar, double kembalian){}
    public record pesanfilm (String  film  ){}
    public record pesanjam (String jam){}
    public record kursi (String kursi){}
    
    
    // ARRAYS DUA DIMENSI
    
    static String [][] kursikiri ={
        {"A1","A2","A3","A4","A5"},
        {"B1","B2","B3","B4","B5"},
        {"C1","C2","C3","C4","C5"},
        {"D1","D2","D3","D4","D5"},
        {"E1","E2","E3","E4","E5"},
    };
    
    static String [][] kursikanan ={
        {"F1","F2","F3","F4","F5"},
        {"G1","G2","G3","G4","G5"},
        {"H1","H2","H3","H4","H5"},
        {"I1","I2","I3","I4","I5"},
        {"J1","J2","J3","J4","J5"},
    };
    
    
    
    
    
    public static void main(String[] args) {
       
        // Inisialisasi peserta penonton film
                    ArrayList<pengunjung> listpembeli = new ArrayList<>();
                    listpembeli.add(new pengunjung("juki","Vip",1,0.5));
                    listpembeli.add(new pengunjung("Dadang","Reguler",3,1));
                    listpembeli.add(new pengunjung("mariah","Reguler",3,1));
                    listpembeli.add(new pengunjung("Miki","Couple",2,0.7));
                    listpembeli.add(new pengunjung("karin","Vip",1,0.5));
                    
                    // Memasukan peserta ke queue menggunakan priority queue
                    PriorityQueue<pengunjung> antrianp = new PriorityQueue<>(Comparator.comparingInt(pengunjung::notiket));
                    for ( pengunjung  list : listpembeli ){
                        antrianp.add(list);                
                    }
        
                    //memasukkan informasi ke riwayat
                    List<pemesanan> riwayat = new ArrayList<>();
                    while (!antrianp.isEmpty()){
                        pengunjung pembeli = antrianp.poll();
                        
                        // PENGECEKAN UNTUK KURSI ( APABILA KURSINYA TERISI MAKA NILAINYA TRUE, SEDANGKAN JIKA TIDAK TERISI NILAINYA FALSE )
                        boolean[][] kursiterisi = new boolean[kursikiri.length][kursikiri[0].length];
                        
                        String[][] dataBooking1 = new String[kursikiri.length][kursikiri[0].length];
                        
                        // PENGECEKAN UNTUK KURSI ( APABILA KURSINYA TERISI MAKA NILAINYA TRUE, SEDANGKAN JIKA TIDAK TERISI NILAINYA FALSE )
                        boolean[][] kursiterisi2 = new boolean[kursikanan.length][kursikanan[0].length];
                        
                        String[][] dataBooking2 = new String[kursikanan.length][kursikanan[0].length];
                        
                        Scanner input = new Scanner(System.in);
                        
                        // tempat penyimpanan data 
                        LinkedList<pesanfilm> pfilm = new LinkedList<>();
                        LinkedList<pesanjam> pjam = new LinkedList<>();
                        LinkedList<kursi> pkursi = new LinkedList<>();
                        
                        // Inisialisasi arraylist record untuk film
                        Film[] filmList = {
                new Film("SIKSA NERAKA", "10:00", "13:00", "16:00", "19:00", "22:00", 35000),
                new Film("172 DAYS", "11:00", "14:00", "17:00", "20:00", "23:00", 35000),
                new Film("ANCIKA", "12:00", "15:00", "18:00", "21:00", "00:00", 35000)
                    };
                    
                    //operasi dari setiap peserta
                    System.out.println("=========================================================");
                    System.out.println("===================== HEDON BIOSKOP =====================");
                    System.out.println("                    Nama        : "+ pembeli.nama()+"                ");
                    System.out.println("                    Tipe Tiket  : " + pembeli.tiket()+"                 ");
                    System.out.println("=========================================================");

                    System.out.println("");
                    System.out.println("=========================================================");
                    System.out.println("      SILAHKAN UNTUK MEMILIH FILM TERLEBIH DAHULU");
                    
                    // Variable untuk menyimpan pilihan film dan jam tayang
                    int pilihanFilm = -1;
                    int pilihanJam = -1;

                        System.out.println("=======================DAFTAR FILM=======================");    
                    for (int i = 0; i < filmList.length; i++) {
                        System.out.println("                    " + (i + 1) + ". " + filmList[i].namafilm()+"        ");
                    }
                        System.out.println("=========================================================");
                        System.out.println("");
        
                // Input pemilihan film
                Scanner scanner = new Scanner(System.in);
                do {
                System.out.print("Pilih nomor film (1-" + filmList.length + "): ");
                pilihanFilm = scanner.nextInt();
                } while (pilihanFilm < 1 || pilihanFilm > filmList.length);

                System.out.println("Anda memilih film: " + filmList[pilihanFilm - 1].namafilm());
                pesanfilm bookingfilm = new pesanfilm(filmList[pilihanFilm - 1].namafilm());
                pfilm.add(bookingfilm);
                
                // Tampilkan daftar jam tayang untuk film yang dipilih
                System.out.println("Jam Tayang untuk " + filmList[pilihanFilm - 1].namafilm() + ":");
                String[] jamTayang = {
                filmList[pilihanFilm - 1].jam1(), filmList[pilihanFilm - 1].jam2(),
                filmList[pilihanFilm - 1].jam3(), filmList[pilihanFilm - 1].jam4(),
                filmList[pilihanFilm - 1].jam5()
                };
                tampilkanJamTayang(jamTayang);
                    
                    
        // Input pemilihan jam tayang
        do {
            System.out.print("Pilih nomor jam tayang (1-" + jamTayang.length + "): ");
            
            pilihanJam = scanner.nextInt();
        } while (pilihanJam < 1 || pilihanJam > jamTayang.length);

        System.out.println("Anda memilih jam tayang: " + jamTayang[pilihanJam - 1]);
                        System.out.println("");
                    
        pesanjam bookingjam = new pesanjam(jamTayang[pilihanJam - 1]);
        pjam.add(bookingjam);
        
        
        
                menampilkankursi (" SILAHKAN UNTUK MEMILIH KURSI YANG ANDA INGINKAN  ");
                
                System.out.print("    SILAHKAN PILIH JAJARAN MANA YANG INGIN ANDA PESAN (KIRI / KANAN)? : " );
                
                String jajaran = input.next().toUpperCase();
                
                        System.out.println("");
                
                switch (jajaran){
                    case ("KIRI"):
                        
                        
                        System.out.print(" SILAHKAN MASSUKAN JUMLAH KURSI YANG INGIN ANDA PESAN: ");
                        int jml =input.nextInt();
                            System.out.println("");
                        if (jml < 2){
                            
                            tampilkankursikiri(kursikiri, kursiterisi);
                            
                            
                            // Input nomor kursi yang ingin dicari
                            System.out.print("Masukkan nomor kursi yang ingin Anda cari: ");
                            
                            String nomorKursiDicari = input.next().toUpperCase();

                            // Cari kursi di kursi kiri
                            String hasilPencarianKiri = cariKursi(kursikiri, nomorKursiDicari);
                            if (hasilPencarianKiri != null) {
                            System.out.println("Kursi " + nomorKursiDicari + " ditemukan di jajaran kursi kiri.");
                            // untuk menandai
                            tandaiKursiDipesan(kursikiri, nomorKursiDicari);
                            } 
                                    
                                    //linkedlist kuris pertama
                                    kursi bookingkursi = new kursi(hasilPencarianKiri);
                                    pkursi.add (bookingkursi);
        
        
                            //TRANSAKSI
                            
                            
                            System.out.println("================== BIOSKOP HEDONPLANET ======================== ");
                
                            System.out.println("Film yang di pesan      : "+filmList[pilihanFilm - 1].namafilm());
                             
                            System.out.println("=============================================================");
                            System.out.println("jam tayangnya           : "+jamTayang[pilihanJam - 1]);
                            
                            System.out.println("=============================================================");
                            for ( kursi kursik : pkursi){
                            System.out.print("kursi yang di booking   : "+kursik.kursi() );
                            }
                            System.out.println("");
                            System.out.println("=============================================================");
                            System.out.println("Total harga yang harus di bayar: " +(filmList[jml - 1].harga*jml/pembeli.harga()) );
                            System.out.println("");
                            
                            boolean ulang1 = true;
                            
                            while (ulang1){
                            System.out.print("MASUKAN NOMINAL UANG YANG DI BAYAR: ");
                            int bayar = input.nextInt();
                            
                            
                            if (bayar <filmList[pilihanFilm - 1].harga*jml/pembeli.harga() ){
                                System.out.println("UANG YANG ANDA MASSUKKAN KURANG");
                                
                            }else {
                                double total = filmList[jml - 1].harga*jml/pembeli.harga();
                                double jumlah =  bayar - total;
                                System.out.println("PEMBAYARANN : "+total+"-"+bayar );
                                System.out.println("CASH        :"+jumlah);
                                
                                
                                
                                
                                System.out.println("==============================");
                                System.out.println("         SELAMAT MENONTON");
                                System.out.println("==============================");
                                System.out.println("");
                                
                                pemesanan riwayatmasuk =new pemesanan(pembeli.nama(),
                                                                       pembeli.tiket(),
                                                                       filmList[pilihanFilm - 1].namafilm(),
                                                                       jamTayang[pilihanJam - 1],
                                                                       
                                                                       total,
                                                                       bayar,
                                                                       jumlah);
                                riwayat.add(riwayatmasuk);
                                
                                
                                System.out.println("=====================================================");
                                System.out.println("                    RIWAYAT TRANSAKSI                ");
                                System.out.println("=====================================================");
                                for (pemesanan riwayat1 : riwayat){
                                    System.out.println("Nama Pembeli        : "+ riwayat1.nama());
                                    System.out.println("Tipe Tiket          : "+ riwayat1.tiket());
                                    System.out.println("Nama Film           : "+ riwayat1.film());
                                    System.out.println("Jam Tayang          : "+ riwayat1.jam());
                                }
                                    for ( kursi kursik1 : pkursi){
                                    System.out.println("Jam Tayang          : "+ kursik1.kursi()+" ");
                                    }
                                    for (pemesanan riwayat2 : riwayat){
                                    System.out.println("Total Harga         : "+ riwayat2.harga());
                                    System.out.println("Jumlah Pembayaran   : "+ riwayat2.bayar());
                                    System.out.println("Kembalian           : "+ riwayat2.kembalian());
                                    System.out.println("=================================================");
                                    System.out.println("        SELAMAT MENONTON DI HEDON BIOSKOP        ");
                                    System.out.println("=================================================");
                                }
                                    
                                    riwayat.removeAll(riwayat);
                                break;    
                                
                            }
                                                                
                                    

                        }
                            
                            
                            
                            
                        }else if (jml < 25){
                            tampilkankursikiri(kursikiri, kursiterisi);
                            
                            for (int k = 0; k < jml; k++) {
                                // Input nomor kursi yang ingin dicari
                            System.out.print("Masukkan nomor kursi yang ingin Anda cari: ");
                            String nomorKursiDicari = input.next().toUpperCase();

                            String hasilPencarianKiri = cariKursi(kursikiri, nomorKursiDicari);
                            if (hasilPencarianKiri != null) {
                            System.out.println("KURSI ANDA: " + nomorKursiDicari + " ");
                            System.out.println("");
                            // untuk menandai
                            tandaiKursiDipesan(kursikiri, nomorKursiDicari);
                            }
                                    
                                    //linkedlist kuris pertama
                                    kursi bookingkursi = new kursi(hasilPencarianKiri);
                                    pkursi.add (bookingkursi);
                                        
                                       
                                    }
                                
                            // TRANSAKSI
                            
                            
                            System.out.println("================== BIOSKOP HEDONPLANET ======================== ");
                
                            System.out.println("Film yang di pesan      : "+filmList[pilihanFilm - 1].namafilm());
                             
                            System.out.println("=============================================================");
                            System.out.println("jam tayangnya           : "+jamTayang[pilihanJam - 1]);
                            
                            System.out.println("=============================================================");
                            for ( kursi kursik : pkursi){
                            System.out.println("kursi yang di booking   : "+kursik.kursi() );
                            }
                            
                            System.out.println("");
                            System.out.println("=============================================================");
                            System.out.println("Total harga yang harus di bayar: " +(filmList[jml - 1].harga*jml/pembeli.harga()) );
                            System.out.println("");
                            
                            boolean ulang1 = true;
                            
                            while (ulang1){
                            System.out.print("MASUKAN NOMINAL UANG YANG DI BAYAR: ");
                            int bayar = input.nextInt();
                            
                            
                            if (bayar <filmList[pilihanFilm - 1].harga*jml/pembeli.harga() ){
                                System.out.println("UANG YANG ANDA MASSUKKAN KURANG");
                                
                            }else {
                                double total = filmList[jml - 1].harga*jml/pembeli.harga();
                                double jumlah =  bayar - total;
                                System.out.println("PEMBAYARANN : "+total+"-"+bayar );
                                System.out.println("CASH        :"+jumlah);
                                System.out.println("==============================");
                                System.out.println("         SELAMAT MENONTON");
                                System.out.println("==============================");
                                System.out.println("");
                                
                                
//                                kursi kursik = pkursi.poll();
                                pemesanan riwayatmasuk =new pemesanan(pembeli.nama(),
                                                                       pembeli.tiket(),
                                                                       filmList[pilihanFilm - 1].namafilm(),
                                                                       jamTayang[pilihanJam - 1],
                                                                       
                                                                       total,
                                                                       bayar,
                                                                       jumlah);
                                riwayat.add(riwayatmasuk);
                                
                                
                                System.out.println("=====================================================");
                                System.out.println("                    RIWAYAT TRANSAKSI                ");
                                System.out.println("=====================================================");
                                for (pemesanan riwayat1 : riwayat){
                                    System.out.println("Nama Pembeli        : "+ riwayat1.nama());
                                    System.out.println("Tipe Tiket          : "+ riwayat1.tiket());
                                    System.out.println("Nama Film           : "+ riwayat1.film());
                                    System.out.println("Jam Tayang          : "+ riwayat1.jam()+" ");
                                    }
                                for ( kursi kursik : pkursi){
                                    System.out.println("Jam Tayang          : "+ kursik.kursi()+" ");
                                    }
                                    for (pemesanan riwayat1 : riwayat){
                                    
                                    System.out.println("Total Harga         : "+ riwayat1.harga());
                                    System.out.println("Jumlah Pembayaran   : "+ riwayat1.bayar());
                                    System.out.println("Kembalian           : "+ riwayat1.kembalian());
                                    System.out.println("=================================================");
                                    System.out.println("        SELAMAT MENONTON DI HEDON BIOSKOP        ");
                                    System.out.println("=================================================");
                                }
                                     riwayat.removeAll(riwayat);
                                break;
                                
                                
                                
                                
                            }
                            
                        }
                            
                            
                            
                            
                            break;
                            
                            }else if (jml > 25){
                                System.out.println(" jumlah pesanan anda melebihi jumlah kursi yang tersedia ");
                                
                            }else{

                        
                        break;
                            }
                
                 tampilkankursikiri(kursikiri, kursiterisi);       
                        break;
                        
                    case ("KANAN"):
                        
                        
                        System.out.print(" SILAHKAN MASSUKAN JUMLAH KURSI YANG INGIN ANDA PESAN: ");
                        int jml2 =input.nextInt();
                            System.out.println("");
                        if (jml2 < 2){
                            
                            tampilkankursikiri(kursikanan, kursiterisi);
                            
                            
                            // Input nomor kursi yang ingin dicari
                            System.out.print("Masukkan nomor kursi yang ingin Anda cari: ");
                            
                            String nomorKursiDicari = input.next().toUpperCase();

                            // Cari kursi di kursi kiri
                            String hasilPencarianKiri = cariKursi(kursikanan, nomorKursiDicari);
                            if (hasilPencarianKiri != null) {
                            System.out.println("Kursi " + nomorKursiDicari + " ditemukan di jajaran kursi kiri.");
                            // untuk menandai
                            tandaiKursiDipesan(kursikanan, nomorKursiDicari);
                            } 
                                    
                                    //linkedlist kuris pertama
                                    kursi bookingkursi = new kursi(hasilPencarianKiri);
                                    pkursi.add (bookingkursi);
        
        
                            //TRANSAKSI
                            
                            
                            System.out.println("================== BIOSKOP HEDONPLANET ======================== ");
                
                            System.out.println("Film yang di pesan      : "+filmList[pilihanFilm - 1].namafilm());
                             
                            System.out.println("=============================================================");
                            System.out.println("jam tayangnya           : "+jamTayang[pilihanJam - 1]);
                            
                            System.out.println("=============================================================");
                            for ( kursi kursik : pkursi){
                            System.out.print("kursi yang di booking   : "+kursik.kursi() );
                            }
                            System.out.println("");
                            System.out.println("=============================================================");
                            System.out.println("Total harga yang harus di bayar: " +(filmList[jml2 - 1].harga*jml2/pembeli.harga()) );
                            System.out.println("");
                            
                            boolean ulang1 = true;
                            
                            while (ulang1){
                            System.out.print("MASUKAN NOMINAL UANG YANG DI BAYAR: ");
                            int bayar = input.nextInt();
                            
                            
                            if (bayar <filmList[pilihanFilm - 1].harga*jml2/pembeli.harga() ){
                                System.out.println("UANG YANG ANDA MASSUKKAN KURANG");
                                
                            }else {
                                double total = filmList[jml2 - 1].harga*jml2/pembeli.harga();
                                double jumlah =  bayar - total;
                                System.out.println("PEMBAYARANN : "+total+"-"+bayar );
                                System.out.println("CASH        :"+jumlah);
                                
                                
                                
                                
                                System.out.println("==============================");
                                System.out.println("         SELAMAT MENONTON");
                                System.out.println("==============================");
                                System.out.println("");
                                
                                pemesanan riwayatmasuk =new pemesanan(pembeli.nama(),
                                                                       pembeli.tiket(),
                                                                       filmList[pilihanFilm - 1].namafilm(),
                                                                       jamTayang[pilihanJam - 1],
                                                                       
                                                                       total,
                                                                       bayar,
                                                                       jumlah);
                                riwayat.add(riwayatmasuk);
                                
                                
                                System.out.println("=====================================================");
                                System.out.println("                    RIWAYAT TRANSAKSI                ");
                                System.out.println("=====================================================");
                                for (pemesanan riwayat1 : riwayat){
                                    System.out.println("Nama Pembeli        : "+ riwayat1.nama());
                                    System.out.println("Tipe Tiket          : "+ riwayat1.tiket());
                                    System.out.println("Nama Film           : "+ riwayat1.film());
                                    System.out.println("Jam Tayang          : "+ riwayat1.jam());
                                }
                                    for ( kursi kursik1 : pkursi){
                                    System.out.println("Jam Tayang          : "+ kursik1.kursi()+" ");
                                    }
                                    for (pemesanan riwayat2 : riwayat){
                                    System.out.println("Total Harga         : "+ riwayat2.harga());
                                    System.out.println("Jumlah Pembayaran   : "+ riwayat2.bayar());
                                    System.out.println("Kembalian           : "+ riwayat2.kembalian());
                                    System.out.println("=================================================");
                                    System.out.println("        SELAMAT MENONTON DI HEDON BIOSKOP        ");
                                    System.out.println("=================================================");
                                }
                                riwayat.removeAll(riwayat);
                                break;
                            }
                            
                        }
                            
                            
                        }else if (jml2<25){
                           tampilkankursikiri(kursikanan, kursiterisi);
                            
                            for (int k = 0; k < jml2; k++) {
                                // Input nomor kursi yang ingin dicari
                            System.out.print("Masukkan nomor kursi yang ingin Anda cari: ");
                            String nomorKursiDicari = input.next().toUpperCase();

                            String hasilPencarianKiri = cariKursi(kursikanan, nomorKursiDicari);
                            if (hasilPencarianKiri != null) {
                            System.out.println("KURSI ANDA: " + nomorKursiDicari + " ");
                            System.out.println("");
                            // untuk menandai
                            tandaiKursiDipesan(kursikanan, nomorKursiDicari);
                            }
                                    
                                    //linkedlist kuris pertama
                                    kursi bookingkursi = new kursi(hasilPencarianKiri);
                                    pkursi.add (bookingkursi);
                                        
                                       
                                    }
                                
                            // TRANSAKSI
                            
                            
                            System.out.println("================== BIOSKOP HEDONPLANET ======================== ");
                
                            System.out.println("Film yang di pesan      : "+filmList[pilihanFilm - 1].namafilm());
                             
                            System.out.println("=============================================================");
                            System.out.println("jam tayangnya           : "+jamTayang[pilihanJam - 1]);
                            
                            System.out.println("=============================================================");
                            for ( kursi kursik : pkursi){
                            System.out.println("kursi yang di booking   : "+kursik.kursi() );
                            }
                            
                            System.out.println("");
                            System.out.println("=============================================================");
                            System.out.println("Total harga yang harus di bayar: " +(filmList[jml2 - 1].harga*jml2/pembeli.harga()) );
                            System.out.println("");
                            
                            boolean ulang1 = true;
                            
                            while (ulang1){
                            System.out.print("MASUKAN NOMINAL UANG YANG DI BAYAR: ");
                            int bayar = input.nextInt();
                            
                            
                            if (bayar <filmList[pilihanFilm - 1].harga*jml2/pembeli.harga() ){
                                System.out.println("UANG YANG ANDA MASSUKKAN KURANG");
                                
                            }else {
                                double total = filmList[jml2 - 1].harga*jml2/pembeli.harga();
                                double jumlah =  bayar - total;
                                System.out.println("PEMBAYARANN : "+total+"-"+bayar );
                                System.out.println("CASH        :"+jumlah);
                                System.out.println("==============================");
                                System.out.println("         SELAMAT MENONTON");
                                System.out.println("==============================");
                                System.out.println("");
                                
                                
//                                kursi kursik = pkursi.poll();
                                pemesanan riwayatmasuk =new pemesanan(pembeli.nama(),
                                                                       pembeli.tiket(),
                                                                       filmList[pilihanFilm - 1].namafilm(),
                                                                       jamTayang[pilihanJam - 1],
                                                                       
                                                                       total,
                                                                       bayar,
                                                                       jumlah);
                                riwayat.add(riwayatmasuk);
                                
                                
                                System.out.println("=====================================================");
                                System.out.println("                    RIWAYAT TRANSAKSI                ");
                                System.out.println("=====================================================");
                                for (pemesanan riwayat1 : riwayat){
                                    System.out.println("Nama Pembeli        : "+ riwayat1.nama());
                                    System.out.println("Tipe Tiket          : "+ riwayat1.tiket());
                                    System.out.println("Nama Film           : "+ riwayat1.film());
                                    System.out.println("Jam Tayang          : "+ riwayat1.jam()+" ");
                                    }
                                for ( kursi kursik : pkursi){
                                    System.out.println("Jam Tayang          : "+ kursik.kursi()+" ");
                                    }
                                    for (pemesanan riwayat1 : riwayat){
                                    
                                    System.out.println("Total Harga         : "+ riwayat1.harga());
                                    System.out.println("Jumlah Pembayaran   : "+ riwayat1.bayar());
                                    System.out.println("Kembalian           : "+ riwayat1.kembalian());
                                    System.out.println("=================================================");
                                    System.out.println("        SELAMAT MENONTON DI HEDON BIOSKOP        ");
                                    System.out.println("=================================================");
                                    
                                }
                                riwayat.removeAll(riwayat);
                                break;
                                
                                
                                
                                
                            }
                            
                        }
                            
                            
                            
                            
                            break;
                            
                            }else if (jml2 > 25){
                            
                            System.out.println(" JUMLAH KURSI YANG ANDA MASUKKAN MELEBIHI DARI KURSI YANG TERSEDIA ");
                           
                            
                        }else{

                        
                        
                        break;
                            }
                        
                        tampilkankursikanan(kursikanan, kursiterisi2);
                        break;
                        
                    default:
                        System.out.println(" MAAF YANG ANDA MASUKAN TIDAK ADA ");
                        System.out.println(" SILAHKAN UNTUK MEMILIH KEMBALI");
                        break;
                    
                }
                
                
            
                 System.out.print("INGIN MELAKUKAN TRANSAKSI KEMBALI ? (Y/T): ");
                    System.out.print("");
                    String jawaban = input.next().toUpperCase();
                        if(jawaban.equalsIgnoreCase("Y")){
                            System.out.println(" SILAHKAN UNTUK MEMILIH KEMBALI ");
                            System.out.println("");
                            System.out.println("");
                           
                        }else{
                            System.out.println("============ TERIMAKASIH ============");
                            
                break;
                }
                
               
                } 
                
                    
                    }// perulangan pemesanan
        
        }
        
                class QuickSort {
    
    int partition(int arr[], int kecil, int besar) {
        
        int pivot = arr[besar];
        int i = (kecil - 1);

        for (int j = kecil; j < besar; j++) {


            if (arr[j] < pivot) {

                i++;
                int temp = arr[i];

                arr[i] = arr[j];
                arr[j] = temp;

            }

        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[besar];
        arr[besar] = temp;
        return i + 1;
    
    }}
                        
                    
