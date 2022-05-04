package Table;

public class quy_thieu_nhi {
    int stt,ho_khau_id;
    String ten_chu_ho;
    int so_dien_thoai,tien_quy_thieu_nhi;

    public quy_thieu_nhi(int stt, int ho_khau_id, String ten_chu_ho, int so_dien_thoai, int tien_quy_thieu_nhi) {
        this.stt = stt;
        this.ho_khau_id = ho_khau_id;
        this.ten_chu_ho = ten_chu_ho;
        this.so_dien_thoai = so_dien_thoai;
        this.tien_quy_thieu_nhi = tien_quy_thieu_nhi;
    }

    public quy_thieu_nhi(int ho_khau_id, String ten_chu_ho, int so_dien_thoai, int tien_quy_thieu_nhi) {
        this.ho_khau_id = ho_khau_id;
        this.ten_chu_ho = ten_chu_ho;
        this.so_dien_thoai = so_dien_thoai;
        this.tien_quy_thieu_nhi = tien_quy_thieu_nhi;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getHo_khau_id() {
        return ho_khau_id;
    }

    public void setHo_khau_id(int ho_khau_id) {
        this.ho_khau_id = ho_khau_id;
    }

    public String getTen_chu_ho() {
        return ten_chu_ho;
    }

    public void setTen_chu_ho(String ten_chu_ho) {
        this.ten_chu_ho = ten_chu_ho;
    }

    public int getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(int so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public int getTien_quy_thieu_nhi() {
        return tien_quy_thieu_nhi;
    }

    public void setTien_quy_thieu_nhi(int tien_quy_thieu_nhi) {
        this.tien_quy_thieu_nhi = tien_quy_thieu_nhi;
    }
}
