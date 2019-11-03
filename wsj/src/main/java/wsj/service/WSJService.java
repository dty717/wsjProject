package wsj.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import wsj.domain.WSJContent;
//import delinInfoSystem.domain.Device;
import javax.annotation.Resource;

@Service
public class WSJService{
    
    private @Resource(name="WSJlist") List<WSJContent> wsjContents;
    
    //@Transactional
    public void clearWSJ() {
        wsjContents.clear();
    }
    
    //@Transactional
    public void addWSJ(String name, String url, String content) {
        wsjContents.add(new WSJContent(name, url, content));
    }
    
    //@Transactional
    public String[] showWSJ() {
        String[]titles=new String[wsjContents.size()];
        for(int i=0;i<titles.length;i++){
            titles[i]=wsjContents.get(i).getName();
        }
        return titles;
    }
    
    //@Transactional
    public String showArticle(String title) {
        int len=wsjContents.size();
        for(int i=0;i<len;i++){
            if(title.equals(wsjContents.get(i).getName())){
                return wsjContents.get(i).getContent();
            }
        }
        return "";
    }
    
}