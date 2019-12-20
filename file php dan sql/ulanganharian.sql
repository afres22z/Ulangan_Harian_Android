-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 03 Nov 2018 pada 02.06
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ulanganharian`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bahasa`
--

CREATE TABLE `bahasa` (
  `id` int(5) NOT NULL,
  `soal` text NOT NULL,
  `a` text NOT NULL,
  `b` text NOT NULL,
  `c` text NOT NULL,
  `jawaban` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bahasa`
--

INSERT INTO `bahasa` (`id`, `soal`, `a`, `b`, `c`, `jawaban`) VALUES
(9, 'Membaca ekstensif dilaksanakan terutama dalam rangka....', 'menangkap yang tersirat di balik yang tersurat', 'menikmati keindahan karya sastra', 'meningkatkan ketajaman imajinasi', 1),
(7, 'Membaca yang mengandalkan singkatnya waktu yang dibutuhkan dan ketepatan pemahaman dinamakan membaca....', 'scanning', 'cepat', 'kritis', 2),
(8, 'pernyataan berikut merupakan cara untuk meningkatkan kemampuan membaca cepat, kecuali...', 'membaca maju', 'menerapkan teknik membaca secara efisien', 'membaca kata demi kata', 3),
(6, 'Hal yang tidak boleh dilakukan oleh moderator atau pemandu diskusi pada saat diskusi berlangsung adalah....', 'menegur penyanggah yang menguasai kesempatan', 'menegur penyaji yang berubah haluan', 'ikut memberikan tanggapan', 3),
(5, 'Berikut termasuk sopan santun dalam menyampaikan tanggapan adalah...', 'memberikan alasan yang masuk akal', 'tidak menunjukkan bagian yang ditanggapi', 'menggunakan bahasa yang kurang komunikatif', 1),
(4, 'Permasalahan yang akan disajikan dalam diskusi kelas disusun ke dalam bentuk...', 'artikel', 'laporan', 'makalah', 3),
(3, 'Hal-hal yang perlu dikerjakan oleh seorang penyaji dalam diskusi tertera di bawah ini, kecuali...', 'menjawab  tanggapan-tanggapan peserta diskusi', 'menulis notula tentang jalannya seminar', 'menyampaikan salam pembukaan', 2),
(2, 'Jika hendak mengungkapkan pendapat dalam suatu diskusi, perlu dilakukan persiapan seperti yang tertera pada pernyataan di bawah ini, kecuali...', 'latihan vokal sebelum hadir di forum di diskusi', 'mempelajari masalah yang akan didiskuskan', 'menyusun kalimat pendapat yang komunikatif', 1),
(1, 'Pernyataan yang benar tentang diskusi tertera di bawah ini, kecuali....', 'diskusi kelas dipandu oleh seorang guru', 'dalam diskusi peserta boleh mengajukan pertanyaan.', 'dalam diskusi meliputi moderator, penyaji, ddan notulis', 3),
(10, 'Berikut ini merupakan fungsi penulisan editorial, kecuali....', 'memperjelas berita', 'menambah latar belakang', 'memberikan saran', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `bahasainggris`
--

CREATE TABLE `bahasainggris` (
  `id` int(5) NOT NULL,
  `soal` text NOT NULL,
  `a` text NOT NULL,
  `b` text NOT NULL,
  `c` text NOT NULL,
  `jawaban` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bahasainggris`
--

INSERT INTO `bahasainggris` (`id`, `soal`, `a`, `b`, `c`, `jawaban`) VALUES
(4, 'I.........to the mall last week', 'went', 'go', 'gone', 1),
(1, 'I am sorry I do not know the answer, but I really wish I', 'know', 'knew', 'will know', 2),
(2, 'The batik dress mother gave me is old, its colour has faded Its refers to', 'mother', 'old', 'batik', 3),
(5, 'did you.......your friend last Sunday?', 'met', 'meet', 'ment', 1),
(6, 'I listen to everything........he saids', 'who', 'whose', 'which', 3),
(7, 'this semester I had to buy fifteen books,.........most of english', 'which is', 'which are', 'whom were', 2),
(3, 'I.......a fantastic film at the cinema last week', 'saw', 'seeing', 'see', 1),
(10, 'The woman begged the robber.......', 'he had better not take her money', 'do not take my money', 'not to take her money', 3),
(9, 'My sister, Siska has all her dresses made because.......', 'she likes sewing', 'she cannot sew at all', 'she cant offord to pay dressmaker', 2),
(8, 'the company hired ten new employees,.......some ofmen', 'which is', 'whom are', 'whom is', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `ekonomi`
--

CREATE TABLE `ekonomi` (
  `id` int(5) NOT NULL,
  `soal` text NOT NULL,
  `a` text NOT NULL,
  `b` text NOT NULL,
  `c` text NOT NULL,
  `jawaban` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `ekonomi`
--

INSERT INTO `ekonomi` (`id`, `soal`, `a`, `b`, `c`, `jawaban`) VALUES
(9, 'Menurut waktunya,menabung,ikut asuransi,dan dana pensiun merupakan kebutuhan', 'Pokok', 'Sekarang', 'Yang akan datang', 3),
(10, 'Kebutuhan individu dan kolektif merupakan pengklasifikasian kebutuhan berdasarkan', 'subjek', 'Sifat', 'wujud', 3),
(8, 'Kebutuhan manusia yang berhubungan dengan kondisi kejiwaan dan moral serta intelektual,disebut kebutuhan', 'Rohaniah', 'jasmani', 'materi', 1),
(7, 'Hubungan yang terjalin antara keluarga, teman bermain waktu kecil termasuk dalam kelompok', 'Paguyuban', 'patembayan', 'Kelompok primer', 3),
(6, 'Dibawah ini yang tidak termasuk masalah sosial  adalah', 'Prestasi remaja', 'Tawuran remaja', 'Konflik', 1),
(5, 'Hubungan yang terjalin antar pedagang dipasar merupakan contoh dari', 'Paguyuban', 'patembayan', 'kerumunan', 2),
(4, ' Suatu sikap mengakui adanya persamaan derajat, persamaan hak dan persamaan kewajiban sebagai sesama manusia disebut', 'Kesamaan', 'Perbedaan', 'Kesetaraan', 1),
(3, 'Masuknya produk asing mengancam industri di dalam negeri.industri elektronek,tekstil,dan sandal terpaksa gulung tikar.keadaan ini dapat menimbulkan', 'Kesenjangan pendapatan', 'Pengangguran', 'inflasi', 2),
(2, 'Menurut Al-krober, Pengolongan ras-ras yang penting didunia yaitu ', 'Autraloid, Malayan, mongoloid, Malanesa', 'Australoid, Mongoloid, Caucasoid, Negroid ', 'Farikan, Negrito, vedroid dan nordik', 2),
(1, 'Posisi atau kedudukan yang disandang seseorang dalam masyarakat disebut', 'Stuktur sosial', 'Status sosial', 'Peran sosial', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `ipa`
--

CREATE TABLE `ipa` (
  `id` int(5) NOT NULL,
  `soal` text NOT NULL,
  `a` text NOT NULL,
  `b` text NOT NULL,
  `c` text NOT NULL,
  `jawaban` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `ipa`
--

INSERT INTO `ipa` (`id`, `soal`, `a`, `b`, `c`, `jawaban`) VALUES
(1, 'Larutan sabun mampu mengemulsi kotoran yang melekat pada badan atau pakaian, oleh sebab itu sabun mempunyai sifat :', 'lemak', 'Membersihkan', 'Kesadahan', 2),
(2, 'Limbah yang berasal dari makhluk hidup disebut', 'limbah cair', 'limbah gas', 'limbah organik', 3),
(3, 'Secara umum, natural source (sumber pencemaran) dari pencemaran udara berasal dari :', 'Emisi pabrik', 'Letusan gunung berapi', 'Banjir', 2),
(4, 'Proses disinfeksi pada pengolahan limbah cair bertujuan untuk', 'Mengapungkan zat padat', 'Membunuh mikroorganisme patogen', 'Mengeringkan lumpur', 2),
(5, 'Metode pengolahan limbah cair yang paling efektif digunakan untuk menyingkirkan polutan berupa minyak atau lemak adalah', 'Penyaringan', 'Pengendapan', 'Pengapungan', 3),
(6, 'Berikut ini jenis limbah  yang dapat diatasi secara efektif dengan metode insinerasi adalah', 'Kertas, daun, kaca', 'Kertas, plastik, daun kering  ', 'Plastik, besi, sendok', 2),
(7, 'Peristiwa tertahannya atau terperangkapnya panas matahari dilapisan atmosfer bumi dan memantulkan kembali ke bumi disebut', 'Efek rumah kaca', 'hujan asam', 'pemanasan global', 1),
(8, 'Penyakit menular yang mempunyai gejala pembengkakan hati sehingga tubuh menjadi kuning disebut', 'hepatitis A', 'tifus', 'Disentri', 1),
(9, 'Berikut ini yang bukan merupakan gas berbahaya bagi manusia adalah', 'C02', 'C0', '02', 1),
(10, 'Proses pengolahan limbah B3 secara biologi yang menggunakan bakteri dan micro organisme untuk menguraikan limbah B3 adalah', 'Bioremediasi', 'Solidifikasi', 'Insinerasi', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `ips`
--

CREATE TABLE `ips` (
  `id` int(5) NOT NULL,
  `soal` text NOT NULL,
  `a` text NOT NULL,
  `b` text NOT NULL,
  `c` text NOT NULL,
  `jawaban` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `ips`
--

INSERT INTO `ips` (`id`, `soal`, `a`, `b`, `c`, `jawaban`) VALUES
(9, 'Menurut waktunya,menabung,ikut asuransi,dan dana pensiun merupakan kebutuhan', 'Pokok', 'Sekarang', 'Yang akan datang', 3),
(8, 'Kebutuhan manusia yang berhubungan dengan kondisi kejiwaan dan moral serta intelektual,disebut kebutuhan', 'Rohaniah', 'jasmani', 'materi', 1),
(6, 'Dibawah ini yang tidak termasuk masalah sosial  adalah', 'Prestasi remaja', 'Tawuran remaja', 'Konflik', 1),
(7, 'Hubungan yang terjalin antara keluarga, teman bermain waktu kecil termasuk dalam kelompok', 'Paguyuban', 'patembayan', 'Kelompok primer', 3),
(5, 'Hubungan yang terjalin antar pedagang dipasar merupakan contoh dari', 'Paguyuban', 'patembayan', 'kerumunan', 2),
(4, 'Suatu sikap mengakui adanya persamaan derajat, persamaan hak dan persamaan kewajiban sebagai sesama manusia disebut', 'Kesamaan', 'Perbedaan', 'Kesetaraan', 1),
(3, 'Masuknya produk asing mengancam industri di dalam negeri.industri elektronek,tekstil,dan sandal terpaksa gulung tikar.keadaan ini dapat menimbulkan', 'Kesenjangan pendapatan', 'Pengangguran', 'inflasi', 2),
(2, 'Menurut Al-krober, Pengolongan ras-ras yang penting didunia yaitu ', 'Autraloid, Malayan, mongoloid, Malanesa', 'Australoid, Mongoloid, Caucasoid, Negroid ', 'Farikan, Negrito, vedroid dan nordik', 2),
(1, 'Posisi atau kedudukan yang disandang seseorang dalam masyarakat disebut', 'Stuktur sosial', 'Status sosial', 'Peran sosial', 2),
(10, 'Kebutuhan individu dan kolektif merupakan pengklasifikasian kebutuhan berdasarkan', 'subjek', 'Sifat', 'wujud', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `matematika`
--

CREATE TABLE `matematika` (
  `id` int(5) NOT NULL,
  `soal` text NOT NULL,
  `a` text NOT NULL,
  `b` text NOT NULL,
  `c` text NOT NULL,
  `jawaban` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `matematika`
--

INSERT INTO `matematika` (`id`, `soal`, `a`, `b`, `c`, `jawaban`) VALUES
(9, 'Kelipatan 8 antara 40 dan 60 adalah....', '40,48,52 ', '42,50,58', ' 48,56', 3),
(8, 'yang bukan kelipatan 6 adalah....', '24', '30', '44', 3),
(7, 'Kelipatan 3 antara 20 dan 40 yang habis dibagi 4 adalah....', '2,24,36 ', '24,36', '36', 2),
(6, ' Kelipatan bilangan 3 adalah....', '0,3,6,9,12', '1,3,6,9,12', '3,6,9,12', 3),
(5, 'Pembagian di bawah ini adalah pembagian bersisa, kecuali...', '60 : 9', '90 : 18', '125 : 3', 2),
(4, '36 x 99 = (36 x n) - (36 x 1), nilai n =....', '5', '10', '100', 3),
(2, '100 x 45 x 4 = ....', '900', '1.800', '18.000', 3),
(3, '250 x 4 x 56 paling mudah diselesaikan dengan menggunakan sifat....', 'komulatif', 'asosiatif ', 'distributuf', 2),
(1, 'Penjumlahan 256 + 512 hasilnya sama dengan...', '256 - 512', '256 x 512', '512 + 256', 3),
(10, 'Faktor dari 51 adalah.....', '1,3,21,51 ', '1,3,17,51 ', '1,3,5,15,51', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `nilai`
--

CREATE TABLE `nilai` (
  `nis` int(20) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Nilaimtk` int(10) NOT NULL,
  `Nilaiipa` int(10) NOT NULL,
  `Nilaiips` int(10) NOT NULL,
  `Nilaibahasa` int(10) NOT NULL,
  `Nilaiinggris` int(10) NOT NULL,
  `Nilaiekonomi` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `nilai`
--

INSERT INTO `nilai` (`nis`, `Nama`, `Nilaimtk`, `Nilaiipa`, `Nilaiips`, `Nilaibahasa`, `Nilaiinggris`, `Nilaiekonomi`) VALUES
(10849471, 'Muhammad Rizki Anandayu', 90, 0, 100, 80, 0, 80),
(10849865, 'Siti Mutmainah', 50, 0, 80, 60, 0, 60),
(13060808, 'Ahmad Syarif Hidayattulloh', 80, 0, 70, 70, 0, 80),
(15448366, 'Lilis Holisah', 70, 0, 90, 90, 0, 50),
(16637358, 'Lutfiyana Agustin', 70, 0, 80, 90, 0, 70),
(17432982, 'Eka Safitri', 90, 0, 90, 80, 0, 50),
(17432990, 'Firli Hidayad', 60, 0, 70, 60, 0, 80),
(17516772, 'Zainal Abidin', 80, 0, 60, 80, 0, 90),
(18476156, 'Intan Wulandari', 60, 0, 50, 50, 0, 70),
(20502368, 'Aulia Dwi Oktafianisa', 70, 0, 70, 70, 0, 70),
(22075862, 'Ahmad Rozali', 70, 0, 80, 70, 0, 80),
(22075867, 'Indah Erfiani', 50, 0, 80, 70, 0, 70),
(22075868, 'Wildan Abdullah M Nur', 70, 0, 90, 60, 0, 60),
(22075875, 'Riyanda Yusuf', 70, 0, 90, 60, 0, 80),
(23540862, 'Bambang Suryadi', 80, 0, 80, 90, 0, 80),
(23733505, 'Khoirul Anwar', 90, 0, 70, 90, 0, 80),
(23831932, 'Saifa Sella Wulandari', 60, 0, 80, 80, 0, 60),
(23917604, 'Farid Fernando', 70, 0, 80, 90, 0, 60),
(23919185, 'Muhammad Zaenur Rofiq', 80, 0, 80, 90, 0, 70),
(25441805, 'Vira Aprilia', 90, 0, 80, 80, 0, 80),
(25869438, 'Siti Nurlaila', 80, 0, 30, 70, 0, 60),
(26349961, 'Muhammad Fauzan Dikri', 80, 0, 80, 50, 0, 70),
(27822348, 'Arif Hidayat', 90, 0, 80, 70, 0, 80),
(2014141688, 'Ahmad fatkhur rohman', 60, 50, 0, 20, 30, 40);

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `nis` int(12) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `tempat` varchar(30) NOT NULL,
  `tanggal` varchar(30) NOT NULL,
  `Alamat` varchar(100) NOT NULL,
  `kelas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`nis`, `username`, `password`, `nama`, `tempat`, `tanggal`, `Alamat`, `kelas`) VALUES
(10849471, '10849471', '241102', 'Muhammad Rizki Anand', 'Sekincau', '24/11/2002', 'Kebas Kanan', 'XI MIA'),
(10849865, '10849865', '160902', 'Siti Mutmainah', 'Tanggamus', '16/09/2002', 'Giham Sukamaju', 'XI MIA'),
(13060808, '13060808', '100501', 'Ahmad Syarif Hidayat', 'Batu Kebayan', ' 10/05/2001', 'Waspada', 'XI MIA'),
(15448366, '15448366', '011001', 'Lilis Holisah', 'Pampangan', '01/10/2001', 'Tiga Jaya', 'XI MIA'),
(16637358, '16637358', '170802', 'Lutfiyana Agustin', 'Sekincau', '17/08/2002', 'Talang Semarang', 'XI MIA'),
(17432982, '17432982', '100501', 'Eka Safitri', 'Giham Sukamaju', '10/05/2001', 'Tiga Jaya', 'XI MIA'),
(17432990, '17432990', '281201', 'Firli Hidayad', 'Giham Sukamaju', '28/12/2001', 'Kejadian', 'XI MIA'),
(17516772, '17516772', '110602', 'Zainal Abidin', 'Waspada', '11/06/2002', 'Kubuliku jaya', 'XI MIA'),
(18476156, '18476156', '081101', 'Intan Wulandari', 'Lampung Barat', '08/11/2001', 'Mekarsari', 'XI MIA'),
(20502368, '20502368', '241002', 'Aulia Dwi Oktafianis', 'Giham Sukamaju', '24/10/2002', 'Sekincau', 'XI MIA'),
(22075862, '22075862', '180201', 'Ahmad Rozali', 'Batu Kebayan', '18/02/2001', 'Kauman', 'XI MIA'),
(22075867, '22075867', '190202', 'Indah Erfiani', 'Lampung Barat', '19/02/2002', 'Palpatoh', 'XI MIA'),
(22075868, '22075868', '150602', 'Wildan Abdullah M Nur', 'Tiga Jaya', '15/06/2002', 'Giham Sukamaju', 'XI MIA'),
(22075875, '22075875', '150901', 'Riyanda Yusuf', 'Sinar Wangi', '15/09/2001', 'Palpatoh', 'XI MIA'),
(23540862, '23540862', '210302', 'Bambang Suryadi', 'Giham Sukamaju', '21/03/2002', 'Kubuliku Jaya', 'XI MIA'),
(23733505, '23733505', '120302', 'Khoirul Anwar', 'Mekarsari', '12/03/2002', 'Giham Sukamaju', 'XI MIA'),
(23831932, '23831932', '210802', 'Saifa Sella Wulandar', 'Talang Semarang', '21/08/2002', 'Tambak Jaya Sanyir', 'XI MIA'),
(23917604, '23917604', '100802', 'Farid Fernando', 'Giham Sukamaju', '10/08/2002', 'Batu Kebayan', 'XI MIA'),
(23919185, '23919185', '250500', 'Muhammad Zaenur Rofiq', 'Sekincau', '25/05/2000', 'Kubuliku Jaya', 'XI MIA'),
(25441805, '25441805', '040402', 'Vira Aprilia', 'Tiga Jaya', '04/04/2002', 'Sekincau Tua Atas', 'XI MIA'),
(25869438, '25869438', '300102', 'Siti Nurlaila', 'Tiga Jaya', '30/01/2002', 'Sekincau', 'XI MIA'),
(26349961, '26349961', '200502', 'Muhammad Fauzan Dikri', 'Sekincau', '20/05/2002', 'Waspada', 'XI MIA'),
(27822348, '27822348', '200602', 'Arif Hidayat', 'Batu Kebayan', '20/06/2002', 'Palpatoh', 'XI MIA'),
(2014141688, 'afres', 'afres', 'Ahmadfatkhurrohman', 'sekincau', '15/04/1993', 'sekincau', 'XI MIA');

-- --------------------------------------------------------

--
-- Struktur dari tabel `userguru`
--

CREATE TABLE `userguru` (
  `id` int(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `userguru`
--

INSERT INTO `userguru` (`id`, `username`, `password`) VALUES
(1, 'Guru', 'manis');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bahasa`
--
ALTER TABLE `bahasa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bahasainggris`
--
ALTER TABLE `bahasainggris`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ekonomi`
--
ALTER TABLE `ekonomi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ipa`
--
ALTER TABLE `ipa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ips`
--
ALTER TABLE `ips`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `matematika`
--
ALTER TABLE `matematika`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`nis`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`);

--
-- Indexes for table `userguru`
--
ALTER TABLE `userguru`
  ADD PRIMARY KEY (`id`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `nilai_ibfk_1` FOREIGN KEY (`nis`) REFERENCES `siswa` (`nis`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
