package com.slsnotfound.textmanagement.Model;

import lombok.Data;

@Data
public class Proposal {
    private int select;
    private int pid;//提案编号
    private String pname;//提案名称
    private int pwriterid;//提案作者编号
    private String pwritername;//提案作者
    private String ptext;//提案内容
    private String psubmittime;//提案提交时间
    private String pendtime;//提案截止时间
    private int pcondition;//状态
    private int psupport;//附议数
    private int preject;//反对数

}
