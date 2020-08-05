package com.andawell.material.utils;/**
 * @Date： 2020/6/8 8:58
 */

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/6/8 08:58
 *@Description:
 */
public class CustomDateDeserialize extends JsonDeserializer<Date> {
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Date date=null;
        try {
            date=sdf.parse(jsonParser.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
