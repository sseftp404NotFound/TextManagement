package com.slsnotfound.textmanagement.Dao;
import com.slsnotfound.textmanagement.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("Select uid,password From User;")
    List<User> GetUser();

    @Insert("Insert Into User (username,password,sex,address,tel,referrer,year,month,day,industry,committee) Values('username','password',sex,'address',tel,'referrer',year,month,day,'industry','committee')")
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    int insert(User user);
}
