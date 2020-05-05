package baiyiming.test.issues_manage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class controllertest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void preparemysetting(){
        mvc= MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
        //如果要传入一个测试参数 可以使用session来进行模拟 如果你用session写话可以用来验证session是否已经被注册了 是否在服务器端已经登录
        //tablesTemple.setDate(new java.sql.Date(2020,4,9));
        //这里将user测试类装载到sessio中
        session.setAttribute("tablesId",16);
    }
    @Test
    public void myControllerTest() throws Exception{
        //这里是测试表生成 使用jpa自动部署表 记得需要更改properties中的数据
        mvc.perform(MockMvcRequestBuilders.get("/createDatainitial"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    //测试controller完成 接下来开是否能对数据库 进行测试
    //使用端口api测试类
    @Test
    public void SubPathResponseTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/getdata/gettables"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void testDataToIssues() throws Exception{
        ResultActions results = mvc.perform(
                        MockMvcRequestBuilders.get("/api/getdata/tableToissues")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                    .param("tablesId","16"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
//    测试成功 可以使用子路径方式进行映射
//    @Test
//    public void TestGetDesFunc() throws Exception{
//        ResultActions res =mvc.perform(
//                MockMvcRequestBuilders.post("/api/getdata/Des")
//                    .contentType(MediaType.APPLICATION_JSON)
//                        .param("queryInfo","{\"querypara\":\"1\",\"pageIndex\":0,\"pageSize\":5}")
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void TestGetDesFunc2() throws Exception{
//
//    }
}
