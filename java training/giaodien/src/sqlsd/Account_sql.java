package sqlsd;

/**
 *
 * @author Admin
 */
public class Account_sql {
    public static void Add(Account_sql account_table)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int stt;
    private String username,password;
    public Account_sql(int stt,String username, String password){
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
