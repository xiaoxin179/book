package com.xiaoxin.bean;

import lombok.Data;

/**
 * @author:XIAOXIN
 * @date:2023/12/05
 **/
@Data
public class BookView {
    private  int book_id;
    private String book_name;
    private String category_name;
    private String book_content;
    private String room_number;
    private int bookshelf_id;
    private int book_isdelete;
}
