package com.slsnotfound.textmanagement.Dao;
import com.slsnotfound.textmanagement.Model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("Select uid,password From User;")
    List<User> GetUser();

    @Insert("Insert Into User (username,password,sex,address,tel,referrer,year,month,day,industry,committee) Values('username','password',sex,'address',tel,'referrer',year,month,day,'industry','committee')")
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    int insert(User user);

    @Update("Update User Set (company='company',profession='profession',email='email',wechat='wechat' )Where uid=uid")
    int update(User user);

}
