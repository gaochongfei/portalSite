package zy.news.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zy.news.web.zsys.bean.Page;
import zy.news.web.bean.DepartMent;
import zy.news.web.bean.NewsType;
import zy.news.web.bean.NoticeType;
import zy.news.web.service.ISettings;
import zy.news.web.zsys.bean.*;

import java.util.List;

/**
 * 系统设置
 *
 * @author maoko
 * @date 2020/2/23 22:29
 */
@RestController
@RequestMapping("/back/settings")
@ExcuteControllerDsrc("系统设置")
public class SettingsController {

    private final ISettings settingsService;

    @Autowired
    public SettingsController(ISettings settingsService) {
        this.settingsService = settingsService;
    }

    //region 新闻类型

    @PostMapping("/newsType/add")
    @ExcuteInterfaceDsrc("添加新闻类型")
    @ExcutePermission
    public void addNewsType(@RequestBody NewsType newsType) throws Exception {
        settingsService.addNewsType(newsType);
    }


    @PostMapping("/newsType/update")
    @ExcuteInterfaceDsrc("更新新闻类型")
    @ExcutePermission
    public void updateNewsType(@RequestBody NewsType newsType) throws Exception {
        settingsService.updateNewsType(newsType);
    }

    @PostMapping("/newsType/getTypes")
    @ExcuteInterfaceDsrc("分页获取新闻类型列表")
    @ExcutePermission
    public PageValuesResult<NewsType> getNewsType(@RequestBody Page page) throws Exception {
        return settingsService.getNewsType(page);
    }

    //endregion

    //region 通知类型

    @PostMapping("/noticeType/add")
    @ExcuteInterfaceDsrc("添加通知类型")
    @ExcutePermission
    public void addNoticeType(@RequestBody NoticeType noticeType) throws Exception {
        settingsService.addNoticeType(noticeType);
    }


    @PostMapping("/noticeType/update")
    @ExcuteInterfaceDsrc("更新通知类型")
    @ExcutePermission
    public void updateNoticeType(@RequestBody NoticeType noticeType) throws Exception {
        settingsService.updateNoticeType(noticeType);
    }

    @PostMapping("/noticeType/getTypes")
    @ExcuteInterfaceDsrc("分页获取通知类型列表")
    @ExcutePermission
    public PageValuesResult<NoticeType> getNoticeType(@RequestBody Page page) throws Exception {
        return settingsService.getNoticeType(page);
    }

    //endregion

    //region 部门

    @GetMapping("/dept/getDepartMents")
    @ExcuteInterfaceDsrc("获取部门列表")
    @ExcutePermission(userType = ExcuteUserType.游客)
    public List<DepartMent> getDepartMents() {
        return settingsService.getDepartMents();
    }

    //endregion
}
