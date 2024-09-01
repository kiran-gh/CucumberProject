package resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class writeProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("url","https://rahulnxttrendz.ccbp.tech/login");
        properties.setProperty("lpTitle","React App");
        properties.setProperty("username","rahul");
        properties.setProperty("password","rahul@2021");
        properties.setProperty("invalidUserName","rahu");
        properties.setProperty("invalidPassword","rahul@2022");
        properties.setProperty("emptyUserName","");
        properties.setProperty("emptyPassword","");
        properties.setProperty("invalidUserNameError","*invalid username");
        properties.setProperty("invalidPasswordError","*username and password didn't match");
        properties.setProperty("emptyCredentialsError","*Username or password is invalid");
        properties.setProperty("Invalid credentials","*invalid username");


        String filepath = System.getProperty("user.dir")+"\\example.properties";
        FileOutputStream file = new FileOutputStream(filepath);
        properties.store(file,"Sample data in properties file....");
        file.close();

    }
}
