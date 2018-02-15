package gov.usgs.wim.wdnr.transform;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;


public class MapToJsonTransformerTest {

    private static final String INIT_JSON = "[";
    private static final String END_JSON = "[]";
    private static final String WRITE_MAP = "{\"COUNTY\":\"Douglas\",\"BEACH_SEQ\":\"291\"," +
            "\"BEACH_NAME\":\"Wisconsin Point Beach 4\",\"MONITOR_SITE_SEQ\":\"230\",\"STATION_NAME\":\"N-S#4\"," +
            "\"WATER_BODY_TYPE\":\"pond\",\"WATERBODY_NAME\":\"Test Pond\"}";
    protected MockHttpServletResponse response;
    protected MapToJsonTransformer transformer;

    @Before
    public void beforeTest() throws IOException {
        response = new MockHttpServletResponse();
        transformer = new MapToJsonTransformer(response);
    }

    @After
    public void afterTest() throws Exception {
        transformer.close();
    }

    @Test
    public void initJsonTest() {
        transformer.initJson();
        try {
            transformer.g.flush();
            assertEquals(INIT_JSON, response.getContentAsString());
        } catch (IOException e) {
            fail(e.getLocalizedMessage());
        }
    }

    @Test
    public void writeMapTest() {
        transformer.writeMap(buildMap());
        try {
            transformer.g.flush();
            assertEquals(WRITE_MAP, response.getContentAsString());
        } catch (IOException e) {
            fail(e.getLocalizedMessage());
        }
    }

    @Test
    public void writeTwoRowsTest() {
        transformer.write(buildMap());
        transformer.write(buildMap());
        assertTrue(response.getHeaderNames().contains(MapToJsonTransformer.COUNT_HEADER_NAME));
        assertEquals("3", response.getHeader(MapToJsonTransformer.COUNT_HEADER_NAME));
        try {
            transformer.g.flush();
            assertEquals("["+WRITE_MAP+","+WRITE_MAP, response.getContentAsString());
        } catch (IOException e) {
            fail(e.getLocalizedMessage());
        }
    }

    @Test
    public void writeNullTest() {
        transformer.write(null);
        try {
            assertEquals("", response.getContentAsString());
        } catch (IOException e) {
            fail(e.getLocalizedMessage());
        }
        assertTrue(response.getHeaderNames().isEmpty());
    }

    @Test
    public void endTest() {
        transformer.initJson();
        transformer.end();
        try {
            assertEquals(END_JSON, response.getContentAsString());
        } catch (IOException e) {
            fail(e.getLocalizedMessage());
        }
    }

    @Test
    public void addResponseHeadersTest() {
        transformer.addResponseHeaders(buildMap());
        assertTrue(response.getHeaderNames().contains(MapToJsonTransformer.COUNT_HEADER_NAME));
        assertEquals("3", response.getHeader(MapToJsonTransformer.COUNT_HEADER_NAME));
    }

    @Test
    public void getValueTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("NotNull", "abc/");
        map.put("Null", null);
        assertEquals("abc/", transformer.getValue(map, "NotNull"));
        assertEquals("", transformer.getValue(map, "Null"));
        assertEquals("", transformer.getValue(map, "NoWay"));
    }

    public Map<String, Object> buildMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("COUNTY", "Douglas");
        map.put("BEACH_SEQ", "291");
        map.put("BEACH_NAME", "Wisconsin Point Beach 4");
        map.put("MONITOR_SITE_SEQ", "230");
        map.put("STATION_NAME", "N-S#4");
        map.put("WATER_BODY_TYPE", "pond");
        map.put("WATERBODY_NAME", "Test Pond");
        map.put("TOTAL_ROWS", "3");
        return map;
    }

}
