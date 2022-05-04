public class AdminList {
    public static void add (AdminList list)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    int admin_id;
    String username, password;
    public AdminList(){};
    public AdminList(int admin_id, String username, String password)
    {
        this.admin_id= admin_id;
        this.password=password;
        this.username=username;
    }
    public AdminList(String username, String password)
    {

        this.password=password;
        this.username=username;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
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

