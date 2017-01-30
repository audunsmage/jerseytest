package no.asom;

import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import static org.junit.Assert.*;

/**
 * Created by Audun on 30.01.2017.
 */
public class HelloWorldServiceTest extends JerseyTest {

    private static Tomcat t;
    private static final int TOMCAT_PORT = 9999;

//    @BeforeClass
//    public static void initier() throws Exception {
//        t = new Tomcat();
//        t.setBaseDir(".");
//        t.setPort(TOMCAT_PORT);
//    /* There needs to be a symlink to the current dir named 'webapps' */
//        t.addWebapp("/", "src/main/webapp");
//        t.init();
//        t.start();
//    }
//
//    @AfterClass
//    public static void shutDownTomcat() throws LifecycleException {
//        t.stop();
//    }
//
//    @Test
//    public void getMsg() throws Exception {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("http://localhost:8080/hello")
//                .get()
//                .addHeader("cache-control", "no-cache")
//                .addHeader("postman-token", "7ba6834e-851c-10ab-6a06-4af8afd52d85")
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//        System.out.println("response.message() = " + response.message());
//
//    }

    @Path("hello")
    public static class HelloResource {
        @GET
        public String getHello() {
            return "Hello World!";
        }
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(HelloResource.class);
    }

    @Test
    public void test() {
        final String hello = target("hello").request().get(String.class);
        assertEquals("Hello World!", hello);
    }

}