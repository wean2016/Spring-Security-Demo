package cn.wean2016.littleprojetct.dao;

import cn.wean2016.littleprojetct.domain.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @version V1.0.0
 * @Description
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017/8/2 10:06
 */
@Repository
@Mapper
public interface UserDao {
   UserEntity findByUserName(String username);
}
