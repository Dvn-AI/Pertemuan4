Pada pertemuan kali ini, saya diberikan tugas untuk membuat try-catch, throw, custom exception, dan menghubungkan database PostgreSQL ke Java Netbeans. Berikut penjelasan mengenai tugas saya.

A. Menghubungkan database PostgreSQL ke Java Netbeans

- download JDBC Connector dari website official PostgreSQL
- ekstrak file postgresql.jar yang sudah didownload
- buat database pada app PostgreSQL, lalu buat tabel
- beralih pada Netbeans, buat project baru yang akan digunakan sebagai uji coba untuk menghubungkan database PostgreSQL pada Java Netbeans. Setelah itu klik kanan pada project tersebut, lalu pilih ‘Properties’.
- pilih ‘Libraries’, lalu pada bagian Classpath klik tombol +
- Pilih opsi “ADD JAR/Folder” setelah itu pilih folder yang berisikan JDBC PostgreSQL, klik satu kali pada file postgresql.jar kemudian klik ‘open’.
- Buat class baru untuk meng-handle koneksi database
- Lalu buat method-method CRUD untuk memasukkan data dari java ke database postgreSQL
B. Membuat try-catch dan throw

Buat class baru
saya mendeklarasikan variabel a, b, c dengan tipe data ‘int’. Variabel a dan b akan digunakan sebagai pembilang(a) dan pembagi(b), sedangkan varibabel c sebagai hasil dari operasi pembagian.
Tambahkan blok try-catch, lalu tambahkan throw pada blok try-catch dengan menggunakan fungsi if

C. Membuat Custom Exception
- buat class exception 
- kemudian buat konstruktor, lalu isi dengan parameter String
- lalu buat method toString yang akan mengembalikan pesan error.
- selanjutnya buat method yang melempar method sebelumnnya jika data tidak valid
- kemudian membuat blok try catch di method main, lalu tambahkan method untuk memamnggil method didalam blok try 
- dan terakhir Panggil method didalam blok try.
