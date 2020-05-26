package cloud.catisland.ivory.system.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.catisland.ivory.system.model.BO.ResultBean;
import cloud.catisland.ivory.common.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Resource
    private TopicService topicService;

    @GetMapping("/all")
    public ResultBean getAlltopic(){

        return ResultBean.success("666");
    }
}