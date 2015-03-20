/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fao.fenix.faostat.gateway;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.apache.commons.collections.IteratorUtils;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.record.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.hssf.usermodel.*;
/*import org.apache.poi.xssf.usermodel.XSSFPivotTable;
 import org.apache.poi.xssf.usermodel.XSSFRow;
 import org.apache.poi.xssf.usermodel.XSSFSheet;
 import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 */
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * REST Web Service
 *
 * @author joyeuxroccaserra
 */
@Path("/DataSetConverter")
public class DataSetConverter {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ExportPOI
     */
    public DataSetConverter() {
    }

    /**
     * Retrieves representation of an instance of
     * org.fao.fenix.faostat.gateway.ExportPOI
     *
     * @return an instance of java.lang.String
     */
    @POST
  //  @Produces("application/vnd.ms-excel")
    public Response getHtml(
            @FormParam("data") String data, //  @PathParam("myJson") String myJson
            @FormParam("transformer") String transformer
            ) throws IOException {



        //String myJson2='{"<span class=\"ordre\">009</span>Armenia||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[463.515,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[476.283,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[499.264,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[519.341,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[544.396,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[546.36,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[564.178,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[592.082,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">009</span>Armenia||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[463.515,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[476.283,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[499.264,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[519.341,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[544.396,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[546.36,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[564.178,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[592.082,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">001</span>Afghanistan||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[4787.294,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[4053.238,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[4616.57,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[4740.636,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[4732.909,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[4806.951,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[4801.12,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[4594.889,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">001</span>Afghanistan||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[4787.294,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[4053.238,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[4616.57,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[4740.636,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[4732.909,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[4806.951,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[4801.12,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[4594.889,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">002</span>Albania||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[723.368,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[703.325,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[666.663,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[689.495,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[648.853,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[638.512,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[633.109,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[599.062,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">002</span>Albania||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[723.368,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[703.325,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[666.663,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[689.495,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[648.853,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[638.512,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[633.109,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[599.062,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">003</span>Algeria||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[3713.987,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[3711.115,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[3770.088,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[3778.617,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[3909.626,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[3977.336,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[4095.713,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[4185.47,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">003</span>Algeria||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[3713.987,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[3711.115,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[3770.088,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[3778.617,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[3909.626,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[3977.336,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[4095.713,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[4185.47,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">004</span>American Samoa||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[3.966,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[3.97,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">004</span>American Samoa||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[3.963,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[3.966,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[3.97,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">005</span>Andorra||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">005</span>Andorra||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[0,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">006</span>Angola||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[2732.512,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[2763.191,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[2767.319,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[2767.492,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[2510.385,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[2767.839,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[2798.197,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[2832.503,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">006</span>Angola||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[2732.512,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[2763.191,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[2767.319,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[2767.492,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[2510.385,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[2767.839,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[2798.197,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[2832.503,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">007</span>Antigua and Barbuda||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[20.233,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[20.81,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[21.107,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[21.448,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[21.877,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[21.889,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[21.889,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[22.017,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">007</span>Antigua and Barbuda||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[20.233,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[20.81,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[21.107,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[21.448,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[21.877,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[21.889,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[21.889,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[22.017,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">008</span>Argentina||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[40306.591,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[40368.596,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[39696.008,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[41395.903,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[41343.226,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[41086.223,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[41503.585,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[41615.7,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">008</span>Argentina||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[40306.591,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[40368.596,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[39696.008,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[41395.903,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[41343.226,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[41086.223,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[41503.585,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[41615.7,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">010</span>Australia||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[47195.422,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[46708.829,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[46520.2,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[44338.99,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[45462.688,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[45924.181,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[46111.645,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[45172.817,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">010</span>Australia||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[47195.422,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[46708.829,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[46520.2,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[44338.99,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[45462.688,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[45924.181,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[46111.645,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[45172.817,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">011</span>Austria||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[2238.633,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[2203.098,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[2169.807,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[2134.772,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[2100.988,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[2079.93,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[2074.845,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[2068.667,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">011</span>Austria||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[2238.633,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[2203.098,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[2169.807,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[2134.772,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[2100.988,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[2079.93,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[2074.845,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[2068.667,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">013</span>Bahamas||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[6.744,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[6.95,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[6.903,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[7.703,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[7.847,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[7.847,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[7.847,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[7.847,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">013</span>Bahamas||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[6.744,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[6.95,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[6.903,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[7.703,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[7.847,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[7.847,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[7.847,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[7.847,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">012</span>Azerbaijan||<span class=\"ordre\">1</span>Gross Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[2198.61,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[2299.159,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[2441.976,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[2576.24,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[2674.829,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[2747.886,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[2821.918,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[2883.904,"USD million","&nbsp;"],"label":"Sum of Value"}},"<span class=\"ordre\">012</span>Azerbaijan||<span class=\"ordre\">3</span>Net Capital Stock (constant 2005 prices)||<span class=\"ordre\">2</span>Livestock (Fixed Assets)":{"2000":{"sum":[2198.61,"USD million","&nbsp;"],"label":"Sum of Value"},"2001":{"sum":[2299.159,"USD million","&nbsp;"],"label":"Sum of Value"},"2002":{"sum":[2441.976,"USD million","&nbsp;"],"label":"Sum of Value"},"2003":{"sum":[2576.24,"USD million","&nbsp;"],"label":"Sum of Value"},"2004":{"sum":[2674.829,"USD million","&nbsp;"],"label":"Sum of Value"},"2005":{"sum":[2747.886,"USD million","&nbsp;"],"label":"Sum of Value"},"2006":{"sum":[2821.918,"USD million","&nbsp;"],"label":"Sum of Value"},"2007":{"sum":[2883.904,"USD million","&nbsp;"],"label":"Sum of Value"}}}';



        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet1");
  

        ObjectMapper mapperData = new ObjectMapper();

        JsonNode myData = mapperData.readTree(new String(data.getBytes(), Charset.forName("UTF-8")).replaceAll("\\?", ""));

        ObjectMapper mapperTransformer= new ObjectMapper();

        JsonNode myTransformer = mapperTransformer.readTree(new String(transformer.getBytes(), Charset.forName("UTF-8")).replaceAll("\\?", ""));

       
       
        Iterator<Entry<String, JsonNode>> nodeIterator = myData.get("data").getFields();
        String swUnit=myData.get("swUnit").asText();
        String swFlag=myData.get("swFlag").asText();
      
       

        while (nodeIterator.hasNext()) {        }


       

     
       
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        wb.write(baos);

        ResponseBuilder response = Response.ok(baos.toByteArray());

      
        return response.build();
    }
}
