package cloud.catisland.ivory.system.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloud.catisland.ivory.system.model.BO.ResultBean;
import cloud.catisland.ivory.common.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    @Resource
    private TopicService topicService;

    /**
     * 展示贴接口
     * @param pageNo
     * @param pageCount
     * @return
     */
    @GetMapping("/all")
    public ResultBean getTopics(
        @RequestParam("page") Integer pageNo
        ,@RequestParam("count") Integer pageCount
    ){
        LOGGER.info("giao!");

        return ResultBean.success(topicService.getTopicsPage(pageNo,pageCount,Sort.by(Direction.DESC , "tid")));
    }
}