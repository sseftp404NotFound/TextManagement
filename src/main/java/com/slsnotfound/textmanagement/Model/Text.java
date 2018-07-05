package com.slsnotfound.textmanagement.Model;

import lombok.Data;

@Data
public class Text {
    private int select;
    private int tID;//提案编号
    private String tName;//提案名称
    private int tWriterID;//提案作者编号
    private String tWriterName;//提案作者
    private String tText;//提案内容
    private String tSubmitTime;//提案提交时间
    private String tEndTime;//提案截止时间
    private int condition;//状态
    private int agree;//附议数
    private int disagree;//反对数

}
