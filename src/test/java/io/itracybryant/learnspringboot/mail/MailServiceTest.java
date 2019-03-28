package io.itracybryant.learnspringboot.mail;

import io.itracybryant.learnspringboot.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName MailServiceTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/8 9:54
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendMail() {
        mailService.sendMail("itracybryant@163.com", "测试邮件", "springboot-starter-mail test!");
    }

    @Test
    public void testSendHtmlMail() {
        String html = "<html>\n" + "<body>\n" + "<h2>this is a html email</h2>\n" + "</body>\n" + "<html>";
        mailService.sendHtmlMail("itracybryant@163.com", "测试HTML邮件", html);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\test.txt";
        mailService.sendAttachmentsMail("itracybryant@163.com", "测试带附件的邮件", "test attachments mail", filePath);
    }

    @Test
    public void testSendHtmlInlineResourceMail() {
        String to = "itracybryant@163.com";
        String subject = "HTML标签内携带资源的邮件";
        String resId = "001";
        String resPath = "C:\\Users\\Administrator\\Desktop\\01.png";
        String content = "<html>\n" +
                "<body>\n" +
                "这是带图片的邮件<img src=\'resId:" +
                resId + "\'>" +
                "</body>\n" + "<html>";
        mailService.sendHtmlInlineResourceMail(to, subject, content, resPath, resId);
    }

    @Test
    public void testSendTemplateMail(){
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        mailService.sendTemplateMail("itracybryant@163.com","模板邮件",String.valueOf(code));
    }
}
