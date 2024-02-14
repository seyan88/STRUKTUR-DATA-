# Final Proyek Struktur Data

<ul>
  <li>Mata Kuliah: Struktur Data</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Kelompok

<ul>
  <li>Kelompok: KELOMPOK 3</li>
  <li>Proyek: SISTEM PEMESANAN TIKET BIOSKOP</li>
  <li>Anggota:</li>
  <ul>
    <li>Ketua: <a href="">PEPI SEPTI APRILIANI</a></li>
    <li>Anggota 1: <a href="https://github.com/seyan88">SULASTIAN SETIADI</a></li>
    <li>Anggota 2: <a href="">SOFYAN MAULANA </a></li>
  </ul>
</ul>

## Judul Proyek
<p>SISTEM PEMESANAN TIKET BIOSKOP </p>

## Penjelasan Proyek
<h3>SISTEM PEMESANAN TIKET BIOSKOP </h3>
<p>    Sistem Pemesanan Tiket Bioskop yang kami buat bernama <b> BIOSKOP HEDON PLANET </b>, di sistem pemesanan tiket bioskop ini dapat memesan beberapa hal yaitu </p>
        <ol>
          <li>Memilih FILM</li>
          <li>Memilih Jam Tayang </li>
          <li>Memilih KURSI</li>
        </ol>
        <br>
        <p> pada jadwal penayangan film kami membuat  waktu penayangannya dari setiap film di beri jarak satu jam untuk memudahkan pegawai menyiapkan studio, dan dalam satu film dapat memilih jam sesuai keinginan costumer, di bawah merupakan purwarupa dari jadwal nya  </p>
<br>
<table border ="1">
  <tr>
    <th>No</th>
    <th>Film</th>
    <th>Jam 1</th>
    <th>Jam 2</th>
    <th>Jam 3</th>
    <th>Jam 4</th>
    <th>Jam 5</th>
    <th>Harga</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Siksa Neraka</td>
    <td>10.00</td>
    <td>13.00</td>
    <td>16.00</td>
    <td>19.00</td>
    <td>22.00</td>
    <td>35.000</td>
  </tr>
       <tr>
    <td>2</td>
    <td>172 Days</td>
    <td>11.00</td>
    <td>14.00</td>
    <td>17.00</td>
    <td>20.00</td>
    <td>23.00</td>
    <td>35.000</td>
  </tr>
       <tr>
    <td>3</td>
    <td>Ancika</td>
    <td>12.00</td>
    <td>15.00</td>
    <td>18.00</td>
    <td>21.00</td>
    <td>00.00</td>
    <td>35.000</td>
  </tr>
</table>
<br>
<p> kemudian terdapat beberapa harga khusus serta pelayanan yang sesuai dari setiap tiket yang sudah ada di bawah </p>
<br>
<table border ="1">
  <tr>
    <th>No</th>
    <th>Tiket</th>
    <th>harga</th>
  </tr>
  <tr>
    <td>1</td>
    <td>VIP</td>
    <td>harga tiket / 0,5 </td>
  </tr>
  <tr>
    <td>2</td>
    <td>Couple</td>
    <td>harga tiket / 0,7 </td>
  </tr>
  <tr>
    <td>3</td>
    <td>Reguler</td>
    <td>harga tiket / 1 </td>
  </tr>
</table>
<br>

<p>semua costumer nya sudah di data sebanyak 5 peserta dan setiap pesertanya sudah memilih tiket yang mereka pilih, kemudian setiap pesertanya akan di masukkan kedalam antrian di urutkan sesuai dengan jenis tiketnya. <br>

  <p>proses dari sitem bioskop ini bisa di bagi menjadi 3 bagian yaitu pemesanan, pembayaran, dan menampilkan riwayat </p>

  <ol type="1">
    <li> Pemesanan </li>
  <br>ketika program di mulai akan menampilkan nama bioskop dan di bawahnya ada nama costumer dan tiket yang di pilihnya, kemudian akan di minta untuk memasukkan pilihan film yang ingin di tonton, Setelah memilih film data akan mengammbil jam tayang sesuai dengan film yang sudah di pilih, kemudian akan di minta untuk memilih jam tayang nya. </p>
<br>
<p>  setelah itu akan menampilkan layout kursi bioskop yang tersedia, setelah menampilkan kursi akan di minta untuk memilih kursi sebelah mana yang ingin di pilih apakah kanan atau kiri?, setelah memilih kursi sebelah kanan atau kiri akan di tanya akan memesan berapa kursi, kemudian tinggal memasukan sesuai nama kursinya akan di lakukan pencarian daan ketika ketemu maka data kursi akan bernilai true yang sehingga tidak akan bisa di pesan lagi.  </p>
<br>
    <li>Pembayaran</li>
    <p>pada pembayaran ini jumlah kursi yang di pesan akan di kali kan dengan jumlah harga jumlah harga tiket, kemudian akan menampilkan jumlah yang harus di bayar, lalu akan  di minta memasukkan nominal yang di bayar, setelah itu apabila uang nya lebih maka akan menampilkan kembaliannya namun ketika kurang akan menampilka kurang nya berapa dan akan kembali untuk memasukan nominal yang harus dio bayar </p>
<br>
    <li> Riwayat</li>
    <p> setelah transaksi maka akan mangambil semua data mulai dari input pemilihan film sampai transaksi akan di masukkan ke linkedlist sehingga nanti di riwayat akan menampilkan transaksi yang sudah terjadi, na,um di pemilihakn kursi tidak di masukkkan ke dalam linkedlist yang sama karena terjadi error ketika di masukkan ke dalam linkedlist</p>
  </ol>
  
## Komponen Proyek
<p>Berikut beberapa komponen yang kami gunakkan</p>
<ol type="1"> 
  <li>Struktur  Data</li>
<ul>
  <li>record </li>
  <p>kami menggunakan struktur data record untuk menyimpan tipe data yang akan di gunakan</p>
  <li>arraysList</li>
  <p> kami menggunakan ArraysList untuk menyimpan data sesuai dengan record  </p>
  <li> Arrays 2 dimensi</li>
  <p>  Arrays 2 dimensi kami gunakan untuk untuk menyimpan data kursi yang natinya akan bisa di boking</p>
<li> searching</li>
<p> kami menggunakan metode searching untuk mencari variable yang sama di dalam arrays kursi sesuai dengan inputannya </p>
<li>Priority queue comparator</li>
<p> kami menggunakan priority queue comparator untuk megurutkan yang mana terlebih dahulu di layani </p>
<li>Linkedlist</li>
<p>Linkedlist ini kami ggunakan untuk menyimpan semua data dari inputan dan tipe data yang sudah di masukkan di record juga Arraylist</p>
  
</ul>
<li>Tipe Data</li>
<ul>
  <li>Film</li>
  <p>String namafilm, String jam1, String jam2, String jam3,String jam4, String jam5, int harga</p>
  <li>Pengunjung</li>
  <p>String nama, String tiket, int notiket, double harga</p>
  <li>pemesanan</li>
  <p>String nama, String tiket, String film, String jam , double harga, int bayar, double kembalian</p>
  <li>kursi</li>
  <p>String kursi</p>
  <li>kursi kanan</li>
  <p>String [][] kursikanan ={<br>
        {"F1","F2","F3","F4","F5"},<br>
        {"G1","G2","G3","G4","G5"},<br>
        {"H1","H2","H3","H4","H5"},<br>
        {"I1","I2","I3","I4","I5"},<br>
        {"J1","J2","J3","J4","J5"},<br>
    };</p>
  <li>kursi kiri</li>
  <p>String [][] kursikiri ={<br>
        {"A1","A2","A3","A4","A5"},<br>
        {"B1","B2","B3","B4","B5"},<br>
        {"C1","C2","C3","C4","C5"},<br>
        {"D1","D2","D3","D4","D5"},<br>
        {"E1","E2","E3","E4","E5"},<br>
    };</p>
</ul>
<li>looping</li>
<ul>
  <li>boolean</li>
<p>menggunakan boolean sebagai nilai true dan false untuk melakukan perulangan apa bila uang kurang, dan untuk menyimpan data di mana ketika kursi sudah di pesan kursinya akan bernilai true</p>
  <li>while </li>
  <p> di gunakan untuk mengulang kembali jika uang nya  kurang</p>
</ul>

</ol>


## Pembagian Tim
<pre><b>PEPI SEPTI APRILIANI</b> 
                        = Struktur Program
                        = pemilihan film
                        = pemilihan jam
                        = Penjelasan awal program
                        = = Editing Video</pre>
<pre><b>SULASTIAN SETIADI</b> 
                        = Arrays 2 dimensi -> kursikanan, kursikiri
                        = searching -> kursi
                        = pemesanan kursi
                        = Transaksi
                        = Linked List => Riwayat Transaksi
                        = Penjelasan akhir program 
                         </pre>
<pre><b>SOFYAN MAULANA</b>
                        = Record -> Film, Pengunjung, Pemesanan, kursi  
                        = Arraylist ->  film, jam
                        = Penjelasan running program</pre>
                        


## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/seyan88/STRUKTUR-DATA-/blob/main/APLIKASI_PEMESANAN_TIKET_BIOSKOP.java">Github</a></li>
  <li>Youtube: <a href="">Youtube</a></li>
</ul>
