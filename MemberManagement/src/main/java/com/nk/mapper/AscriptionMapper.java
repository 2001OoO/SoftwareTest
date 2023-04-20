package com.nk.mapper;

import com.nk.domain.Ascription;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AscriptionMapper {
    @Select("select * from ascription")
    public List<Ascription> ascription_List();

    @Insert("insert into ascription (name) values (#{name})")
    public int addAscription(String name);

    @Delete("delete from ascription where name=#{name}")
    public int deleteAscription(String name);
}
