package com.xiaoxin.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author:XIAOXIN
 * @date:2023/11/30
 **/
@Data
public class Reader {
    private int readerId;
    private String username;
    private String name;
    private int score;
    private String password;
    private String readerEmail;
    private int readerIsDelete;
}
