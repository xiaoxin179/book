package com.xiaoxin.bean;

import lombok.Data;

/**
 * @author:XIAOXIN
 * @date:2023/11/25
 **/
@Data
public class Staff {
    private int staff_id;
    private String staff_username;
    private String staff_name;
    private String role;
    private String staff_isdelete;
    private String password;
}
