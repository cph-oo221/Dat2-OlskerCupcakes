package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User
{
    private String email;
    private String password;
    private String role;
    private int balance;

    public User(String username, String password, String role, int balance)
    {
        this.email = username;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public String getUsername()
    {
        return email;
    }

    public void setUsername(String username)
    {
        this.email = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUsername(), getPassword(), getRole());
    }

    @Override
    public String toString()
    {
        return "User{" +
                "e-mail='" + email + '\'' +
                ", kodeord='" + password + '\'' +
                ", rolle='" + role + '\'' +
                '}';
    }

    public int getId()
    {
        return -1;
    }

    public int setBalance(int balance)
    {
        this.balance = balance;
    }
}
