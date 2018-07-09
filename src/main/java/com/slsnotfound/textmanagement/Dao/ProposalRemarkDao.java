package com.slsnotfound.textmanagement.Dao;
import com.slsnotfound.textmanagement.Model.ProposalRemark;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ProposalRemarkDao {
    @Select("Select * From TextRemark;")
    List<ProposalRemark> getAll();

    @Insert("Insert Into TextRemark (Rid，RName，RText，Ryear，Rmonth，Rday) Values(#{Rid},#{RName},#{RText},#{Ryear},#{Rmonth},#{Rday})")
    @Options(useGeneratedKeys = true, keyProperty = "Rid")
    int insert(ProposalRemark proposalRemark);

}
