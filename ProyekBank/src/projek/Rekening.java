package projek;

import java.util.Random;

public class Rekening {
    private int saldo;
    private String idRekening;

    public Rekening(int saldo, String idRek) {
        this.saldo = saldo;
        this.idRekening = idRek;
    }

    public String getIdRekening() {
        return idRekening;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void tambahSaldo(int jumlah){
        saldo  = saldo + jumlah;
    }

    public int penarikan(int saldoPenarikan) {
        if (saldo>saldoPenarikan){
            saldo = saldo - saldoPenarikan;
            return saldoPenarikan;
        }
        return  0;
    }

    public void cekSaldo(){
        System.out.println("Saldo anda :" + getSaldo());
    }


}