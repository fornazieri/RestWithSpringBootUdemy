package br.com.vitorfornazieri.restwithspringbootudemy.config;

import br.com.vitorfornazieri.restwithspringbootudemy.serialization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(new YamlJackson2HttpMessageConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        //para receber via extension por exemplo ...request/persons.json  .xml etc
        //http://localhost:8080/api/person/v1.json
        //http://localhost:8080/api/person/v1.xml
        //http://localhost:8080/api/person/v1.x-yaml
//        configurer.favorParameter(false)
//                .ignoreAcceptHeader(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML)
//                .mediaType("x-yaml", MEDIA_TYPE_YML);

        //via QUERY parameter, por exemplo ?mediaType=json   xml etc
        //http://localhost:8080/api/person/v1?mediaType=json
        //http://localhost:8080/api/person/v1?mediaType=xml
        //http://localhost:8080/api/person/v1?mediaType=x-yaml
//        configurer.favorPathExtension(false)
//                .favorParameter(true)
//                .parameterName("mediaType")
//                .ignoreAcceptHeader(true)
//                .useRegisteredExtensionsOnly(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML)
//                .mediaType("x-yaml", MEDIA_TYPE_YML);

        //via HEADER Parameter, passando como header pelo cabeçalho da request
        //Header Name: Accept
        //Value: application/json
        //Value: application/xml
        //Value: application/x-yaml
        //se YML, na hora de fazer POST precisa enviar o Header Param Content-Type = application/x-yaml no Postman
        configurer.favorPathExtension(false)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("x-yaml", MEDIA_TYPE_YML);
    }

}
