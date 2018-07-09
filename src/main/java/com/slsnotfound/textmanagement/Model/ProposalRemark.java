package com.slsnotfound.textmanagement.Model;

import lombok.Data;

@Data
public class ProposalRemark {
    private int rid;  //评论人编号
    private String rname;   //评论人姓名
    private int rcondition;  //评论状态
    private String rtext;     //评论内容
    private String rtime;//评论时间
}
