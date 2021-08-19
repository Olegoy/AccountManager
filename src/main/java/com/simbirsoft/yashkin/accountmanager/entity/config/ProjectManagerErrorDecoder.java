package com.simbirsoft.yashkin.accountmanager.entity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simbirsoft.yashkin.accountmanager.entity.config.model.ErrorMessage;
import com.simbirsoft.yashkin.accountmanager.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;

@Primary
    @Component
    public class ProjectManagerErrorDecoder implements ErrorDecoder {

        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public Exception decode(String s, Response response) {
            ErrorMessage errorMessage;
            try {
                errorMessage = objectMapper.readValue(response.body().asReader(Charset.defaultCharset()), ErrorMessage.class);
            } catch (IOException e) {
                return new IOException(e);
            }
            int status = response.status();

            if (status == 404) {
                return new NotFoundException(errorMessage.getMessage());
            } else if (status >= 400 && status <= 599) {
                //return new BadRequestException(errorMessage);
            }

            return new RuntimeException();
        }
    }
