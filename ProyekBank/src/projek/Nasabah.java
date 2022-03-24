package projek;

public class Nasabah extends User{
    private String nama;
    private String idNasabah;
    private Rekening rekening;


    public Nasabah(String nama, String username, int pin, String idNasabah) {
        super(username, pin);
        this.nama = nama;
        this.idNasabah = idNasabah;
    }

    public String getNama() {
        return nama;
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public void setIdNasabah(String idNasabah) {
        this.idNasabah = idNasabah;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Rekening getRekening() {
        return rekening;
    }

    public void setRekening(Rekening rekening) {
        this.rekening = rekening;
    }
}