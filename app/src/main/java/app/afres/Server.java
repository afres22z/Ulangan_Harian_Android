package app.afres;

/**
 * Created by KUNCORO on 24/03/2017.
 */

public class Server {
    public static final String URL = "http://192.168.173.1/kuis/";


    //BAHASA
    public static final String URL_ADD_B="http://192.168.173.1/kuis/bahasa/tambahsoal.php";
    public static final String URL_GET_ALL_B = "http://192.168.173.1/kuis/bahasa/tampilSoal.php";
    public static final String URL_GET_EMP_B = "http://192.168.173.1/kuis/bahasa/tampil.php?id=";
    public static final String URL_UPDATE_EMP_B = "http://192.168.173.1/kuis/bahasa/update.php";
    public static final String URL_UPDATE_EMP_skor_B = "http://192.168.173.1/kuis/bahasa/updatescore.php";

    //mtk

    public static final String URL_ADD_M="http://192.168.173.1/kuis/mtk/tambahsoal.php";
    public static final String URL_GET_ALL_M = "http://192.168.173.1/kuis/mtk/tampilSoal.php";
    public static final String URL_GET_EMP_M= "http://192.168.173.1/kuis/mtk/tampil.php?id=";
    public static final String URL_UPDATE_EMP_M = "http://192.168.173.1/kuis/mtk/update.php";
    public static final String URL_UPDATE_EMP_skor_M = "http://192.168.173.1/kuis/mtk/updatescore.php";
    //inggris

    public static final String URL_ADD_BI="http://192.168.173.1/kuis/binggris/tambahsoal.php";
    public static final String URL_GET_ALL_BI = "http://192.168.173.1/kuis/binggris/tampilSoal.php";
    public static final String URL_GET_EMP_BI= "http://192.168.173.1/kuis/binggris/tampil.php?id=";
    public static final String URL_UPDATE_EMP_BI = "http://192.168.173.1/kuis/binggris/update.php";
    public static final String URL_UPDATE_EMP_skor_BI = "http://192.168.173.1/kuis/binggris/updatescore.php";
    //ipa
    public static final String URL_ADD_Ipa="http://192.168.173.1/kuis/ipa/tambahsoal.php";
    public static final String URL_GET_ALL_Ipa = "http://192.168.173.1/kuis/ipa/tampilSoal.php";
    public static final String URL_GET_EMP_Ipa= "http://192.168.173.1/kuis/ipa/tampil.php?id=";
    public static final String URL_UPDATE_EMP_Ipa = "http://192.168.173.1/kuis/ipa/update.php";
    public static final String URL_UPDATE_EMP_skor_Ipa= "http://192.168.173.1/kuis/ipa/updatescore.php";
    //ips
    public static final String URL_ADD_Ips="http://192.168.173.1/kuis/ips/tambahsoal.php";
    public static final String URL_GET_ALL_Ips = "http://192.168.173.1/kuis/ips/tampilSoal.php";
    public static final String URL_GET_EMP_Ips= "http://192.168.173.1/kuis/ips/tampil.php?id=";
    public static final String URL_UPDATE_EMP_Ips = "http://192.168.173.1/kuis/ips/update.php";
    public static final String URL_UPDATE_EMP_skor_Ips = "http://192.168.173.1/kuis/ips/updatescore.php";
    //ekonomi
    public static final String URL_ADD_E="http://192.168.173.1/kuis/ekonomi/tambahsoal.php";
    public static final String URL_GET_ALL_E = "http://192.168.173.1/kuis/ekonomi/tampilSoal.php";
    public static final String URL_GET_EMP_E= "http://192.168.173.1/kuis/ekonomi/tampil.php?id=";
    public static final String URL_UPDATE_EMP_E = "http://192.168.173.1/kuis/ekonomi/update.php";
    public static final String URL_UPDATE_EMP_skor_E = "http://192.168.173.1/kuis/ekonomi/updatescore.php";


    public static final String URL_GET_ALL_SISWA = "http://192.168.173.1/kuis/lihatsiswa.php";
    public static final String URL_GET_ALL_NILAI = "http://192.168.173.1/kuis/lihatnilai.php";
    public static final String URL_GET_ALL_NILAI_B = "http://192.168.173.1/kuis/lihatnilaibahasa.php";
    public static final String URL_GET_ALL_NILAI_I = "http://192.168.173.1/kuis/lihatnilaiipa.php";
    public static final String URL_GET_ALL_NILAI_IPS = "http://192.168.173.1/kuis/lihatnilaiips.php";
    public static final String URL_GET_ALL_NILAI_M = "http://192.168.173.1/kuis/lihatnilaimtk.php";
    public static final String URL_GET_ALL_NILAI_ing = "http://192.168.173.1/kuis/lihatnilaiinggris.php";
    public static final String URL_GET_ALL_NILAI_E = "http://192.168.173.1/kuis/lihatnilaiekonomi.php";
    public static final String URL_GET_ALL_LIHATSISWA = "http://192.168.173.1/kuis/lihatsiswasiswa.php?id=";
    public static final String URL_UPDATE_user = "http://192.168.173.1/kuis/edituser.php";
    public static final String URL_GET_NILAISISWA = "http://192.168.173.1/kuis/lihatnilaisiswa.php?id=";
    public static final String URL_GET_Nilaie = "http://192.168.173.1/kuis/lihatnilaiek.php?id=";
    public static final String URL_GET_Nilaim = "http://192.168.173.1/kuis/lihatnilaimt.php?id=";
    public static final String URL_GET_Nilaib = "http://192.168.173.1/kuis/lihatnilaib.php?id=";
    public static final String URL_GET_Nilaibi = "http://192.168.173.1/kuis/lihatnilaibi.php?id=";
    public static final String URL_GET_Nilaiia = "http://192.168.173.1/kuis/lihatnilaiia.php?id=";
    public static final String URL_GET_Nilaiis = "http://192.168.173.1/kuis/lihatnilaiis.php?id=";


    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_PERTANYAAN = "tanya";
    public static final String KEY_EMP_JAWABAN1 = "jawab1";
    public static final String KEY_EMP_JAWABAN2 = "jawab2";
    public static final String KEY_EMP_JAWABAN3 = "jawab3";
    public static final String KEY_EMP_JAWABANBENAR = "benar";
    public static final String KEY_EMP_skor = "skor";
    public static final String KEY_EMP_NAMA = "nama";
    public static final String KEY_EMP_KELAS = "kelas";

    public static final String KEY_EMP_paslam = "paslama";
    public static final String KEY_EMP_pasbar = "pasbaru";
    public static final String KEY_EMP_confirm = "confirm";
    public static final String KEY_EMP_user = "user";
    public static final String KEY_EMP_nis = "nis";



    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_TEMPAT = "tempat";
    public static final String TAG_TGL = "tgl";
    public static final String TAG_USER = "user";
    public static final String TAG_ID = "id";
    public static final String TAG_IDS = "ids";


    public static final String TAG_PERTANYAAN = "tanya";
    public static final String TAG_JAWABAN1 = "jawab1";
    public static final String TAG_JAWABAN2 = "jawab2";
    public static final String TAG_JAWABAN3 = "jawab3";
    public static final String TAG_JAWABANBENAR = "benar";
    public static final String TAG_NIS = "nis";
    public static final String TAG_NAMA= "nama";
    public static final String TAG_KELAS = "kelas";
    public static final String TAG_MTK = "mtk";
    public static final String TAG_IPA= "ipa";
    public static final String TAG_BAHASA = "bahasa";
    public static final String TAG_IPS = "ips";
    public static final String TAG_EKO= "eko";
    public static final String TAG_ING = "ing";


    public static final String EMP_ID = "emp_id";
    public static final String EMP_TANYA = "emp_tanya";



}
