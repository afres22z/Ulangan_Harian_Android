<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable 
		$id = $_POST['id'];
		$username = $_POST['user'];
		$password_lama = $_POST['paslama'];
		$password_baru= $_POST['pasbaru'];
		$konf_password = $_POST['confirm'];
		//import file koneksi database 
		require_once('koneksi.php');
		//cek old password
		$query = "SELECT * FROM siswa where password='$password_lama'";
		$sql = mysql_query ($query);
		$hasil = mysql_num_rows ($sql);
		if (! $hasil >= 1) {
			echo'Password lama tidak sesuai!, silahkan ulang kembali!';	
		}
		//validasi data data kosong
		else if (empty($_POST['pasbaru']) || empty($_POST['confirm'])) {
			echo'Ganti Password Gagal! Data Tidak Boleh Kosong';    
		}
		//validasi input konfirm password
		else if (($_POST['pasbaru']) != ($_POST['confirm'])) {
			echo 'Ganti Password Gagal! Password dan Konfirm Password Harus Sama';    
		}
		else {
		//update data
			$query = "UPDATE siswa SET username='$username',
password='$password_baru' WHERE nis='$id'";
			$sql = mysql_query ($query);
			if ($sql) {
				echo 'Ganti Data Berhasil!';    
			} else {
				echo 'Ganti Data Gagal!';    
				}
		}
	}
?>
