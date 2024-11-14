package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * 用户头像地址
     */
    private String portrait;

    /**
     * 注册手机
     */
    private String phone;

    /**
     * 用户密码（可以为空，支持只用验证码注册、登录）
     */
    private String password;

    /**
     * 注册ip
     */
    private String regIp;

    /**
     * 是否有效用户
     */
    private Boolean accountNonExpired;

    /**
     * 账号是否未过期
     */
    private Boolean credentialsNonExpired;

    /**
     * 是否未锁定
     */
    private Boolean accountNonLocked;

    /**
     * 用户状态：ENABLE能登录，DISABLE不能登录
     */
    private String status;

    /**
     * 是否删除
     */
    private Boolean isDel;

    /**
     * 注册时间
     */
    private Date createTime;

    /**
     * 记录更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户昵称
     */
    public String getName() {
        return name;
    }

    /**
     * 用户昵称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 用户头像地址
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * 用户头像地址
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    /**
     * 注册手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 注册手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 用户密码（可以为空，支持只用验证码注册、登录）
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码（可以为空，支持只用验证码注册、登录）
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 注册ip
     */
    public String getRegIp() {
        return regIp;
    }

    /**
     * 注册ip
     */
    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    /**
     * 是否有效用户
     */
    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * 是否有效用户
     */
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * 账号是否未过期
     */
    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * 账号是否未过期
     */
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * 是否未锁定
     */
    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     * 是否未锁定
     */
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    /**
     * 用户状态：ENABLE能登录，DISABLE不能登录
     */
    public String getStatus() {
        return status;
    }

    /**
     * 用户状态：ENABLE能登录，DISABLE不能登录
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 是否删除
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * 是否删除
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 记录更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 记录更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPortrait() == null ? other.getPortrait() == null : this.getPortrait().equals(other.getPortrait()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRegIp() == null ? other.getRegIp() == null : this.getRegIp().equals(other.getRegIp()))
            && (this.getAccountNonExpired() == null ? other.getAccountNonExpired() == null : this.getAccountNonExpired().equals(other.getAccountNonExpired()))
            && (this.getCredentialsNonExpired() == null ? other.getCredentialsNonExpired() == null : this.getCredentialsNonExpired().equals(other.getCredentialsNonExpired()))
            && (this.getAccountNonLocked() == null ? other.getAccountNonLocked() == null : this.getAccountNonLocked().equals(other.getAccountNonLocked()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPortrait() == null) ? 0 : getPortrait().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRegIp() == null) ? 0 : getRegIp().hashCode());
        result = prime * result + ((getAccountNonExpired() == null) ? 0 : getAccountNonExpired().hashCode());
        result = prime * result + ((getCredentialsNonExpired() == null) ? 0 : getCredentialsNonExpired().hashCode());
        result = prime * result + ((getAccountNonLocked() == null) ? 0 : getAccountNonLocked().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", portrait=").append(portrait);
        sb.append(", phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append(", regIp=").append(regIp);
        sb.append(", accountNonExpired=").append(accountNonExpired);
        sb.append(", credentialsNonExpired=").append(credentialsNonExpired);
        sb.append(", accountNonLocked=").append(accountNonLocked);
        sb.append(", status=").append(status);
        sb.append(", isDel=").append(isDel);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}