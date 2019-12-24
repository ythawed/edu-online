package com.ygq.edu.service;

import com.ygq.edu.domain.Video;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 视频服务接口
 * @author ythawed
 * @date 2019/12/23 0023
 */
public interface VideoService {

    List<Video> findAll();

    Video findById(Integer id);

    int update(Video video);

    int delete(Integer id);

    int save(Video video);
}
