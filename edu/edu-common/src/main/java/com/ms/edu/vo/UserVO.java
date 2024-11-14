package com.ms.edu.vo;

import com.ms.edu.entity.User;

/**
 * ClassName: UserVO
 * Package: com.ms.edu.user.vo
 * Description:
 *
 * @Author ms
 * @Create 2024/6/12 14:23
 * @Version 1.0
 */
public class UserVO extends User {

    private String newName;

    private Integer userId;

    private String newPwd;

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
