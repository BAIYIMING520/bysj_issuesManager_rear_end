package baiyiming.test.issues_manage.dto;

import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

import java.util.List;

public class GetUserNameAndDes {
    @JsonProperty("userNameAndDes")
    Page<List> uNameADes;

    @JsonProperty("meta")
    meta Meta;

    public Page<List> getuNameADes() {
        return uNameADes;
    }

    public void setuNameADes(Page<List> uNameADes) {
        this.uNameADes = uNameADes;
        for(List iter:uNameADes)
        {
            System.out.println(iter.toString());
        }
    }

    public meta getMeta() {
        return Meta;
    }
    public void setMeta(meta meta) {
        Meta = meta;
    }

    @Override
    public String toString() {
        return "GetUserNameAndDes{" +
                "uNameADes=" + uNameADes +
                ", Meta=" + Meta +
                '}';
    }
}
