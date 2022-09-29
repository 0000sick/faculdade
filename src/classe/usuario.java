
package classe;

import java.io.Serializable;

public class usuario implements Serializable {

    private String username;
    private Integer password;

    public usuario(String username, Integer password) {
        this.username = username;
        this.password = password;
    }

    public usuario() {
    
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
    
}
