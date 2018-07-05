package com.slsnotfound.textmanagement.Model;

import lombok.Data;

@Data
public class TextRemark {
    private int Rid;  //评论人编号
    private String RName;   //评论人姓名
    private int RCondition;  //评论状态
    private String RText;     //评论内容
    private String RTime;//评论时间
}
