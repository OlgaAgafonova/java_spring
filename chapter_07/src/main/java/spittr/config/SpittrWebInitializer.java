package spittr.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;


public class SpittrWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }


   /*Параметры конструктора:
   - Куда загружать,
   - максимальный размер файла 2 MB,
   - максимальный размер файлов для запроса,
   - все файлы загружать на диск
   */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        File uploadFolders = new File("F:\\Andersen\\TMP\\spittr");
        uploadFolders.mkdirs();
        registration.setMultipartConfig(
                new MultipartConfigElement(uploadFolders.getAbsolutePath(), 2097152, 4194304, 0));
    }
}
