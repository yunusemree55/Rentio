package car_rental.demo.core.utilities.email;

import car_rental.demo.core.exceptions.BusinessException;
import car_rental.demo.core.utilities.messages.MessageService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;
import java.util.Map;

@Service
@AllArgsConstructor
public class EmailManager implements EmailService{

    private JavaMailSender mailSender;
    private TemplateEngine templateEngine;
    private MessageService messageService;

    @Async
    @Override
    public void sendHtmlMail(String to, String subject, String template, Map<String,Object> variables, Locale locale) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try{

            Context context = new Context(locale);
            context.setVariables(variables);

            String htmlBody = templateEngine.process(template, context);

            MimeMessageHelper htmlMail = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            String htmlSubject = messageService.getMessage(subject);

            htmlMail.setSubject(htmlSubject);
            htmlMail.setTo(to);
            htmlMail.setText(htmlBody,true);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new BusinessException(messageService.getMessage("error.email.message"));
        }

    }
}
