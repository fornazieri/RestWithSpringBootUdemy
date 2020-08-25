package br.com.vitorfornazieri.restwithspringbootudemy.serialization.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public final class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {

    public YamlJackson2HttpMessageConverter() {

        //super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
        //o .setSerializationInclusion(JsonInclude.Include.NON_NULL) serve para
        //quando o spring for inicializar o jackson e for serializar, se o objeto tiver nullo, ele não vai incluir na serialização
        //ou seja, não mostra o retorno da request com propriedades nulas
        super(new YAMLMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL), MediaType.parseMediaType("application/x-yaml"));
    }

}
