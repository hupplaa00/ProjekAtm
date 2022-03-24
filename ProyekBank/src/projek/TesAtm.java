package projek;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TesAtm {
    static Scanner sc = new Scanner(System.in);
    static Bank bank;
    static Nasabah nasabah = null;
    static boolean log = true;
    static String user ;
    static int pins;

    public static void main(String[] args) {

        bank = new Bank();

        do {
            log = Layanan();
            if (nasabah != null) {
                pilihLayanan();
            }
        }
        while (log);


    }

    private static boolean Layanan() {
        System.out.println("ATM Sejahtera");
        System.out.println("1. Buka Rekening baru");
        System.out.println("2. Login");

        System.out.print("Input Layanan: ");
        int menu = sc.nextInt();

        switch (menu) {
            case 1:
                BukaRekening();
                System.out.println();
                return true;
            case 2:
                nasabah = Login(bank);
                if (nasabah != null) {
                    return false;
                } else {
                    System.out.println(Bank.gagalLogin);
                    return true;
                }
            default:
                return false;
        }
    }

    private static void BukaRekening() {
        System.out.print("Masukan Nama anda: ");
        sc.nextLine();
        String nama = sc.nextLine();
        System.out.print("Masukan username baru: ");
        String username = sc.next();
        System.out.print("Masukan pin baru: ");
        int pin = sc.nextInt();
        System.out.print("Masukan Saldo Awal: ");
        int saldo = sc.nextInt();
        System.out.println();
        bank.bukaRekening(nama, username, pin, saldo);

    }

    private static Nasabah Login(Bank bank) {
        System.out.print("Masukan username: ");
        String username = sc.next();
        user= username;
        System.out.print("Masukan pin: ");
        int pin = sc.nextInt();
        pins = pin;
        System.out.println();
        return bank.login(username, pin);
    }

    private static void pilihLayanan() {
        boolean ulangLayanan = true;
        while (ulangLayanan){
            System.out.println("ID = " + nasabah.getRekening().getIdRekening());
            System.out.println("silahkan pilih layanan:");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Transfer");
            System.out.println("5. Logout");
            System.out.print("Input Layanan: ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    nasabah.getRekening().cekSaldo();
                    break;
                case 2:
                    System.out.print("masukan jumlah penarikan: ");
                    int jumlah = sc.nextInt();
                    int saldoPenarikan = nasabah.getRekening().penarikan(jumlah);
                    System.out.println("Berhasil Menarik " + saldoPenarikan);
                    System.out.println("Sisa Saldo " + nasabah.getRekening().getSaldo());
                    break;
                case 3:
                    System.out.print("masukan jumlah setoran: ");
                    int setoran = sc.nextInt();
                    nasabah.getRekening().tambahSaldo(setoran);
                    System.out.println("setoran berhasil saldo anda = "+nasabah.getRekening().getSaldo());
                    break;
                case 4:
                    System.out.print("masukan id Penerima: ");
                    String idP = sc.next();
                    System.out.print("jumlah yang ingin di kirim: ");
                    int saldo = sc.nextInt();
                    String hasilTranser = bank.transfer(idP, nasabah.getIdNasabah(), saldo);
                    System.out.println(hasilTranser);
                    break;
                case 5:
                    log=true;
                    nasabah = null;
                    return;
            }
            System.out.print("ingin melanjunkan transaksi?(ya/tidak): ");
            String cek = sc.next().toLowerCase(Locale.ROOT);
            System.out.println("");
            if (!cek.equals("ya")){
                ulangLayanan = false;
            }
        }

    }

}
//        for(Nasabah nasabah : bank.getListnasabah()){
//            System.out.println(nasabah.getNama() +" "+nasabah.getRekening().getSaldo());
//        }
//
//        System.out.print("masukan id Pengirim = ");
//        String idp = scan.next();
//        System.out.print("masukan id penerima = ");
//        String idpe = scan.next();
//        System.out.print("saldo = ");
//        int saldo = scan.nextInt();
//        System.out.println(bank.transfer(idpe, idp, saldo));
//        for(Nasabah nasabah : bank.getListnasabah()){
//            System.out.println(nasabah.getNama() +" "+nasabah.getRekening().getSaldo());