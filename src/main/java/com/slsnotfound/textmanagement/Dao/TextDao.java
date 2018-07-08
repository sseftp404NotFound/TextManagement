package com.slsnotfound.textmanagement.Dao;
import com.slsnotfound.textmanagement.Model.Text;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TextDao {
    @Select("Select * From Text;")
    List<Text> getAllText();

    @Insert("Insert Into Text (tID，tName，tWriterID,tWriterName,tText，bDay，bMonth， bYear,eDay,eMonth,eYear) Values(#{tID}，#{tName}，#{tWriterID},#{tWriterName},#{tText}，#{bDay}，#{bMonth}，#{bYear},#{eDay},#{eMonth},#{eYear})")
    @Options(useGeneratedKeys = true, keyProperty = "tID")
    int insertText (Text text);
}
