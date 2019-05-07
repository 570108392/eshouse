package it.qsbl.com.controller;

import it.qsbl.com.utils.Result;
import it.qsbl.com.utils.StatusEnum;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ExceptionController implements ErrorController {

    private static final String ErrorPath = "error";

    private ErrorAttributes errorAttributes;

    @Autowired
    public ExceptionController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return this.ErrorPath;
    }

    /**
     * 处理返回页面错误
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = ErrorPath,produces = {"text/html"} )
    public String errorHtml(HttpServletRequest request, HttpServletResponse response) {
        Integer status = response.getStatus();

        System.out.println("系统发生错误即将进行跳转到"+status+"页面");
        switch (status){
            case 403 :
                return "403";
            case 404 :
                return "404";
            case 500 :
                return "500";
        }
        return "404";
    }

    /**
     * 处理返回api接口数据
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = ErrorPath)
    @ResponseBody
    public Result error(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("系统调用API发生错误返回错误状态码");
        return Result.error(StatusEnum.getStatusEnumByStatus(response.getStatus()));
    }


    @RequestMapping("403")
    public String error_403(){
        System.out.println("对不起，您还没有权限访问他");
        return "403";
    }

}
