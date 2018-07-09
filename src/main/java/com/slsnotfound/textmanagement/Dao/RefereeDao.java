package com.slsnotfound.textmanagement.Dao;
import com.slsnotfound.textmanagement.Model.Referee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RefereeDao {
    @Select("Select * From Referee Where Gid=#{Gid}")
    Referee geyProposalByPid(@Param("Gid") int Gid);

    @Insert("Insert Into Referee (reason) Values(#{reason}")
    @Options(useGeneratedKeys = true, keyProperty = "Gid")
    int insert(Referee referee);



}
