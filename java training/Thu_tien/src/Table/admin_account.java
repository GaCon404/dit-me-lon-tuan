package Table;

public class admin_account {
    int stt;
    String name;
    int cccd,phone_number;
    String username,password;

    public admin_account(int stt, String name, int cccd, int phone_number, String username, String password) {
        this.stt = stt;
        this.name = name;
        this.cccd = cccd;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
    }

    public admin_account(String name, int cccd, int phone_number, String username, String password) {
        this.name = name;
        this.cccd = cccd;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
    }

    public admin_account(int cccd, String password) {
        this.cccd = cccd;
        this.password = password;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCccd() {
        return cccd;
    }

    public void setCccd(int cccd) {
        this.cccd = cccd;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
