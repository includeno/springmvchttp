# SpringBoot Controller Usages

# Request

## Method: SpringBoot Supported

### @RequestMapping

No limit for request method

https://docs.spring.io/spring-framework/docs/5.2.12.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping



| PARAM    | TYPE             | NOTE                                                         |
| -------- | ---------------- | ------------------------------------------------------------ |
| value    | String[]         | 用于将指定请求的实际地址映射到方法上                         |
| name     | String           | 给映射地址制定一个别名                                       |
| method   | RequestMethod [] | HTTP method  GET,POST,HEAD,OPTIONS,PUT,PATCH,DELETE,TRACE    |
| consume  | String[]         | MediaType 指定处理请求提交的内容类型（Content-Type）,例如application/json,text/html等 |
| params   | String[]         | 指定request中必须包含某些参数值时，才让该方法进行处理        |
| produces | String[]         | Using a produces attribute to narrow the mapping by the content type. |
| headers  | String[]         | 指定request中必须包含某些指定的header值时，才让该方法进行处理 |



#### Method Usages:

Doc https://docs.spring.io/spring-framework/docs/5.2.12.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping-head-options

@RequestMapping(value = "/request",method =RequestMethod.GET)

Doc https://docs.spring.io/spring-framework/docs/5.2.12.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping-head-options

HEAD

@RequestMapping(value = "/request",method =RequestMethod.HEAD)

OPTIONS

@RequestMapping(value = "/request",method =RequestMethod.OPTIONS)

TRACE

@RequestMapping(value = "/request",method =RequestMethod.TRACE)

#### Consumes Usages:

Example "application/json"

Doc https://docs.spring.io/spring-framework/docs/5.2.12.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping-consumes

```
@PostMapping(path = "/pets", consumes = "application/json") 
public void addPet(@RequestBody Pet pet) {
    // ...
}
```



#### Produces Usages:

Example "application/json"

Doc https://docs.spring.io/spring-framework/docs/5.2.12.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping-produces

```
@GetMapping(path = "/pets/{petId}", produces = "application/json")
@ResponseBody
public Pet getPet(@PathVariable String petId) {
    
}
```



##### MediaType: 

MediaType provides constants for commonly used media types, such as APPLICATION_JSON_VALUE and

 APPLICATION_XML_VALUE

Example  

```
@GetMapping(path = "/pets/{petId}", produces =MediaType.APPLICATION_JSON_VALUE) 
@ResponseBody
public Pet getPet(@PathVariable String petId) {
    
}
```



| MediaType Values                  | String                            | NOTE          |
| --------------------------------- | --------------------------------- | ------------- |
| ALL_VALUE                         | `*/*`                             |               |
| APPLICATION_ATOM_XML_VALUE        | application/atom+xml              |               |
| APPLICATION_CBOR_VALUE            | application/cbor                  |               |
| APPLICATION_FORM_URLENCODED_VALUE | application/x-www-form-urlencoded | (MOST COMMON) |
| APPLICATION_JSON_VALUE            | application/json                  | (MOST COMMON) |
| APPLICATION_OCTET_STREAM_VALUE    | application/octet-stream          |               |
| APPLICATION_PDF_VALUE             | application/pdf                   |               |
| APPLICATION_PROBLEM_JSON_VALUE    | application/problem+json          |               |
| APPLICATION_PROBLEM_XML_VALUE     | application/problem+xml           |               |
| APPLICATION_RSS_XML_VALUE         | application/rss+xml               |               |
| APPLICATION_STREAM_JSON_VALUE     | application/stream+json           |               |
| APPLICATION_XHTML_XML_VALUE       | application/xhtml+xml             |               |
| APPLICATION_XML_VALUE             | application/xml                   |               |
| IMAGE_GIF_VALUE                   | image/gif                         |               |
| IMAGE_JPEG_VALUE                  | image/jpeg                        |               |
| IMAGE_PNG_VALUE                   | image/png                         | (MOST COMMON) |
| MULTIPART_FORM_DATA_VALUE         | multipart/form-data               | (MOST COMMON) |
| MULTIPART_MIXED_VALUE             | multipart/mixed                   |               |
| MULTIPART_RELATED_VALUE           | multipart/related                 |               |
| TEXT_EVENT_STREAM_VALUE           | text/event-stream                 |               |
| TEXT_HTML_VALUE                   | text/html                         |               |
| TEXT_MARKDOWN_VALUE               | text/markdown                     |               |
| TEXT_PLAIN_VALUE                  | text/plain                        |               |
| TEXT_XML_VALUE                    | text/xml                          |               |



### Particular Mapping

@GetMapping =@RequestMapping(method =RequestMethod.GET)

@PostMapping =@RequestMapping(method =RequestMethod.POST)

@PutMapping =@RequestMapping(method =RequestMethod.PUT)

@DeleteMapping =@RequestMapping(method =RequestMethod.DELETE)

@PatchMapping =@RequestMapping(method =RequestMethod.PATCH)

Example:

@GetMapping(value = "/request")

@PostMapping (value = "/request")

@PutMapping (value = "/request")

@DeleteMapping (value = "/request")

@PatchMapping (value = "/request")

## Param

@RequestParam



# Response