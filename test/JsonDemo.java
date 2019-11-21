package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaoXiong
 * @since 2019-11-13
 */
public class JsonDemo {


    public static void main(String[] args) {
        String str = "{processInstanceId=1194173795221372928, taskId=null, processCreateBy=null, operateUserId=null, businessId=63, currentTaskNodeId=endevent1, currentTaskNodeName=End, curProcessStatusMapping=null, currentTaskNodeMappingId=null, processCreateTime=2019-11-12 16:43:14, relateToMeList=[1111-1111], candidateUserList=null}";

//        str = str.replace('=', ':');

        Map<String, Object> map = new HashMap<>();

        Object parse = JSONObject.parse(str);


        map.put("testKey", parse);

        System.out.println("json map:" + JSON.toJSONString(map));

    }
}
