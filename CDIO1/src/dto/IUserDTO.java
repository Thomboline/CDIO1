package dto;

import java.util.List;

/**
 * Created by jonathanlarsen on 16/02/2017.
 */
public interface IUserDTO {

    void userDTO();
    int getUserID();
    void setUserID(int ID);
    String getUserName();
    void setUserName(String name);
    String getIni();
    void setIni(String ini);
    List <String> getRoles();
    void setRoles();
    String addRole();


}
