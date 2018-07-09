package com.slsnotfound.textmanagement.Dao;
import com.slsnotfound.textmanagement.Model.Proposal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Param;


import java.util.List;
@Mapper
public interface ProposalDao {
    @Select("Select * From proposal;")
    List<Proposal> getAll();

    @Insert("Insert Into Text (tID，tName，tWriterID,tWriterName,tText，bDay，bMonth， bYear,eDay,eMonth,eYear) Values(#{tID}，#{tName}，#{tWriterID},#{tWriterName},#{tText}，#{bDay}，#{bMonth}，#{bYear},#{eDay},#{eMonth},#{eYear})")
    @Options(useGeneratedKeys = true, keyProperty = "tID")
    int insertProposal (Proposal proposal);

    @Select("Select * From Text Where tID=#{tID}")
    Proposal geyProposalByPid(@Param("tID") int tID);

    @Update("Update Text Set support=support+1 Where tID=#{tID}")
    void support(@Param("tID") int tID);

    @Update("Update Text Set reject=reject+1 Where tID=#{tID}")
    void reject(@Param("tID") int tID);
}
