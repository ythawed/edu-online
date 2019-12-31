package com.ygq.edu.provider;

import com.ygq.edu.domain.Video;
import org.apache.ibatis.jdbc.SQL;

/**
 * Video实体类类构建的动态语句,实现按照传入的参数更新，其余参数不变。
 * 该类作为Mapper的注解类实现，相应的方法需要注解在mapper的方法上
 * @author ythawed
 * @date 2019/12/30 0030
 */
public class VideoProvider {

    public String updateVideo(final Video video){
        return new SQL() {{
            UPDATE("video");
            // 如果之前的title不为空，则将传入的title参数设置为列名
            if (video.getTitle() != null) {
                SET("title=#{title}");
            }
            if(video.getSummary()!=null){
                SET("summary=#{summary}");
            }
            if(video.getCoverImg()!=null){
                SET("cover_img=#{coverImg}");
            }
            if(video.getViewNum()!=null){
                SET("view_num=#{viewNum}");
            }
            if(video.getPrice()!=null){
                SET("price=#{price}");
            }
            if(video.getOnline()!=null){
                SET("online=#{online}");
            }
            if(video.getPoint()!=null){

                SET("point=#{point}");
            }

            WHERE("id=#{id}");
        }}.toString();
    }

}
