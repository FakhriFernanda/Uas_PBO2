package Model;

public class Barang {
    private String kode_barang;
    private String nama_barang;
    private Integer jumlah_barang;
    private Integer harga_sewa;

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Integer getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(Integer jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    public Integer getHarga_sewa() {
        return harga_sewa;
    }

    public void setHarga_sewa(Integer harga_sewa) {
        this.harga_sewa = harga_sewa;
    }

    public Barang() {
    }

    public Barang(String kode_barang, String nama_barang, Integer jumlah_barang, Integer harga_sewa) {
        this.kode_barang = kode_barang;
        this.nama_barang = nama_barang;
        this.jumlah_barang = jumlah_barang;
        this.harga_sewa = harga_sewa;
    }
    
    
}
