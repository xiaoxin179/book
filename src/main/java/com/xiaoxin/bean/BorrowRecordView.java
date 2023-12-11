package com.xiaoxin.bean;

import lombok.Data;

import java.sql.Date;

/**
 * @author:XIAOXIN
 * @date:2023/12/05
 **/
@Data
public class BorrowRecordView {
    private int record_id;
    private int record_readerid;
    private String username;
    private String book_name;
    private String is_return;
    private Date return_time;

}
