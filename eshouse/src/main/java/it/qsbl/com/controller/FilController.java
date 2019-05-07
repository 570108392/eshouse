package it.qsbl.com.controller;

import it.qsbl.com.utils.AliOSSUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("file")
@RestController
public class FilController {

    private AliOSSUtil ossClient =  new AliOSSUtil();
    //处理文件上传
    @PostMapping("imageUpload")
    public Map<String, Object> imageUpload(HttpServletRequest request, @RequestParam("file")MultipartFile file) {
        Map<String, Object> value = new HashMap<String, Object>();
        value.put("success", true);
        value.put("errorCode", 200);
        value.put("errorMsg", "");
        try {
            String head = this.updateHead(file, 4);//此处是调用上传服务接口，4是需要更新的userId 测试数据。
            System.out.println("上传图片地址为"+head);
            value.put("data", head);
        } catch (IOException e) {
            e.printStackTrace();
            value.put("success", false);
            value.put("errorCode", 400);
            value.put("errorMsg", "图片上传失败");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public String updateHead(MultipartFile file, long userId) throws Exception {
        if (file == null || file.getSize() <= 0) {
            throw new Exception("头像不能为空");
        }
        String name = ossClient.uploadImg2Oss(file);
        String imgUrl = ossClient.getImgUrl(name);
        //userDao.updateHead(userId, imgUrl);//只是本地上传使用的
        return imgUrl;
    }
}
