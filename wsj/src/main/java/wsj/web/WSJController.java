package wsj.web; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import wsj.service.WSJService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Controller
public class WSJController {
    
    @Autowired
    Gson gson;

    @Autowired
    WSJService wsjService;
    
    @RequestMapping(value = { "clearWSJ"},produces = "application/json;charset=utf-8")
    @ResponseBody
    public String clearWSJ() {
        wsjService.clearWSJ();
        return "{\"state\":\"success\"}";
    }
    
    @RequestMapping(value = {"set"},produces = "application/json;charset=utf-8")
    @ResponseBody
    public String set(@RequestParam(value="name")String name,@RequestParam(value="value")String value) {
        System.out.println(name+":"+value);
        return "{\"state\":\"success\"}";
    }
    
    @RequestMapping(value = { "addWSJ"},produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addWSJ(@RequestParam("name")String name,@RequestParam("url")String url,@RequestParam("content")String content) {
        wsjService.addWSJ(name,url,content);
        return "Hello World!";
    }
    
    
    @RequestMapping(value = { "showWSJ"},produces = "application/json;charset=utf-8")
    @ResponseBody
    public String showWSJ() {
        return gson.toJson(wsjService.showWSJ());
    }
    
    @RequestMapping(value = { "showArticle"})
    @ResponseBody
    public String showArticle(@RequestParam(value="name")String title) {
        return wsjService.showArticle(title);
    }
}
