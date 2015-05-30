package com.tuneit.filterit.services;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by tegoo on 5/8/15.
 */
@RestController
@RequestMapping(value = "/api",  produces = MediaType.APPLICATION_JSON_VALUE)
@Api(basePath = "/", value = "api", description = "Filter-It Services", produces = "application/json")
public class FilterItRestController {

    private static final Log log = LogFactory.getLog(FilterItRestController.class);

    @RequestMapping(value = "/like/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Add Like")
    public void like(@ApiParam("A peace of html that is liked by user: actually a code of element") @RequestBody String item) {
        log.debug("--- like ---");
        log.debug("  item: " + item);
    }

    @RequestMapping(value = "/dislike/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Add Dislike")
    public void dislike(@ApiParam("A peace of html that is liked by user: actually a code of element") @RequestBody String item) {
        log.debug("--- dislike ---");
        log.debug("  item: " + item);
    }

    @RequestMapping(value = "/get/pattern/{resourceKey}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Pattern (XPath) for resource")
    public List<String> getPattern(@ApiParam("Resource key. For example, 'market-yandex'") @PathVariable("resourceKey") String resourceKey) {

        List<String> res = new ArrayList<>();

        if(resourceKey.matches("market-yandex")) {
            res.add("/html/body/div[1]/div[4]/div[2]/div[1]/div[1]/div/div[1]");
        }

        return res;
    }

    @RequestMapping(value = "/filter/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Filter elements: return list of IDs of elemets to delete (IDs are which is passed in request list)")
    public List<Long> filter(@ApiParam("A list of parsed elements, containing element ID and peace of html [{\"i\": \"0\", \"content\":\"...\"}]") @RequestBody List<Item> items) {
        List<Long> res = new ArrayList<>();

        Random rnd = new Random();

        int n = rnd.nextInt(items.size());
        for(int i = 0; i < n; i++) {
            res.add(items.get(rnd.nextInt(items.size())).getId());
        }

        return res;
    }

    public static class Item {

        private Long id;

        private String content;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


}
