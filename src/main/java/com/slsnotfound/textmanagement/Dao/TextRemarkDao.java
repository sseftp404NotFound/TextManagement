package com.slsnotfound.textmanagement.Dao;
import com.slsnotfound.textmanagement.Model.TextRemark;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TextRemarkDao {
    @Select("Select * From TextRemark;")
    List<TextRemark> getAllTextRemark();

    @Insert("Insert Into TextRemark (Rid，RName，RText，Ryear，Rmonth，Rday) Values(Rid,'RName','RText',Ryear,Rmonth,Rday)")
    @Options(useGeneratedKeys = true, keyProperty = "Rid")
    int insertTextRemark (TextRemark textRemark);

}
