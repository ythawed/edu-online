package com.ygq.edu.controller;

import com.ygq.edu.domain.Video;
import com.ygq.edu.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * 注意：：：：
 * 当使用@RestController时，方法不需要加@ResponseBody就可以往页面返回对象
 * 如果使用@Controller，则方法必须加@ResponseBody才可以往页面返回对象
 *
 * @author ythawed
 * @date 2019/12/21 0021
 */
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    private static Logger LOG = LoggerFactory.getLogger(VideoController.class);

    @Autowired(required = false)
    private VideoService videoService;

    /**
     * 1.对于不同的请求方式，可以使用对应的已封装的注解名称mapping，如GetMapping
     * //另一种写法@RequestMapping(value = "/all", method = RequestMethod.GET)
     * 2.加入分页设置
     * @param page 结果集分页后，指定定位到的当前页
     * @param size 当前页包含的数据条数
     */
    @GetMapping("/all")
    public List<Video> findAllVideos(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                     @RequestParam(value = "size",defaultValue = "10")Integer size) {
        return videoService.findAll();
    }

    /**
     * 根据id查询video。
     * 注解true，参数必须带id
     */
    @GetMapping("/{id}")
    public Video findOne(@PathVariable(value = "id",required = true) Integer id) {
        LOG.info("根据id查询视频，id={}", id);
        Video video = videoService.findById(id);
        LOG.info("根据id查询视频，结果={}", video);
        return video;
    }

}
