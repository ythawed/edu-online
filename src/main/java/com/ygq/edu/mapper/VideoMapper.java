package com.ygq.edu.mapper;

import com.ygq.edu.domain.Video;
import com.ygq.edu.provider.VideoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ythawed
 * @date 2019/12/22 0022
 */
public interface VideoMapper {
    /**
     * 查询所有video
     *
     * @return videos
     * 因为数据库表的列名（带"_"）与实体类的驼峰类不一致，使用手动映射（可多个）
     * 也可以直接在配置文件中配置mybatis的功能
     */
    @Select("select * from video")
//    @Results({
//            @Result(column = "cover_img", property = "coverImg")
//    })
    List<Video> findAll();
    /**
     * 1. 注意sql写法，单引号的形式
     * 2. 使用@Options(..) 获取插入数据后的自增主键
     */
    //    @Insert("Insert into video ('title','summary','cover_img','view_num','price','create_time','online','point') values (#{title},#{summary},#{coverImg},#{viewNum},#{price},#{createTime},#{online},#{point})")
    @Insert("INSERT INTO `video` (`title`, `summary`, `cover_img`, `view_num`, `price`, `create_time`, `online`, `point`) VALUES (#{title},#{summary},#{coverImg},#{viewNum},#{price},#{createTime},#{online},#{point})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int save(Video video);
    /**
     * 根据id查询video
     *
     * @param id 视频id
     * @return 该唯一视频
     */
    @Select("select * from video where id=#{id}")
    Video findById(Integer id);

    /**
     *      该语句不再使用，更新效果是全覆盖更新，使用UpdateProvider实现部分更新
     *    //@Update("update video set title=#{title} where id=#{id}")
     *    指定动态语句VideoProvider类和该类具体的某个方法
     *    因为该类可以含多个方法，需指定具体
     */
    @UpdateProvider(type = VideoProvider.class,method = "updateVideo")
    int update(Video video);

    @Delete("delete from video where id=#{id}")
    int delete(Integer id);

}
