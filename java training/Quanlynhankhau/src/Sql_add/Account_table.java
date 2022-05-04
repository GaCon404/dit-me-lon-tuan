package Sql_add;

public class Account_table {
    public static void Add(Account_table account_table)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int stt;
    private String username,password;
    public Account_table(int stt,String username, String password){
        this.stt=stt;
        this.password=password;
        this.username=username;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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
