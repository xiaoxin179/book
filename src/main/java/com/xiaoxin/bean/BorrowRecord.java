package com.xiaoxin.bean;

import lombok.Data;

/**
 * @author:XIAOXIN
 * @date:2023/12/05
 **/
@Data
public class BorrowRecord {
    private int record_id;
    private int readerid;
    private int record_bookid;
    private int record_isdelete;
    private String is_return;


}
