package projek;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private ArrayList<Nasabah> listnasabah;

    public static final String gagalLogin = "Mohon Cek Username dan Password";

    public Bank() {
        listnasabah = new ArrayList<>();
    }

    public void bukaRekening(String nama, String username, int pin, int saldo){
        String idNasabah, idRekening;
        boolean cekNasabah;

        do{
            cekNasabah = false;
            idNasabah = generateRandomId();
            for(Nasabah nasabah: listnasabah){
                if(nasabah.getIdNasabah().equals(idNasabah)){
                    cekNasabah = true;
                    break;
                }
            }
        }while (cekNasabah);

        idRekening = idNasabah + generateRandomId();
        Nasabah nasabahbaru = new Nasabah(nama, username,pin,idNasabah);
        nasabahbaru.setRekening(new Rekening(saldo, idRekening));
        listnasabah.add(nasabahbaru);
        System.out.println("Berhasil Buka Rekening");
    }

    public Nasabah login(String username, int pin){
        for(Nasabah cekNasagbah: listnasabah){
            if (cekNasagbah.getUsername().equals(username) && cekNasagbah.getPin() == pin){
                System.out.println("Berhasil Login");
                return cekNasagbah;
            }
        }
        return null;
    }

    public String transfer(String idPenerima, String idPegrim, int jumlah) {
        Nasabah nasabah = null;
        int saldo = 0;
        boolean sukses = false;
        for(Nasabah pengirim: listnasabah){
            if (pengirim.getRekening().getIdRekening().equals(idPegrim)){
                nasabah = pengirim;
                saldo = pengirim.getRekening().penarikan(jumlah);
                break;
            }
        }
        for (Nasabah penerima: listnasabah){
            if (penerima.getRekening().getIdRekening().equals(idPenerima)){
                penerima.getRekening().tambahSaldo(jumlah);
                sukses = true;

            }
        }
        if (!sukses){
            nasabah.getRekening().tambahSaldo(saldo);
            return "Id Penerima Tidak Ada";
        }
        return "Transfer Berhasil";
    }

    public ArrayList<Nasabah> getListnasabah() {
        return listnasabah;
    }

    private String generateRandomId(){
        Random rnd = new Random();
        return String.valueOf(1000 + rnd.nextInt(9000));
    }

}